/**
 * 
 */
package Tema02;

/**
 * @author IvanSM
 *
 */
public class EjecutorTareaCompleja implements Runnable {
	private String nombre;
	int numEjecucion;

	public EjecutorTareaCompleja(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		String cad;
		while (numEjecucion < 100) {
			for (double i = 0; i < 4999.99; i = i + 0.04) {
				Math.sqrt(i);
			}
			cad = "Soy el hilo " + this.nombre;
			cad += " y mi valor de i es " + numEjecucion;
			System.out.println(cad);
			numEjecucion++;
		}
	}

}
