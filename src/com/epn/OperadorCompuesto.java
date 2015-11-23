package com.epn;

import java.util.ArrayList;
import java.util.Collections;

public class OperadorCompuesto {
	private ArrayList<String> listaOperadorCompuesto = new ArrayList<String>();

	public OperadorCompuesto() {
		super();
		Collections.addAll(listaOperadorCompuesto, "<=", ">=", "==", "!=", "&&", "||");
	}
	
public ArrayList<String> getListaOperadorCompuesto() {
		return listaOperadorCompuesto;
	}

	public void setListaOperadorCompuesto(ArrayList<String> listaOperadorCompuesto) {
		this.listaOperadorCompuesto = listaOperadorCompuesto;
	}

public int esOperadorCompuesto(String texto, char next) {
	int res = -1;
	if (listaOperadorCompuesto.contains(texto + next))

	{
		res = 0;
	} else {
		if (listaOperadorCompuesto.contains(texto))

		{
			res = 1;
		}

	}
	return res;
	}
}
