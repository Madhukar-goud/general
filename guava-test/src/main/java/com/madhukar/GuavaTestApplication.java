package com.madhukar;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.collect.HashMultimap;
import com.madhukar.dictionary.DictionaryUtils;

@SpringBootApplication
public class GuavaTestApplication {
	
	public static void main(String[] args) {
		try {
			Instant start, end;
			start = Instant.now();
			HashMultimap<String, String> map = DictionaryUtils.getDictionaryMap(".\\src\\main\\resources\\words.txt");
			end = Instant.now();
			System.out.println("map Size ==> " + map.size());
			System.out.println("Time taken to load dictionary in Milli seconds==> " + Duration.between(start, end).toMillis());
			
			printWordsForNumbers(map, "225563");
			int count = 0;
			for(String key: map.keys()) {
				//System.out.println(key);
				count++;
				if (count > 100) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void printWordsForNumbers(HashMultimap<String, String> map, String string) {
		int length = string.length();
		for (int i = 0; i < length;i++) {
			Set<String> firstStr = map.get(string.substring(0, i));
			Set<String> secondStr = map.get(string.substring(i, length));
			for (String fs: firstStr) {
				for (String ss : secondStr) {
					System.out.println(fs+"-"+ ss);
				}
			}
		}
	}
	
	
}
