package Tema02;

public class LanzadorHilos {

	public static void main(String[] args) {
		int NUM_HILOS = 500;
		EjecutorTareaCompleja op;
		for (int i = 0; i < NUM_HILOS; i++) {
			op = new EjecutorTareaCompleja("Operacion " + i);
			Thread hilo = new Thread(op);
			hilo.start();
		}
	}
}
