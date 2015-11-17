package com.epn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ALexico {

	private ArrayList<String> PalabraReservada = new ArrayList<String>();
	private ArrayList<String> CaracterEspecial = new ArrayList<String>();

	public ALexico() {
		setPalabraReservada();
		setCaracterEspecial();
	}

	private void setPalabraReservada() {
		Collections.addAll(PalabraReservada, "int", "float", "bool", "char", "string", "if", "then", "else", "while",
				"do", "input", "output", "return");
	}

	private void setCaracterEspecial() {
		Collections.addAll(CaracterEspecial, "," , ";" , ":" , "(" , ")" , "[" , "]" , "{" , "}" , "+" , "-" , "*" , "/" , 
				"<" , ">" , "=" , "!" , "&" , "$");
	}

	public boolean esPalabraReservada(String texto) {
		return PalabraReservada.contains(texto);
	}
	
	public boolean esCaracterEspecial(String texto) {
	
		return CaracterEspecial.contains(texto);
	}

	public boolean esIdentificador(String texto) {
		String patron = "[A-Z][a-z]*";
		Pattern p = Pattern.compile(patron);

		Matcher matcher = p.matcher(texto);

		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
