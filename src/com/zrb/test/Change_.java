package com.zrb.test;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Change_ {

	public static void readTxtFile(String filePath, String result) {
		InputStreamReader read = null;
		OutputStreamWriter write = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
			bufferedReader = new BufferedReader(read);
			write = new OutputStreamWriter(new FileOutputStream(result));
			bufferedWriter = new BufferedWriter(write);
			if (file.isFile() && file.exists()) { // 判断文件是否存在

				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// 判断是否空行 zz
					if (lineTxt.length() != 0) {
						// 对lineTxt进行遍历，将“_”去掉，同时将_后面的字符变成大写
						String[] arr = lineTxt.split("\\_");
						String append = "";

						for (int i = 0; i < arr.length; i++) {
							// System.out.print(arr[i]);
							// 将每个字符串的首字母变成大写并且串在一起
							String str = toUpperCaseFirstOne(arr[i]);
							// 量小的话直接使用+不用append了
							append = append + str;
						}
						//写入文件 zz
						bufferedWriter.write(append + "\r\n");
						bufferedWriter.newLine();
						System.out.println(lineTxt + "     " + append);
					}
				}
				// bufferedWriter.write("hello");

			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		} finally {
			//要关缓冲流 zz
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// 将每个字符串的首字母变成大写
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public static void main(String[] args) {
		String filePath = "D:\\111.txt";
		String result = "D:\\222.txt";
		readTxtFile(filePath, result);
	}
}
