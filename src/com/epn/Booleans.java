package com.epn;

import java.util.ArrayList;
import java.util.Collections;

public class Booleans {
	private ArrayList<String> listaBooleans = new ArrayList<String>();

	public Booleans() {
		super();
		Collections.addAll(listaBooleans, "true", "false");
	}

	public int esBoolean(String texto, char next) {
		int res = -1;
		CaracterEspecial ca = new CaracterEspecial();
		boolean aux = ca.getListaCaracterEspecial().contains(next);
		OperadorCompuesto ope = new OperadorCompuesto();
		boolean aux1 = ope.getListaOperadorCompuesto().contains(next);
		if (listaBooleans.contains(texto + next))

		{
			res = 0;
		} else {
			if (listaBooleans.contains(texto) && aux)

			{
				res = 1;
			} else {
				if (listaBooleans.contains(texto) && next == ' ') {
					res = 1;
				} else {
					if (listaBooleans.contains(texto) && aux1) {
						res = 1;
					}

				}

			}

		}
		return res;
	}

}
