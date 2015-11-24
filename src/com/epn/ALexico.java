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
		OperadorCompuesto operadorCompuesto = new OperadorCompuesto();
		CaracterEspecial caracterEspecial = new CaracterEspecial();
		PalabraReservada palabraReservada = new PalabraReservada();
		Ints ints = new Ints();
		Floats floats = new Floats();
		Booleans bool = new Booleans();
		Chars chars = new Chars();
		Strings strings = new Strings();
		Error error = new Error();
		String linea, nString = "";
		char[] vectorLinea;
		int contLinea = 0;
		String salidaError = "", salida ="";
		while (entrada.ready()) {
			contLinea++;
			linea = entrada.readLine();
			linea.trim();
			vectorLinea = linea.toCharArray();
			for (int i = 0; i < vectorLinea.length; i++) {
				nString += vectorLinea[i];
				int result;
				for (int op = 0; op < 11; op++) {
					switch (op) {
					case 0:
						if (i == vectorLinea.length - 1) {
							result = comentario.esComentario(nString, ' ');
							if (result == 1) {

								nString = "";
								i = vectorLinea.length;
								op = 11;
							}
						} else {
							result = comentario.esComentario(nString, vectorLinea[i + 1]);
							if (result == 0) {
								nString = "";
								i = vectorLinea.length;
								op = 11;
							} else if (result == 2) {
								nString = "/*";
								i++;
								op = 11;
							}
						}
						break;
					case 1:

						if (i == vectorLinea.length - 1) {
							result = palabraReservada.esPalabraReservada(nString, ' ');
							if (result == 1) {

								salida += "\n" + nString + ",palabra reservada";
								nString = "";
								op = 11;
							}
						} else {
							result = palabraReservada.esPalabraReservada(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 11;
							}
							if (result == 1) {

								salida += "\n" + nString + ",palabra reservada";
								nString = "";
								op = 11;
							}
						}
						break;
					case 2:
						if (i == vectorLinea.length - 1) {
							result = operadorCompuesto.esOperadorCompuesto(nString, ' ');
							if (result == 1) {

								salida += "\n" + nString + ",operador compuesto";
								nString = "";

								op = 11;
							}

						} else {
							result = operadorCompuesto.esOperadorCompuesto(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 11;
							}
							if (result == 1) {

								salida += "\n" + nString + ",operador compuesto";

								nString = "";
								op = 11;
							}
						}

						break;
					case 3:
						if (i == vectorLinea.length - 1) {
							result = caracterEspecial.esCaracterEspecial(nString, ' ');
							if (result == 1) {

								salida += "\n" + nString + ",caractes especial";
								nString = "";
								op = 11;
							}
						} else {
							result = caracterEspecial.esCaracterEspecial(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 11;
							}
							if (result == 1) {

								salida += "\n" + nString + ",caractes especial";
								nString = "";
								op = 11;
							}
						}

						break;

					case 4:
						if (i == vectorLinea.length - 1) {
							result = ints.esInt(nString, ' ');
							if (result == 1) {

								salida += "\n" + nString + ",int";
								nString = "";
								op = 11;
							}
						} else {
							result = ints.esInt(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 11;
							}
							if (result == 1) {

								salida += "\n" + nString + ",int";
								nString = "";
								op = 11;
							}
						}
						break;

					case 5:
						if (i == vectorLinea.length - 1) {
							result = floats.esFloat(nString, ' ');
							if (result == 1) {

								salida += "\n" + nString + ",float";
								nString = "";
								op = 11;
							}
						} else {
							result = floats.esFloat(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 11;
							}
							if (result == 1) {

								salida += "\n" + nString + ",float";
								nString = "";
								op = 11;
							}
						}
						break;

					case 6:
						if (i == vectorLinea.length - 1) {
							result = bool.esBoolean(nString, ' ');
							if (result == 1) {

								salida += "\n" + nString + ",boolean";
								nString = "";
								op = 11;
							}
						} else {
							result = bool.esBoolean(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 11;
							}
							if (result == 1) {

								salida += "\n" + nString + ",boolean";
								nString = "";
								op = 11;
							}
						}
						break;
					case 7:
						if (i == vectorLinea.length - 1) {
							result = chars.esChar(nString, ' ');
							if (result == 1) {

								salida += "\n" + nString + ",char";
								nString = "";
								op = 11;
							}
						} else {
							result = chars.esChar(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 11;
							}
							if (result == 1) {

								salida += "\n" + nString + ",char";
								nString = "";
								op = 11;
							}
						}
						break;
					case 8:
						if (i == vectorLinea.length - 1) {
							result = strings.esString(nString, ' ');
							if (result == 1) {

								salida += "\n" + nString + ",string";
								nString = "";
								op = 11;
							}
						} else {
							result = strings.esString(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 11;
							}
							if (result == 1) {

								salida += "\n" + nString + ",string";
								nString = "";
								op = 11;
							}
						}
						break;
					case 9:
						if (i == vectorLinea.length - 1) {
							result = identificador.esIdentificador(nString, ' ');
							if (result == 1) {

								salida += "\n" + nString + ",identificador";
								nString = "";
								op = 11;
							}
						} else {

							result = identificador.esIdentificador(nString, vectorLinea[i + 1]);
							if (result == 0) {
								op = 11;
							}
							if (result == 1) {
								salida += "\n" + nString + ",identificador";
								nString = "";
								op = 11;
							}
						}

						break;

					case 10:
						if (i == vectorLinea.length - 1) {
							result = error.isError(nString, ' ');
							if (result == 1) {
								salida += "\n" + nString + ",error";
								salidaError += "\nError en la linea, " + contLinea;
								nString = "";
								op = 11;
							}
						} else {
							result = error.isError(nString, vectorLinea[i + 1]);
							if (result == 1) {
								salida += "\n" + nString + ",error";
								salidaError += "\nError en la linea, " + contLinea;
								nString = "";
								op = 11;
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
			salida.trim();
			FileWriter filewriter = new FileWriter("resultados.csv");
			filewriter.append(salida);
			filewriter.append(salidaError);
			filewriter.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
