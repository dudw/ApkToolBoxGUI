package edu.jiangxin.apktoolbox.swing.extend;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import org.apache.commons.configuration2.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.jiangxin.apktoolbox.utils.Utils;

/**
 * @author jiangxin
 * @author 2018-09-09
 *
 */
public class EasyFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    protected Logger logger;
    protected Configuration conf;
    protected ResourceBundle bundle;

    public EasyFrame() throws HeadlessException {
        super();
        logger = LogManager.getLogger(this.getClass().getSimpleName());
        conf = Utils.getConfiguration();
        bundle = ResourceBundle.getBundle("apktoolbox");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Utils.saveConfiguration();
                logger.info("Frame stop: " + EasyFrame.this.getClass().getSimpleName());
            }
        });
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image image = tk.createImage(this.getClass().getResource("/icon.jpg"));
        setIconImage(image);
        logger.info("Frame start: " + this.getClass().getSimpleName());
    }

    public void refreshSizeAndLocation() {
        // use pack to resize the child component
        pack();
        setResizable(false);

        // relocation this JFrame
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        Toolkit kit = Toolkit.getDefaultToolkit();
        if (kit == null) {
            logger.error("kit is null");
            return;
        }
        Dimension screenSize = kit.getScreenSize();
        if (screenSize == null) {
            logger.error("screenSize is null");
            return;
        }
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
    }
}
