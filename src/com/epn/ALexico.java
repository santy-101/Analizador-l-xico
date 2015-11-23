package com.epn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ALexico {

	File fe = new File("codigo.txt");
	private BufferedReader entrada;

	public ALexico() throws IOException {
		super();
		entrada = new BufferedReader(new FileReader(fe));
	}

	public void analizarCodigo() throws IOException {
		Comentario comentario = new Comentario();
		Identificador identificador = new Identificador();
		Literal literal = new Literal();
		OperadorCompuesto operadorCompuesto = new OperadorCompuesto();
		CaracterEspecial caracterEspecial = new CaracterEspecial();
		PalabraReservada palabraReservada = new PalabraReservada();
		Error error = new Error();
		String linea, nString = "";
		char[] vectorLinea;
		int contLinea = 0;
		String salidaError = "", salida = "";
		while (entrada.ready()) {
			contLinea++;
			linea = entrada.readLine();
			linea.trim();
			vectorLinea = linea.toCharArray();
			for (int i = 0; i < vectorLinea.length; i++) {
				nString += vectorLinea[i];
				int result;
				for (int op = 0; op < 7; op++) {
					switch (op) {
					case 0:
						if (i == vectorLinea.length - 1) {
							result = comentario.esComentario(nString, ' ');
							if (result == 1) {
								System.out.println(nString + " " + "Es comentario");
								salida += "\n" + nString + " " + "Es comentario";
								nString = "";
								op = 7;
							}
						} else {
							result = comentario.esComentario(nString, vectorLinea[i + 1]);
							if (result == 0) {
								System.out.println(nString + " " + "Es comentario");
								salida += "\n" + nString + " " + "Es comentario";
								i = vectorLinea.length;
								nString = "";
								op = 7;
							}
							if (result == 1) {
								System.out.println(nString + " " + "Es comentario");
								salida += "\n" + nString + " " + "Es comentario";
								nString = "";
								op = 7;
							}
						}
						break;
					case 1:
						if (i == vectorLinea.length - 1) {
							result = palabraReservada.esPalabraReservada(nString, ' ');
							if (result == 1) {
								System.out.println(nString + " " + "Es palabra reservada");
								salida += "\n" + nString + " " + "Es palabra reservada";
								nString = "";
								op = 7;
							}
						} else {
							result = palabraReservada.esPalabraReservada(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 7;
							}
							if (result == 1) {
								System.out.println(nString + " " + "Es palabra reservada");
								salida += "\n" + nString + " " + "Es palabra reservada";
								nString = "";
								op = 7;
							}
						}
						break;
					case 2:
						if (i == vectorLinea.length - 1) {
							result = operadorCompuesto.esOperadorCompuesto(nString, ' ');
							if (result == 1) {
								System.out.println(nString + " " + "Es operador compuesto");
								salida += "\n" + nString + " " + "Es operador compuesto";
								nString = "";

								op = 7;
							}

						} else {
							result = operadorCompuesto.esOperadorCompuesto(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 7;
							}
							if (result == 1) {
								System.out.println(nString + " " + "Es operador compuesto");
								salida += "\n" + nString + " " + "Es operador compuesto";

								nString = "";
								op = 7;
							}
						}

						break;
					case 3:
						if (i == vectorLinea.length - 1) {
							result = literal.esLiteral(nString, ' ');
							if (result == 1) {
								System.out.println(nString + " " + "Es literal");
								salida += "\n" + nString + " " + "Es literal";
								nString = "";

								op = 7;
							}
						} else {
							result = literal.esLiteral(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 7;
							}
							if (result == 1) {
								System.out.println(nString + " " + "Es literal");
								salida += "\n" + nString + " " + "Es literal";
								nString = "";
								op = 7;
							}
						}

						break;
					case 4:
						if (i == vectorLinea.length - 1) {
							result = identificador.esIdentificador(nString, ' ');
							if (result == 1) {
								System.out.println(nString + " " + "Es identificador");
								salida += "\n" + nString + " " + "Es identificador";
								nString = "";
								op = 7;
							}
						} else {

							result = identificador.esIdentificador(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 7;
							}
							if (result == 1) {
								System.out.println(nString + " " + "Es identificador");
								salida += "\n" + nString + " " + "Es identificador";
								nString = "";
								op = 7;
							}
						}

						break;
					case 5:
						if (i == vectorLinea.length - 1) {
							result = caracterEspecial.esCaracterEspecial(nString, ' ');
							if (result == 1) {
								System.out.println(nString + " " + "Es caractes especial");
								salida += "\n" + nString + " " + "Es caractes especial";
								nString = "";
								op = 7;
							}
						} else {
							result = caracterEspecial.esCaracterEspecial(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 7;
							}
							if (result == 1) {
								System.out.println(nString + " " + "Es caractes especial");
								salida += "\n" + nString + " " + "Es caractes especial";
								nString = "";
								op = 7;
							}
						}

						break;
					case 6:
						if (i == vectorLinea.length - 1) {
							result = error.isError(nString, ' ');
							if (result == 1) {
								System.out.println(nString + " " + "Error");
								salidaError += "\nError en la linea: " + contLinea;
								nString = "";
								op = 7;
							}
						} else {
							result = error.isError(nString, vectorLinea[i + 1]);
							if (result == 1) {
								System.out.println(nString + " " + "Error");
								salidaError += "\nError en la linea: " + contLinea;
								nString = "";
								op = 7;
							}
						}

						break;

					default:
						break;
					}
				}

				if (nString.equals(" ")) {
					nString = "";
				}

			}

		}
		entrada.close();
		try {
			FileWriter filewriter = new FileWriter("prueba.csv");
			filewriter.append(salida);
			filewriter.append(salidaError);
			filewriter.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(salidaError);

	}

}

