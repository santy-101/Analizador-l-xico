package com.epn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Literal {
	private ArrayList<String> listaLiterales = new ArrayList<String>();

	public Literal() {
		super();

	}

	public int esLiteral(String texto, char next) {
		String sInt = "-?[1-9]+";
		String sFloat = "[0-9]+\\.[0-9]+";
		String sBool = "true|false";
		String sChar = "'.?'";
		String sString = "\".*\"";
		int resul = -1, i = 0;
		String sigue = next + "";
		CaracterEspecial car = new CaracterEspecial();
		boolean aux = car.getListaCaracterEspecial().contains(sigue);
		OperadorCompuesto ope = new OperadorCompuesto();
		boolean aux1 = ope.getListaOperadorCompuesto().contains(sigue);
		while (resul == -1 && i < 5) {
			if (i == 0) {

				if (aux || aux1) {
					resul = literal(sInt, texto, next);
				} else {
					int a = literal(sInt, next + "", ' ');
					if (a == 0) {
						resul = literal(sInt, texto, next);
					}
				}
				i++;

			} else {
				if (i == 1) {
					resul = literal(sFloat, texto, next);
					i++;
				} else {
					if (i == 2) {
						resul = literal(sBool, texto, next);
						i++;
					} else {
						if (i == 3) {
							resul = literal(sChar, texto, next);
							i++;
						} else {
							if (i == 4) {
								resul = literal(sString, texto, next);
								i++;
							}
						}
					}
				}
			}
		}
		return resul;
	}

	public int literal(String expresion, String texto, char next) {
		int res = -1;
		ArrayList<String> bools = new ArrayList<String>();
		Collections.addAll(bools, "true", "false");
		Pattern p = Pattern.compile(expresion);
		Matcher matcher = p.matcher(texto + next);
		Matcher matcher1 = p.matcher(texto);
		if (matcher.matches()) {
			listaLiterales.add(texto);
			res = 0;
		} else {
			if (matcher1.matches()) {
				listaLiterales.add(texto);
				res = 1;
			}

		}
		if (bools.contains(texto + next))

		{
			res = 0;
		} else {
			if (bools.contains(texto))

			{
				res = 1;
			}

		}
		return res;
	}

}
