package org.tosca.blueprint;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class BPUtil {

	public static String readFile(String path) {
		String fileString = "";
		try {
			System.out.println("Reading Started :" + path);
			fileString = new String(Files.readAllBytes(Paths.get(path)));
			System.out.println("File Data : " + fileString);
		} catch (Exception e) {
			System.out.println("File Read Error. - " + e.getMessage());
		}
		return fileString;
	}

	public static boolean checkDirectory(String path) {
		return new File(path).exists();
	}

	public static List<String> getListOfFiles(String path) {
		List<String> fileData = new ArrayList<>();
		File folder = new File(path);
		File[] files = folder.listFiles();

		for (File file : files) {
			try {
				fileData.add(new String(FileUtils.readFileToByteArray(file)));
			} catch (IOException e) {
				System.out.println("File Read Error. - " + e.getMessage());
			}
		}

		return fileData;
	}
	
	
}
