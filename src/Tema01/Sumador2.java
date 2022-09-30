/**
 * 
 */
package Tema01;

import java.util.Scanner;

/**
 * @author IvanSM
 *
 */
public class Sumador2 {

	public static int sumaTotalEntreDosnum(int num, int num2 ) {
		
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
		Scanner scan = new Scanner(System.in);

		System.out.print("Introduzca un numero: ");
		int num = scan.nextInt();
		System.out.print("Introduzca otro numero: ");
		int num2 = scan.nextInt();

		System.out.println("La suma total entre " + num + " y " + num2 + " es: " + sumaTotalEntreDosnum(num, num2));
	}

}
