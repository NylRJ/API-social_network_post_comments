package com.i9Developed.pgm.uttil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
		public static String decodeParameter(String text) {
			
			try {
				return URLDecoder.decode(text, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "";
			}
		}
}
