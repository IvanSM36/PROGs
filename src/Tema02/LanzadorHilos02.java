package Tema02;

public class LanzadorHilos02 {
	public static void main(String[] args) {
		Calculador vHilos[] = new Calculador[5];
		for (int i = 0; i < 5; i++) {
			vHilos[i] = new Calculador();
			Thread hilo = new Thread(vHilos[i]);
			hilo.setName("Hilo " + i);
			if (i == 0) {
				hilo.setPriority(Thread.MAX_PRIORITY);
			}
			hilo.start();
		}
	}
}
