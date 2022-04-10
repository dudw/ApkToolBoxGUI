package edu.jiangxin.apktoolbox.crack;

import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;


public final class My7Zip extends Archiver {

	private static FileNameExtensionFilter filter = new FileNameExtensionFilter(
			"7-ZIP打包文件(*.7z)", "7z");


	@Override
	public final void doArchiver(File[] files, String destpath)
			throws IOException {
	}

	@Override
	public void doUnArchiver(File srcfile, String destpath, String password)
			throws IOException, WrongPassException {
	}

	@Override
	public final FileNameExtensionFilter getFileFilter() {
		return filter;
	}

}
