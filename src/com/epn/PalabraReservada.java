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
		CaracterEspecial ca = new CaracterEspecial();
		boolean aux= ca.getListaCaracterEspecial().contains(next);
		OperadorCompuesto ope = new OperadorCompuesto();
		boolean aux1= ope. getListaOperadorCompuesto().contains(next);
		if (listaPalabraReservada.contains(texto + next))

		{
			res = 0;
		} else {
			if (listaPalabraReservada.contains(texto) && aux )

			{
				res = 1;
			}
			else
			{
				if(listaPalabraReservada.contains(texto) && next==' ')
				{
					res = 1;
				}else
				{
					if(listaPalabraReservada.contains(texto) && aux1)
					{
						res = 1;
					}
				
				}
			
			}

		}

		return res;
	}
}
