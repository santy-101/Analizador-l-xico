package com.epn;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Identificador {

	private ArrayList<String> listaIdentificadores = new ArrayList<String>();

	public int esIdentificador(String texto, char next) {
		String patron = "[A-Z a-z]*";
		int res = 0;
		Pattern p = Pattern.compile(patron);
		Matcher matcher = p.matcher(texto + next);
		Matcher matcher1 = p.matcher(texto);
		if (matcher.matches()) {
			listaIdentificadores.add(texto);
			res = 0;
		} else {
			if (matcher1.matches()) {
				listaIdentificadores.add(texto);
				res = 1;
			}

		}
		return res;
	}

}
