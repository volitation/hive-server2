package com.bigdata.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSplitUtil {

	public  static void stringSplit() throws IOException {
		String encoding = "UTF-8";
		String path = StringSplitUtil.class.getClassLoader().getResource("qupinyin.txt").getPath();
		File file = new File(path);
		if (file.isFile() && file.exists()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				String str = lineTxt;
				String txt = "";
				String[] arr = str.split(" ");
				for (int i = 0; i < arr.length; i++) {
					String[] arr2 = arr[i].split("");
					txt = txt.concat(arr2[1]+" ");
				}
				System.out.println(txt.toUpperCase());
			}
			read.close();
		}
	}

	public static void main(String[] args) {
		try {
			stringSplit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
