package PrimerTrimestre.Tema02.Multihilo.src.Banco;

import java.util.Scanner;

public class OperacionesBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creamos un obejeto Datos
		Datos q = new Datos();

		// Pedimos por teclado el ingreso
		System.out.println("Introduce primer ingreso");
		Scanner sc = new Scanner(System.in);
		int primer_ingreso = sc.nextInt(); //Recogemos en una variable el dato introducido por teclado

		// Llamamos a los procesos sincronizados para realizar cada funcion
		new Ingresar(q, primer_ingreso); // Proceso con un hilo que se encarga de la funcion put que añade al objeto datos el primer ingreso pedido por teclado
		new Gastar(q, 300); // Proceso con un hilo que se encarga de la funcion get que resta la cantidad indicada al saldo del objeto 
		new Ingresar(q, 10); // Vuelve a llamar al proceso Ingresar para añadir nuevo saldo al objeto datos
		new Ingresar(q, 80); // Vuelve a llamar al proceso Ingresar para añadir nuevo saldo al objeto datos
		new Gastar(q, 1000); // Vuelve a llamar al proceso Gastar para restar saldo al objeto datos
		

		// Cerramos conexion del Scanner
		sc.close();
	}

}

//Clase datos
class Datos {

	int saldo;	
	
	//Sincronizamos el metodo get 
	synchronized void get(int gasto) {
		/* *
		 * Si el gasto es mayor al saldo entra en el bucle y pone el proceso en espera y lanza el siguiente proceso, una vez termine el segundo proceso, 
		 * vuelve a ejecutarse el primer proceso y vuelvea comprobar si el gasto es mayor al saldo,
		 * si sigue siendo mayor el gasto que el sueldo se vuelve a poner en espera, si no, se sale del bucle y realiza el gasto 
		 */
		while (gasto > saldo) {
			try {
				System.out.println("Pido " + gasto + " hay " + saldo);
				System.out.println("----Duermo----");
				wait(); //Lo ponemos en espera hasta que para que 
				System.out.println("----Despierto----");
			} catch (InterruptedException e) {
				System.out.println("InterruptedException capturada");
			}
		}
		
		//si el saldo es mayor que el gasto sale del bucle y realiza la operacion.
		saldo = saldo - gasto; //Restamos al saldo el gasto
		System.out.println("Gasto de  " + gasto); // Mostramos por consola el valor del gasto
		System.out.println("Nuevo saldo en cuenta de:" + saldo);// Mostramos por consola el saldo total
	}
	
	//Sincronizamos el metodo put 
	synchronized void put(int ingreso) {
		saldo = saldo + ingreso; // Sumamos a la cantidad de saldo el ingreso
		System.out.println("Ingreso de " + ingreso); // Mostramos por consola el valor del ingreso
		System.out.println("Nuevo saldo en cuenta de:" + saldo); //Mostramos por pantalla el saldo total
		notify();
	}

}

// Clase Ingresar que extiende de Runnable
class Ingresar implements Runnable {
	
	Datos q;
	int i;

	/* *
	 * Metodo que ingresa en el objeto Datos el saldo recogido por teclado y lo lanza
	 * Recoge por parametro el Objeto datos y la cantidad a ingresar
	 */
	
	Ingresar(Datos q, int i) {
		this.q = q; //Objeto dato
		this.i = i; // cantidad a ingresar
		new Thread(this, "Ingresar").start(); // Creamos un hilo para realizar la operacion y lanzamos el proceso
	}

	//Hilo con la funcion para ingresar saldo
	public void run() {
		// TODO Auto-generated method stub
		q.put(i); // LLamamos a la funcion  que suma al saldo el ingreso recogido por parametro
	}

}

//Clase Gastar que extiende de Runnable
class Gastar implements Runnable {
	Datos q;
	int i;

	/* *
	 * Metodo que resta saldo al objeto Datos 
	 * Recoge por parametro el objeto y la cantidad a gastar
	 */
	Gastar(Datos q, int i) {
		this.q = q; // Objeto dato
		this.i = i; // cantidad a gastar
		new Thread(this, "Consumidor").start(); //Creamos un hilo para realizar la operacion y lanzamos el proceso
	}

	//Hilo con la funcion para obtener el gasto
	@Override
	public void run() {
		// TODO Auto-generated method stub
		q.get(i); // LLamamos a la funcion get que resta la cantidad recogida por parametro
	
	}

}
