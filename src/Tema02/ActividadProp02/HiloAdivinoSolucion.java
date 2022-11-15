package Tema02.ActividadProp02;


import java.util.Random;
/**
 * Hilo adivino que intentará encontrar el número oculto
 * @author Edu López
 * @version 1.0
 */
public class HiloAdivinoSolucion extends Thread{
	private boolean adivino;
	private int intentos;
	private NumeroOcultoSolucion NumeroOcultoSolucion;
	
	/**
	 * Todos los hilos comparten el mismo número oculto y tienen
	 * un nombre único
	 * @param NumeroOcultoSolucion Objeto del tipo NumeroOcultoSolucion al que lanzar
	 * la propuesta de número en cada intento
	 * @param numeroAdivino El número del adivino (o hilo)
	 */
	public HiloAdivinoSolucion(NumeroOcultoSolucion NumeroOcultoSolucion, int numeroAdivino) {
		super("Adivino " + numeroAdivino);
		this.NumeroOcultoSolucion = NumeroOcultoSolucion;
	}
	
	@Override
	public void run() {
		int resultadoPropuesta=NumeroOcultoSolucion.POR_ADIVINAR;
		Random rnd = new Random();
		
		//para dar igualdad de oportunidades cada hilo
		//espera un tiempo aleatorio antes de empezar 
		//los intentos para adivinar el número
		try {
			sleep(rnd.nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(resultadoPropuesta==NumeroOcultoSolucion.POR_ADIVINAR) {
			resultadoPropuesta = this.NumeroOcultoSolucion.propuestaNumero(rnd.nextInt(101));
			this.adivino = (resultadoPropuesta==NumeroOcultoSolucion.LO_HAS_ADIVINADO);
			this.intentos++;
		}
	}
	
	/**
	 * Devuelve true si el hilo ha sido el adivino del número
	 * @return True si el hilo ha adivinado el número, false en caso contrario
	 */
	public boolean esAdivino(){
		return this.adivino;
	}
	
	/**
	 * Devuelve el número de intentos empleados en adivinar el número
	 * @return Número de intentos
	 */
	public int getIntentos() {
		return this.intentos;
	}
}
