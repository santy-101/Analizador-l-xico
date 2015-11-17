package com.epn;

public class Aplicación {

	public static void main(String[] args) {

		String texto = "if";
		ALexico lex = new ALexico();

		for (int op = 1; op <=3; op++) {
			switch (op) {
			
			case 1:
				if (lex.esPalabraReservada(texto)) {
					System.out.println("Es Palabra Reservada");
				}
				break;
				
			case 2:
				if (lex.esCaracterEspecial(texto)) {
					System.out.println("Es Caracter Especial");
				}
				break;
				
			case 3:
				if (lex.esIdentificador(texto)) {
					System.out.println("Es Identificador");
				}
				break;

			}

		}
	}

}
