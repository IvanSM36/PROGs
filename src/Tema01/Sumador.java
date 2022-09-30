/**
 * 
 */
package Tema01;

import java.util.Scanner;

/**
 * @author IvanSM
 *
 */
public class Sumador {

	public static int sumar(int num, int num2 ) {
		
		int sumaTotal = 0;
		
		for (int i = num; i < num2; i++) {
			sumaTotal += i;
		}	
		return sumaTotal;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sumador s = new Sumador();
		int num = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int resultado = s.sumar(num, num2);
		
		System.out.println("La suma total entre " + num + " y " + num2 + " es: " + resultado);
	}


}
