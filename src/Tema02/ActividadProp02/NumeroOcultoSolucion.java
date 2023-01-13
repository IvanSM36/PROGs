package Tema02.ActividadProp02;

import java.util.ArrayList;
import java.util.Random;
/**
 * Adivinos de un número oculto
 * @author Edu López
 * @version 1.0
 */
public class NumeroOcultoSolucion {
	public static final int LO_HAS_ADIVINADO=1;
	public static final int YA_ADIVINADO=-1;
	public static final int POR_ADIVINAR=0;
	private boolean adivinado = false;
	private int numero = 0;
	private ArrayList<HiloAdivinoSolucion> adivinos;
	
	public static void main(String[] args) {
		
		HiloAdivinoSolucion HiloAdivinoSolucion=null;
		NumeroOcultoSolucion NumeroOcultoSolucion = new NumeroOcultoSolucion();
		long tiempoEmpleado=System.currentTimeMillis();
		Random rnd = new Random();
		
		//Se genera un número oculto entre 0 y 100, y se guarda
		NumeroOcultoSolucion.numero = rnd.nextInt(101);
		
		//Se crea un array con 10 adivinos y se comienza el proceso de adivinación
		NumeroOcultoSolucion.adivinos = new ArrayList<HiloAdivinoSolucion>();
		for(int i=0;i<10;i++) {
			NumeroOcultoSolucion.adivinos.add(new HiloAdivinoSolucion(NumeroOcultoSolucion,i+1));
			NumeroOcultoSolucion.adivinos.get(i).start();
		}
		
		//Mientras no se adivine el número el hilo principal debe esperar
		while(!NumeroOcultoSolucion.adivinado);
		
		//Se obtiene el tiempo empleado en adivinar el número
		tiempoEmpleado = System.currentTimeMillis()-tiempoEmpleado;
		
		//Se obtiene el hilo (adivino) que ha adivinado el número
		/* Lo siguiente usa expresiones lambda, es posible que esto te diese
		 * problemas de compilación. Lo cambio por las líneas que le siguen
		 * HiloAdivinoSolucion HiloAdivinoSolucion = (HiloAdivinoSolucion) NumeroOcultoSolucion.adivinos.stream().filter(adivino -> adivino.esAdivino()).toArray()[0];*/
		for(HiloAdivinoSolucion adivino:NumeroOcultoSolucion.adivinos) {
			if(adivino.esAdivino()) {
				HiloAdivinoSolucion = adivino;
				break;
			}
		}
		
		//Se muestra información completa sobre el resultado de la adivinación
		System.out.println("El " + HiloAdivinoSolucion.getName() + " ha adivinado el numero." +
		"\nha necesitado " + HiloAdivinoSolucion.getIntentos() + " intentos." +
		"\nSe ha tardado " + (float)(tiempoEmpleado/1000F) + " segundos en acertar el numero oculto " + 
				NumeroOcultoSolucion.numero + ".");
	}
	
	/**
	 * Este método será llamado por cada hilo adivino para realizar cada
	 * intento de adivinación. El método está sincronizado, quiere decir
	 * que sólo un hilo podrá ejecutarlo al mismo tiempo, el primero que se
	 * le conceda la ejecución bloqueará al resto que quiere entrar. Garantizando
	 * la exclusión mútua.
	 * @param num Número propuesto
	 * @return -1 si ya se había adivinado el número, 1 si se adivina el número
	 *  y 0 si el número todavía no ha sido adivinado
	 */
	public synchronized int propuestaNumero(int num) {
		if(this.adivinado) return YA_ADIVINADO;
		if(num == this.numero) {
			this.adivinado = true;
			return LO_HAS_ADIVINADO;
		}
		return POR_ADIVINAR;
	}
}