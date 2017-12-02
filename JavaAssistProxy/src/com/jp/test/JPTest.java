package com.jp.test;

import java.lang.reflect.Proxy;

import com.jp.beans.FileReader;
import com.jp.beans.Reader;
import com.jp.handler.BufferedDataHandler;

public class JPTest {
	public static void main(String[] args) {
		Reader reader = null;

		reader = (Reader) Proxy.newProxyInstance(Reader.class.getClassLoader(),
				new Class[] { Reader.class }, new BufferedDataHandler(
						new FileReader()));
		/*reader = new FileReader();*/
		String data = reader.getData("c:\\readme.txt");
		System.out.println(data);
	}
}
