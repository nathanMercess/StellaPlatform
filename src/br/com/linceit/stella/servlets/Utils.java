package br.com.linceit.stella.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Utils {
	
	public static String toUTF8(String parameter) {
		byte[] bytes = parameter.getBytes(StandardCharsets.ISO_8859_1);
		return new String(bytes, StandardCharsets.UTF_8);
	}
	
	public static String urlEncode(String value, String charset) throws UnsupportedEncodingException {
	    return URLEncoder.encode(value, charset);
	}
	
	public static String convert(InputStream inputStream, Charset charset) throws IOException {
		 
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset))) {	
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}
		}
	 
		return stringBuilder.toString();
	}
}
