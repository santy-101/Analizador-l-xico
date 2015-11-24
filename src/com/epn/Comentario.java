package com.epn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comentario {
	private ArrayList<String> listaComentarios = new ArrayList<String>();

	public Comentario() {
		super();
	}

	public int esComentario(String texto, char next) {
		int result = -1;
		String patronL = "^//.*";
		String patronC = "[/\\*]*.*\\n*[\\*/]$";
		if(verificador(patronL, texto, next)==0 )
		{
			result = verificador(patronL, texto, next);
		}
		else{
			if (texto.equals("/")&& next=='*') {
				result = 2;
			}
			else
			{if(verificador(patronC, texto, next)==0)
			{
				result = verificador(patronC, texto, next);
			}
			}
			
		}

		return result;
	}

	public int verificador(String expresion, String texto, char next) {
		int res = -1;
		Pattern p = Pattern.compile(expresion);
		Matcher matcher = p.matcher(texto + next);
		Matcher matcher1 = p.matcher(texto);
		if (matcher.matches()) {
			res = 0;
		} else {
			if (matcher1.matches() && texto.equals(next)) {
				res = 1;
			}

		}
		return res;
	}
}
