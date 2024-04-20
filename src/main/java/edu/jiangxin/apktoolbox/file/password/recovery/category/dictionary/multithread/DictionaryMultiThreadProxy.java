package edu.jiangxin.apktoolbox.file.password.recovery.category.dictionary.multithread;

import edu.jiangxin.apktoolbox.file.core.EncoderDetector;
import edu.jiangxin.apktoolbox.file.password.recovery.RecoveryPanel;
import edu.jiangxin.apktoolbox.file.password.recovery.State;
import edu.jiangxin.apktoolbox.file.password.recovery.category.ICategory;
import edu.jiangxin.apktoolbox.file.password.recovery.checker.FileChecker;
import edu.jiangxin.apktoolbox.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class DictionaryMultiThreadProxy implements ICategory {
    private static final Logger logger = LogManager.getLogger(DictionaryMultiThreadProxy.class.getSimpleName());

    private BigFileReader bigFileReader;

    private String password;

    private final Object lock = new Object();

    private static class DictionaryMultiThreadProxyHolder {
        private static final DictionaryMultiThreadProxy instance = new DictionaryMultiThreadProxy();
    }

    private DictionaryMultiThreadProxy() {
    }

    public static DictionaryMultiThreadProxy getInstance() {
        return DictionaryMultiThreadProxy.DictionaryMultiThreadProxyHolder.instance;
    }

    private String startAndGet(RecoveryPanel panel) {
        CompleteCallback callback = password -> {
            synchronized (lock) {
                DictionaryMultiThreadProxy.this.password = password;
                lock.notifyAll();
            }
        };
        LineHandler lineHandler = new LineHandler(panel.getCurrentFileChecker(), new AtomicBoolean(false), panel, callback);
        String charsetName = EncoderDetector.judgeFile(panel.getDictionaryFile().getAbsolutePath());
        BigFileReader.Builder builder = new BigFileReader.Builder(panel.getDictionaryFile().getAbsolutePath(), lineHandler);
        bigFileReader = builder
                .withThreadSize(panel.getThreadNum())
                .withCharset(charsetName)
                .withBufferSize(1024 * 1024)
                .withOnCompleteCallback(callback)
                .build();
        bigFileReader.start();
        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            logger.error("wait InterruptedException");
            Thread.currentThread().interrupt();
        }
        return password;
    }

    @Override
    public void start(RecoveryPanel panel) {
        File dictionaryFile = panel.getDictionaryFile();
        if (!dictionaryFile.isFile()) {
            JOptionPane.showMessageDialog(panel, "Invalid dictionary file");
            return;
        }
        int fileLineCount = Utils.getFileLineCount(dictionaryFile);
        logger.info("File line count: " + fileLineCount);

        panel.setCurrentState(State.WORKING);
        panel.setProgressMaxValue(fileLineCount);
        panel.setProgressBarValue(0);

        String password = startAndGet(panel);
        panel.showResultWithDialog(password);
    }

    @Override
    public void cancel() {
        if (bigFileReader != null) {
            bigFileReader.shutdown();
        }
    }
}
