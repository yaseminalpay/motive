package com.boun.motive.util;

public class StringUtil {
	
	public static boolean isEmptyString(final String str)
	{
		if(str == null || str.isEmpty())
		{
			return true;
		}
		return false;
	}
}
