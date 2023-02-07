package SegundoTrimestre.Tema03.Socket.T02_NumPrimos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		int numPuerto = 6000;

		try {
			while (true) {
				ServerSocket ss = new ServerSocket(numPuerto);

				Socket clienteConectado = null;

				System.out.println("Esperando cliente...");
				// Conectamos el cliente con el servidor
				clienteConectado = ss.accept();

				// Creo flujo de entrada del cliente
				InputStream entrada = null;
				entrada = clienteConectado.getInputStream();
				DataInputStream flujoEntrada = new DataInputStream(entrada);		
				
				// Otro flujo de salida al cliente
				OutputStream salida = null;
				salida = clienteConectado.getOutputStream();
				DataOutputStream flujoSalida = new DataOutputStream(salida);

				// Recibo el mensaje
				System.out.println("Recibiendo respuesta del cliente: " + flujoEntrada.readInt());
						
				
				//flujoSalida.writeUTF("Saludo al cliente del servidor");

				// Cerramos conexiones
				entrada.close();
				flujoEntrada.close();
				salida.close();
				flujoSalida.close();
				ss.close();
				clienteConectado.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
