package com.epn;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chars {
	private String chars;

	public Chars() {
		super();
		this.chars = "'.?'";
	}
	
	public int esChar(String texto, char next) {
		int resul = -1;
				
		resul = verificar(texto, next);
		

		return resul;
	}

	public int verificar(String texto, char next) {
		int res = -1;
		Pattern p = Pattern.compile(this.chars);
		Matcher matcher = p.matcher(texto + next);
		Matcher matcher1 = p.matcher(texto);
		String sigue = next + "";
		CaracterEspecial car = new CaracterEspecial();
		boolean aux = car.getListaCaracterEspecial().contains(sigue);
		OperadorCompuesto ope = new OperadorCompuesto();
		boolean aux1 = ope.getListaOperadorCompuesto().contains(sigue);
		if (matcher.matches()) {
			res = 0;
		} else {
			if (matcher1.matches()&& (next==' ' || ( aux || aux1))) {
				res = 1;
			}

		}

		return res;
	}
}
