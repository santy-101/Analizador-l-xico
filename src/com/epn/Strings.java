package com.epn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Strings {
	private String strings;

	public Strings() {
		super();
		this.strings = "(“|\")(|.)*(”|\")";
	}
	
	public int  esString(String texto, char next) {
		int resul = -1;
			resul = verificar(texto, next);
		

		return resul;
	}

	public int verificar(String texto, char next) {
		int res = -1;
		Pattern p = Pattern.compile(this.strings);
		Matcher matcher = p.matcher(texto + next);
		Matcher matcher1 = p.matcher(texto);
		if (matcher.matches()) {
			res = 0;
		} else {
			if (matcher1.matches()) {
				res = 1;
			}

		}

		return res;
	}
	 
	
}
