package com.epn;

import java.util.ArrayList;
import java.util.Collections;

public class CaracterEspecial {
	private ArrayList<String> listaCaracterEspecial = new ArrayList<String>();

	public CaracterEspecial() {
		super();
		Collections.addAll(listaCaracterEspecial, "," , ";" , ":" , "(" , ")" , "[" , "]" , "{" , "}" , "+" , "-" , "*" , "/" , "<" , ">" , "=" , "!" , "&" , "$");
	}
	
	public int esCaracterEspecial(String texto, char next) {
		int res = -1;
		if (listaCaracterEspecial.contains(texto + next))

		{
			res = 0;
		} else {
			if (listaCaracterEspecial.contains(texto))

			{
				res = 1;
			}

		}
		return res;
	}
}
