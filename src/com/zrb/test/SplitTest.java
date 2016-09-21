package com.zrb.test;

public class SplitTest {
	public static void main(String[] args) {
		/*String str = "aaa_bbb_ccc";
		String[] arr = str.split("\\_");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}*/
		
		String str1 = "aaaaaa";
		String str2 = toUpperCaseFirstOne(str1);
		System.out.println(str2);
		
	}
	
	public static String toUpperCaseFirstOne(String s){
		  if(Character.isUpperCase(s.charAt(0)))
		    return s;
		  else
		    return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		}

}
