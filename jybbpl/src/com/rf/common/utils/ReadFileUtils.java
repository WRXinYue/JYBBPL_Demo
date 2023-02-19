package com.rf.common.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadFileUtils {
	public static String getDBProperties(String key) {
		Properties prop = null;
		InputStream in= null;
		String strInfo = "";
		try {
			prop = new Properties();
			in = ReadFileUtils.class.getClassLoader().getResourceAsStream("com/rf/common/config/db.properties");
			prop.load(in);
			strInfo = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strInfo;
	}
	public static String getMessageProperties(String filename,String key) {
		Properties prop = null;
		InputStream in= null;
		String strInfo = "";
		try {
			prop = new Properties();
			in = ReadFileUtils.class.getClassLoader()
					.getResourceAsStream("com/rf/common/config/"
							+ filename);
			prop.load(new InputStreamReader(in,"utf-8"));
			strInfo = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strInfo;
	}
}
