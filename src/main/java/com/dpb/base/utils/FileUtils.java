package com.dpb.base.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;



public class FileUtils {
	public static final int DEFAULT_BLOCK_SIZE = 1024 * 32;

	public static boolean IS_WINDOWS = System.getProperty("os.name")
			.toLowerCase().startsWith("win");

	/**
	 * Read all content of the file into a byte array. Return content of file,
	 * null if the file is not valid.
	 */
	public static byte[] readBytes(String fileName) throws IOException {
		InputStream in = null;
		ByteArrayOutputStream bufOut = null;

		try {
			bufOut = new ByteArrayOutputStream((int) new File(fileName)
					.length());
			in = new FileInputStream(fileName);
			copyStream(in, bufOut);
			return bufOut.toByteArray();
		} finally {
			closeStream(in);
		}
	}

	public static byte[] readBytes(InputStream in) throws IOException {
		ByteArrayOutputStream bufOut = null;

		bufOut = new ByteArrayOutputStream(in.available());
		copyStream(in, bufOut);
		return bufOut.toByteArray();
	}

	public static void writeBytes(String filename, byte[] data, boolean append)
			throws IOException {

		InputStream in = null;
		OutputStream out = null;

		try {
			in = new ByteArrayInputStream(data);
			out = new FileOutputStream(filename, append);

			copyStream(in, out);
		} finally {
			closeStream(in);
			closeStream(out);
		}
	}

	public static void writeBytes(OutputStream outputStream, byte[] data)
			throws IOException {

		ByteArrayInputStream in = null;

		try {
			in = new ByteArrayInputStream(data);
			copyStream(in, outputStream);
		} finally {
			closeStream(in);
		}
	}

	public static String mergePath(String path, String anotherPath) {
		if (path == null) {
			return anotherPath;
		} else if (StringUtils.isEmpty(anotherPath) || anotherPath.equals(".")) {
			return path;
		} else {
			String mergedPath;
			String path1, path2;

			path1 = normalize(path);
			path2 = normalize(anotherPath);

			// Check ./
			while (path2.startsWith("./")) {
				path2 = path2.substring(2, path2.length());
			}

			if (path1.endsWith("/")) {
				path1 = path1.substring(0, path1.length() - 1);
			}

			// check ../
			while (path2.startsWith("../")) {
				if (path1 == null) {
					throw new RuntimeException("File name is invalid - `"
							+ path + "' + `" + anotherPath + "'.");
				}

				path1 = getParent(path1);
				path2 = path2.substring(3, path2.length());
			}

			if (path2.equals(".")) {
				return path1;
			}

			if (path2.equals("..")) {
				if (path1 == null) {
					throw new RuntimeException("File name is invalid - `"
							+ path + "' + `" + anotherPath + "'.");
				} else {
					return getParent(path1);
				}
			}

			if (path1 == null) {
				return "/" + path2;
			} else {
				mergedPath = path1 + "/" + path2;
				return StringUtils.replace(mergedPath, "//", "/");
			}
		}
	}

