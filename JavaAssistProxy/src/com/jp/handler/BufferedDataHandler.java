package com.jp.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.jp.beans.FileReader;

public class BufferedDataHandler implements InvocationHandler {
	private FileReader reader;

	public BufferedDataHandler(FileReader reader) {
		this.reader = reader;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String data = null;

		data = reader.getData((String) args[0]);
		data += " guys!";
		return data;
	}
}



