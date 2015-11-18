package com.epn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ALexico {
	// Creacion del archivo de entrada
	File fe = new File("codigo.txt");
	// para la entrada
	private BufferedReader entrada;
	
	
	public ALexico() throws IOException {
		super();
		// Enlace entre el buffer de entrada con el apuntador
		entrada = new BufferedReader(new FileReader(fe));

	}

	public void analizarCodigo() throws IOException {
		Identificador identificador = new Identificador();
		Literal literal = new Literal();
		OperadorCompuesto operadorCompuesto = new OperadorCompuesto();
		CaracterEspecial caracterEspecial = new CaracterEspecial();
		PalabraReservada palabraReservada = new PalabraReservada();
		String linea, nString="";
		char[] vectorLinea;
		while (entrada.ready())// mientras haya datos en el archivo se ejecute
		{
			linea = entrada.readLine(); // lee una linea del archivo y le coloca en el buffer
			linea.trim();
			vectorLinea = linea.toCharArray();
			for (int i= 0; i<vectorLinea.length; i++) {
				nString+=vectorLinea[i];
				int result1, result2, result3,result4,result5;
				result1=palabraReservada.esPalabraReservada(nString,vectorLinea[i+1]);
				if(result1==1)
				{
					System.out.println("Es palabra reservada");
					nString="";
				}
				result2=caracterEspecial.esCaracterEspecial(nString,vectorLinea[i+1]);
				if(result2==1)
				{
					System.out.println("Es caractes especial");
					nString="";
				}
				result3=identificador.esIdentificador(nString,vectorLinea[i+1]);
				if(result3==1)
				{
					System.out.println("Es identificador");
					nString="";
				}
				result4=literal.esLiteral(nString, vectorLinea[i+1]);
				if(result4==1)
				{
					System.out.println("Es literal");
					nString="";
				}
				result5=operadorCompuesto.esOperadorCompuesto(nString, vectorLinea[i+1]);
				if(result5==1)
				{
					System.out.println("Es operador compuesto");
					nString="";
				}
				if(nString.equals(" "))
				{
					nString="";
				}
				

					
				}
				
			}
			entrada.close(); // cierra el fin de archivo
		
	}

}
