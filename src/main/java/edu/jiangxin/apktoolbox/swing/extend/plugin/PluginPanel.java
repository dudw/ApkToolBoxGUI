package edu.jiangxin.apktoolbox.swing.extend.plugin;

import edu.jiangxin.apktoolbox.swing.extend.EasyPanel;
import edu.jiangxin.apktoolbox.swing.extend.listener.IPreChangeMenuCallBack;
import edu.jiangxin.apktoolbox.utils.Utils;

import java.io.File;

public abstract class PluginPanel extends EasyPanel implements IPlugin {
    @Override
    public boolean isNeedPreChangeMenu() {
        return true;
    }

    public void onPreChangeMenu(IPreChangeMenuCallBack callBack) {
        preparePlugin(callBack::onPreChangeMenuFinished);
    }

    @Override
    public void onChangingMenu() {
        initUI();
    }

    @Override
    public void preparePlugin(IPreparePluginCallback callBack) {
        PluginUtils.preparePlugin(getPluginFilename(), isPluginNeedUnzip(), callBack);
    }

    @Override
    public boolean isPluginNeedUnzip() {
        return false;
    }

    @Override
    public String getPluginStartupCmd() {
        String jarPath = Utils.getPluginDirPath() + File.separator + getPluginFilename();
        return "java -jar \"-Duser.language=en\" \"-Dfile.encoding=UTF8\" \"" + jarPath + "\"";
    }

    public abstract void initUI();
}
