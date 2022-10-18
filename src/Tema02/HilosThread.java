package Tema02;

import java.util.concurrent.TimeUnit;

public class HilosThread extends Thread {
	public void run() {
		System.out.println("Ejecutando hilo");
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String args[]) {
		System.out.println(Thread.currentThread().getName());
		int i = 0;
		while (i < 100) {
			(new HilosThread()).start();
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}
