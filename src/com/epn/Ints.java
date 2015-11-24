package com.epn;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ints {
	private String strings;

	public Ints() {
		super();
		this.strings = "-?[1-9]+";
		;
	}

	public int esInt(String texto, char next) {
		int resul = -1;
		String sigue = next + "";
		CaracterEspecial car = new CaracterEspecial();
		boolean aux = car.getListaCaracterEspecial().contains(sigue);
		OperadorCompuesto ope = new OperadorCompuesto();
		boolean aux1 = ope.getListaOperadorCompuesto().contains(sigue);
		if (aux || aux1||next==' ') {
			resul = verificar(texto, next);
		} else {
			int a = verificar(next + "", ' ');
			if (a == 0) {
				resul = verificar(texto, next);
			}
		}

		return resul;
	}

	public int verificar(String texto, char next) {
		int res = -1;
		Pattern p = Pattern.compile(this.strings);
		Matcher matcher = p.matcher(texto + next);
		Matcher matcher1 = p.matcher(texto);
		if (matcher.matches()) {
			res = 0;
		} else {
			if (matcher1.matches()) {
				res = 1;
			}

		}

		return res;
	}

}
