package SegundoTrimestre.Tema03.Socket.T03_Ahorcado;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServidor {

	public static void main(String[] args) {

		try {
            ServerSocket servidor = new ServerSocket(9000);
            System.out.println("Servidor iniciado en el puerto 9000");

            for (int i = 0; i < 100; i++) {
                Socket cliente = servidor.accept();
                System.out.println("Nuevo cliente conectado");
                Servidor s = new Servidor(cliente);
                Thread t = new Thread(s);
                t.start();
            }
            servidor.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
		
	}

}
