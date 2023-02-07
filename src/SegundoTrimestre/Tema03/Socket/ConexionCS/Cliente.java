package SegundoTrimestre.Tema03.Socket.ConexionCS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {

		int numPuerto = 6000;
		String host = "192.168.1.177";
		
		System.out.println("Iniciando programa Cliente...");
		
		Socket cliente;
		
		try {
			cliente = new Socket (host, numPuerto);
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
			
			flujoSalida.writeUTF("Saludo al servidor desde el cliente");
			
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
			
			System.out.println("Recibiendo del Servidor: " + flujoEntrada.readUTF());
			
			
			flujoEntrada.close();
			flujoSalida.close();
			cliente.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
