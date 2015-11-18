package com.epn;

import java.util.ArrayList;
import java.util.Collections;

public class PalabraReservada {
	private ArrayList<String> listaPalabraReservada = new ArrayList<String>();

	public PalabraReservada() {
		super();
		Collections.addAll(listaPalabraReservada, "int", "float", "bool", "char", "string", "if", "then", "else",
				"while", "do", "input", "output", "return");
	}

	public int esPalabraReservada(String texto, char next) {
		int res = -1;
		if (listaPalabraReservada.contains(texto + next))

		{
			res = 0;
		} else {
			if (listaPalabraReservada.contains(texto))

			{
				res = 1;
			}

		}

		return res;
	}
}
