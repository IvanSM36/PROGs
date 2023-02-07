package SegundoTrimestre.Tema03.Socket.T03_Ahorcado;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable {

	private Socket cliente;

	public Servidor(Socket cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {

		InputStream entrada;
		try {
			entrada = cliente.getInputStream();
			OutputStream salida = cliente.getOutputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(entrada));
			PrintWriter writer = new PrintWriter(salida, true);

			String palabra = "ahorcado";
			String adivinanza = "";
			for (int i = 0; i < palabra.length(); i++) {
				adivinanza += "_";
			}
			int intentos = 6;

			while (intentos > 0 && !adivinanza.equals(palabra)) {
				writer.println("Adivinanza: " + adivinanza);
				writer.println("Intentos restantes: " + intentos);
				writer.println("Ingrese una letra: ");
				char letra = reader.readLine().charAt(0);
				boolean acierto = false;
				for (int i = 0; i < palabra.length(); i++) {
					if (palabra.charAt(i) == letra) {
						acierto = true;
						StringBuilder sb = new StringBuilder(adivinanza);
						sb.setCharAt(i, letra);
						adivinanza = sb.toString();
					}
				}
				if (!acierto) {
					intentos--;
				}
			}
			if (adivinanza.equals(palabra)) {
				writer.println("Felicidades, has ganado!");
			} else {
				writer.println("Lo siento, has perdido.");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
