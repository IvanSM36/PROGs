/**
 * 
 */
package SegundoTrimestre.Tema03.Socket.T03_Ahorcado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.Scanner;

/**
 * @author Eduardo
 *
 */
public class MainCliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		String Host = "localhost";
		int numeroPuerto = 9000;
		
		Socket cliente = null;
		
		// creamos flujo de salida al servidor
		DataOutputStream flujoSalida = null;
		
		// creamos flujo de entrada del cliente
		DataInputStream flujoEntrada = null;
		
		String respuesta = "";
		String letra ;
		
		try {
			//defino socket cliente que aceptará el servidor
			cliente = new Socket(Host, numeroPuerto);
			
			// defino flujos
			flujoSalida = new DataOutputStream(cliente.getOutputStream());
			flujoEntrada = new DataInputStream(cliente.getInputStream());
			
			while (respuesta.contains("Game over")== false && respuesta.contains("Has acertado la palabra")==false) {
				//envio al servidor
				//pido una letra
				System.out.print("Dame una letra: ");
				letra = sc.nextLine(); 					// la leo
				flujoSalida.writeUTF(letra); 			// se la mando al servidor y verá si acepta o no
				respuesta = flujoEntrada.readUTF();		// me devuelve respuesta
				
				//el servidor me envía
				System.out.println("Recibiendo del SERVIDOR: \n\t" + respuesta);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		
		System.out.println("FIN DE EJECUCION DEL SERVIDOR.");
		
		
		try {
			//cerramos streams y sockets
			flujoEntrada.close();
			flujoSalida.close();
			cliente.close();
		} catch (Exception e) {
			e.printStackTrace();
			}
		}

}
