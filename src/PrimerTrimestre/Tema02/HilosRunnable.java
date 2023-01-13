package PrimerTrimestre.Tema02;

import java.util.concurrent.TimeUnit;

public class HilosRunnable implements Runnable {
	public void run() {
		System.out.println("Ejecutando hilo");
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String args[]) {
		System.out.println(Thread.currentThread().getName());
		int i = 0;
		while (i < 100) {
			(new Thread(new HilosRunnable())).start();
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}