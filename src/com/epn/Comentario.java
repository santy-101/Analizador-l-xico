package com.epn;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comentario {
	private ArrayList<String> listaComentarios = new ArrayList<String>();

	public Comentario() {
		super();
	}

	public int esComentario(String texto, char next) {
		int result = -1;
		String patron = "//" + ".*";
		Pattern p = Pattern.compile(patron);
		Matcher matcher = p.matcher(texto+next);

		if (matcher.matches()) {
			listaComentarios.add(texto);
			result = 0;
		} else {
			String patron2 = "/\\*" + "(.||\n)*" + "\\*/";
			Pattern p2 = Pattern.compile(patron2);
			Matcher matcher2 = p2.matcher(texto+next);

			if (matcher2.matches()) {
				listaComentarios.add(texto);

				result = 1;
			}

		}
		return result;
	}

}
