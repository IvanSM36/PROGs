package Tema01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OperacionesFicheros {

	public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {
		FileReader lector;
		lector = new FileReader(nombreFichero);
		BufferedReader bufferedReader;
		bufferedReader = new BufferedReader(lector);
		return bufferedReader;
	}

	public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {
		PrintWriter printWriter;
		FileWriter fileWriter;
		fileWriter = new FileWriter(nombreFichero);
		printWriter = new PrintWriter(fileWriter);
		return printWriter;
		// Fin de getPrintWriter
	}

	public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {
		ArrayList<String> lineas = new ArrayList<String>();
		BufferedReader bfr = getBufferedReader(nombreFichero);
		// Leemos líneas del fichero...
		String linea = bfr.readLine();
		while (linea != null) {
			// Y las añadimos al array
			lineas.add(linea);
			linea = bfr.readLine();
		}
		// Fin del bucle que lee líneas
		return lineas;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		String ficheroEntrada;
		ficheroEntrada = args[0];
		String classpathUtilidades;
		classpathUtilidades = args[1];
		String classpathProcesadorFichero;
		classpathProcesadorFichero = args[2];
		String[] vocales = { "A", "E", "I", "O", "U" };
		String classPath;
		classPath = classpathProcesadorFichero + ":" + classpathUtilidades;
		System.out.println("Usando classpath:" + classPath);
		/* Se lanzan los procesos */
		for (int i = 0; i < vocales.length; i++) {
			String fichErrores = "Errores_" + vocales[i] + ".txt";
			ProcessBuilder pb;
			pb = new ProcessBuilder("java", "-cp", classPath, "com.ies.ProcesadorFichero", ficheroEntrada, vocales[i],
					vocales[i] + ".txt");
			// Si hay algún error, almacenarlo en un fichero
			pb.redirectError(new File(fichErrores));
			pb.start();
			// Fin del for
		}
		/* Esperamos un poco */
		Thread.sleep(3000);
		/*
		 * La recogida de resultados se deja como ejercicio al lector. ;)
		 */

		/*public static void main(String[] args)throws FileNotFoundException, IOException {
		 
		String nombreFicheroEntrada = args[0];
		String letra = args[1];
		String nombreFicheroResultado = args[2];
		hacerRecuento(nombreFicheroEntrada, letra, nombreFicheroResultado);
}*/	
		
	}

}
