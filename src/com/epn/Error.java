package com.epn;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Error {

	private ArrayList<String> listaErrores = new ArrayList<String>();

	public Error() {
		super();
	}
	
	public int isError(String texto, char next)
	{int result=-1;
	String expresion = "[\\w|\\d|.|_|^|~|%|#|$|º|!|¿|¡|:|\\\\|?]*";
	Pattern p = Pattern.compile(expresion);
	Matcher matcher = p.matcher(texto+next);
	Matcher matcher1 = p.matcher(texto);
	if (matcher.matches()) {
		listaErrores.add(texto);
		result = 0;
	} else {
		if (matcher1.matches()) {
			listaErrores.add(texto);
			result = 1;
		}

	}
	return result;	
	}
	
}
