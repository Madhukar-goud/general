package com.madhukar.dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.common.collect.HashMultimap;

public class DictionaryUtils {

	private static HashMultimap<String, String> dictionaryMap ;
	
	public static HashMultimap<String, String>  getDictionaryMap(String path) throws IOException {
		if (dictionaryMap == null) {
			dictionaryMap = HashMultimap.create();
			loadDictionaryOnStartup(path);
		}
		return dictionaryMap;
	}
	
	private static void loadDictionaryOnStartup(String path) throws IOException {
		List<String> sheet = Files.readAllLines(Paths.get(path));
		int lineCount = 0;
		for (String strLine : sheet) {
			lineCount++;
			if (strLine.length() > 10)  {
				//System.out.println("Ignoring line number==>" + lineCount);
				continue;
			}
			String number = getNumberFromWord(strLine.toLowerCase());
			if (number != null) {
				dictionaryMap.put(number, strLine.toLowerCase());
			}
		}
		System.out.println("Lines processed ==> " + lineCount);
	}

	private static String getNumberFromWord(String strLine) {
		char[] chars = strLine.toCharArray();
		String numberFormat = "";
		for (char c: chars) {
			int num = getPhoneNumberEncoding(c);
			//System.out.println("Number is " + num +": For Char ==>" + c);
			if (num < 0) {
				return null;
			}
			numberFormat += num;
		}
		return numberFormat;
	}

	private static int getPhoneNumberEncoding(char c) {
		switch (c) {
		case 'a':
		case 'b':
		case 'c':
			return 2;
		case 'd':
		case 'e':
		case 'f':
			return 3;
		case 'g':
		case 'h':
		case 'i':
			return 4;
		case 'j':
		case 'k':
		case 'l':
			return 5;
		case 'm':
		case 'n':
		case 'o':
			return 6;
		case 'p':
		case 'q':
		case 'r':
		case 's':
			return 7;
		case 't':
		case 'u':
		case 'v':
			return 8;
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			return 9;
		default:
			return -1;
		}
	}
}
