package com.bb.util;

public class Utility {
	public static String getSeoName(String name) {
		try {
	name=	name.toLowerCase().replace(" ", "-").replace("/", "").
		replace("[","").replace("[", "").replace("]", "").replace("{", "")
		.replace("}", "").replace("(", "").replace(")", "").replace("&", "and");
		}catch(Exception e) {}
		return name;
	}
	
	
}
