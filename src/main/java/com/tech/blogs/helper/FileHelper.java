package com.tech.blogs.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileHelper {

	public static boolean deleteFile(String path) {
		boolean fileStatus = false;

		try {

			File file = new File(path);
			fileStatus = file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileStatus;
	}

	public static boolean saveFile(InputStream is, String path) {
		boolean saveFileStatus = false;
		try {
			byte b[] = new byte[is.available()];

			is.read(b);

			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);

			fos.flush();
			fos.close();
			saveFileStatus = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return saveFileStatus;
	}

}
