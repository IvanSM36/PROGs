package Tema02;

public class LanzaHilosYesperaQueTerminen {

	public static void main(String[] args) {

		Thread h1 = new Thread(new Hilo("h1"));
		Thread h2 = new Thread(new Hilo("h2"));
		h1.start();
		h2.start();

		try {
			h1.join();
			h2.join();
		} catch (Exception e) {
			System.out.println("Hilo principal interrumpido");
		}
		System.out.println("Hilo principal terminado");
	}

}
