package com.cagatayyapici.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextReader {
	/**
	 * big file reader
	 * 
	 * @param f
	 * @return
	 */
	public static String ReadLargeFiles(File f) {
		String text = "";
		int read, N = 1024 * 1024;
		char[] buffer = new char[N];

		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				read = br.read(buffer, 0, N);
				text += new String(buffer, 0, read);

				if (read < N) {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return text;
	}

	/**
	 * new File("samplefilename.txt")
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	public static List<Double> GetTestList(File file)
			throws FileNotFoundException {
		List<Double> retLst = new ArrayList<Double>();
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if (!line.equals(""))
				continue;
			retLst.add(Double.parseDouble(line));
		}
		return retLst;
	}

}
