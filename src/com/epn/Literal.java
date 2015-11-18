package com.epn;

import java.util.ArrayList;

public class Literal {
	private ArrayList<String> listaLiterales = new ArrayList<String>();

	public Literal() {
		super();

	}

	public int esLiteral(String texto, char next) {

		int res = -1;
		if (listaLiterales.contains(texto + next))

		{
			res = 0;
		} else {
			if (listaLiterales.contains(texto))

			{
				res = 1;
			}

		}

		return res;
	}

}
