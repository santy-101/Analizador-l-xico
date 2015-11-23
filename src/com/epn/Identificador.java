package com.epn;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Identificador {

	private ArrayList<String> listaIdentificadores = new ArrayList<String>();

	public int esIdentificador(String texto, char next) {
		int res = -1;
		String patron = "[a-z]+", sigue=next+"";
		
		CaracterEspecial car = new CaracterEspecial();
		
		boolean aux = car.getListaCaracterEspecial().contains(sigue);
		OperadorCompuesto ope = new OperadorCompuesto();
		
		boolean aux1 = ope.getListaOperadorCompuesto().contains(sigue);
		Pattern p = Pattern.compile(patron);
		
		Matcher matcher = p.matcher(texto + next);
		Matcher matcher1 = p.matcher(texto);
		if (matcher.matches()) {
			res = 0;
		} else {
			if (matcher1.matches() && next == ' ')

			{
				res = 1;
			} 
			else {
				if (matcher1.matches() && aux) {
					res = 1;
				} 
				else {
					if (matcher1.matches() && aux1) {
						res = 1;
					}

				}

			}

		}

		return res;
	}

}
