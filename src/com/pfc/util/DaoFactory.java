package com.pfc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class DaoFactory {
	
	private DaoFactory(){}
	
	private static Properties prop = new Properties();
	
	
	static{
		InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("../properties/dao.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public static Object newInstance(String interfaceClassName){
		 String className = prop.getProperty(interfaceClassName);
		 try {
			return Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 
	 }
}