	public static void closeStream(InputStream in) {
		if (in != null) {
			try {
				in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void closeStream(OutputStream out) {
		if (out != null) {
			try {
				out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static final long copyStream(InputStream inputStream,
			OutputStream outputStream) throws IOException {

		return copyStream(inputStream, outputStream, -1);
	}

	public static long copyStream(InputStream in, OutputStream out, long length)
			throws IOException {

		byte buffer[] = new byte[DEFAULT_BLOCK_SIZE];
		long copiedLength = 0L;
		int readSize;
		int sizeToRead;

		while (true) {

			if (length < 0) {
				sizeToRead = buffer.length;
			} else {
				sizeToRead = (int) (length - copiedLength);
				if (sizeToRead > buffer.length) {
					sizeToRead = buffer.length;
				}
			}
			if (sizeToRead <= 0) {
				// assert(sizeToRead == 0);

				// Finished to read
				break;
			}

			readSize = in.read(buffer, 0, sizeToRead);

			if (readSize < 0) {
				break;
			} else if (readSize == 0) {
				int oneByte = in.read();
				if (oneByte < 0) {
					break;
				}
				if (out != null) {
					out.write(oneByte);
					out.flush();
				}
				copiedLength++;
			} else {
				if (out != null) {
					out.write(buffer, 0, readSize);
					out.flush();
				}
				copiedLength += readSize;
			}
		}
		return copiedLength;
	}

	public static String getRelativePath(File f, String homeDir) {
		return getRelativePath(f.getAbsolutePath(), homeDir);
	}

	public static String getRelativePath(String fullName, String homeDir) {
		String aFullName, aHomeDir;

		fullName = normalize(fullName);
		homeDir = normalize(homeDir);

		if (IS_WINDOWS) {
			aFullName = fullName.toLowerCase();
			aHomeDir = homeDir.toLowerCase();
		} else {
			aFullName = fullName;
			aHomeDir = homeDir;
		}

		if (!aHomeDir.endsWith("/")) {
			if (aFullName.equals(aHomeDir)) {
				return "";
			}
			aHomeDir = aHomeDir + "/";
		}
		if (aFullName.equals(aHomeDir)) {
			return "";
		} else if (aFullName.startsWith(aHomeDir)) {
			return fullName.substring(aHomeDir.length(), aFullName.length());
		} else {
			return null;
		}
	}

	public static String getRelPathStd(String fullName, String homeDir) {

		if (!fullName.endsWith("/")) {
			if (fullName.equals(homeDir)) {
				return "";
			}
			homeDir = homeDir + "/";
		}
		if (fullName.equals(homeDir)) {
			return "";
		} else if (fullName.startsWith(homeDir)) {
			return fullName.substring(homeDir.length(), fullName.length());
		} else {
			return null;
		}
	}

	public static String normalize(String fileName) {
		if (fileName == null) {
			return null;
		}
		fileName = StringUtils.replace(fileName, "\\", "/").trim();
		return fileName;
	}

	/**
	 * Delete a file or recursively deleted all contents in a directory
	 * 
	 * @param file
	 * @return boolean
	 */
	public static boolean deleteFile(File file) {
		if (file.isDirectory()) {
			File[] arr = file.listFiles();
			for (int i = 0; i < arr.length; i++)
				if (!deleteFile(arr[i]))
					return false;
		}
		return file.delete();
	}

	public static File findDirectory(String name) {
		while (name.length() > 0) {
			File f = new File(name);
			if (f.isDirectory())
				return f;
			int index = name.lastIndexOf(File.separator);
			if (index == -1)
				break;
			name = name.substring(0, index);
		}
		return null;
	}
	
	
	public static File[] listAllFiles(File dir,FileFilter filter){
		ArrayList list = new ArrayList();
		listAllFiles(dir, list, filter);
		return (File[]) list.toArray(new File[list.size()]);
	}

	private static void listAllFiles(File dir, ArrayList allFiles,
			FileFilter filter) {
		File[] files = dir.listFiles();

		if (files == null) {
			return;
		}
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				if (filter == null || filter.accept(files[i])) {
					allFiles.add(files[i]);
				}
			} else if (files[i].isDirectory()) {
				if (filter != null && filter.accept(files[i])) {
					allFiles.add(files[i]);
				}

				listAllFiles(files[i], allFiles, filter);
			}
		}
	}

	/**
	 * @return String[0] - Directory of fileName. String[1] - Pure name of
	 *         fileName
	 */
	public static String[] splitFileName(String fileName) {
		int index = -1;

		for (int i = fileName.length() - 1; i >= 0; i--) {
			char c = fileName.charAt(i);

			if (c == '/' || c == '\\') {
				index = i;
				break;
			}
		}
		if (index < 0) {
			return new String[] { null, fileName };
		} else {
			return new String[] { fileName.substring(0, index),
					fileName.substring(index + 1, fileName.length()) };
		}
	}

	public static String getParent(String fileName) {
		int index = -1;
		int len = fileName.length();
		char c;

		if (len <= 0) {
			return null;
		}

		c = fileName.charAt(len - 1);
		if (c == '/' || c == '\\') {
			fileName = fileName.substring(0, len - 1);
			len--;
		}

		for (int i = len - 1; i >= 0; i--) {
			c = fileName.charAt(i);
			if (c == '/' || c == '\\') {
				index = i;
				break;
			}
		}
		if (index < 0) {
			return null;
		} else {
			return fileName.substring(0, index);
		}
	}

	public static String getName(String fileName) {
		int len = fileName.length();
		char c;

		if (len <= 0) {
			return null;
		}
		c = fileName.charAt(len - 1);
		if (c == '/' || c == '\\') {
			fileName = fileName.substring(0, len - 1);
			len--;
		}

		for (int i = len - 1; i >= 0; i--) {
			c = fileName.charAt(i);

			if (c == '/' || c == '\\') {
				return fileName.substring(i + 1, len);
			}
		}
		return fileName;
	}

	public static boolean isSame(File f1, File f2) {

		if (f1 == f2) {
			return true;
		} else if ((f1 == null) || (f2 == null)) {
			return false;
		}

		String n1 = normalize(f1.getAbsolutePath());
		String n2 = normalize(f2.getAbsolutePath());

		if (IS_WINDOWS) {
			return n1.equalsIgnoreCase(n2);
		} else {
			return n1.equals(n2);
		}
	}

	public static boolean isChild(File child, File parent) {
		if (child.getParentFile() == null)
			return false;
		String n1 = child == null ? null : normalize(child.getParentFile()
				.getAbsolutePath());
		String n2 = parent == null ? null : normalize(parent.getAbsolutePath());
		// modified by Jim ,2003.8.13
		// modified by Jim 2003.9.19, fix bug of one file name if a prefix of
		// another, for example "a" and "abc";
		if (IS_WINDOWS) {
			return n1 != null
					&& n2 != null
					&& n1.toLowerCase().indexOf(n2.toLowerCase()) == 0
					&& (n1.length() == n2.length() || n1.charAt(n2.length()) == '/');
		} else {
			return n1 != null
					&& n2 != null
					&& n1.indexOf(n2) == 0
					&& (n1.length() == n2.length() || n1.charAt(n2.length()) == '/');
		}
	}

	public static boolean isChild(String child, String parent) {
		String n1 = child == null ? null : normalize(child);
		String n2 = parent == null ? null : normalize(parent);
		// modified by Jim ,2003.8.13
		// modified by Jim 2003.9.19, fix bug of one file name if a prefix of
		// another, for example "a" and "abc";
		if (IS_WINDOWS) {
			return n1 != null
					&& n2 != null
					&& n1.toLowerCase().indexOf(n2.toLowerCase()) == 0
					&& (n1.length() == n2.length() || n1.charAt(n2.length()) == '/');
		} else {
			return n1 != null
					&& n2 != null
					&& n1.indexOf(n2) == 0
					&& (n1.length() == n2.length() || n1.charAt(n2.length()) == '/');
		}

	}

	public static boolean isDrive(File file) {
		if (!IS_WINDOWS)
			return false;

		String s = file.getPath();
		if (s.indexOf(':') != 1)
			return false;

		char c = Character.toUpperCase(s.charAt(0));
		if (c < 'A' || c > 'Z')
			return false;

		int length = s.length();
		if (length == 2)
			return true;

		if (s.length() != 3)
			return false;

		return s.charAt(2) == File.separatorChar;
	}

}