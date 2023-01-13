/**
 * 
 */
package PrimerTrimestre.Tema01;

import java.io.File;

/**
 * @author IvanSM
 *
 */
public class Lanzador2 {
	public void lanzarSumador(Integer n1, Integer n2, String fichResultado) {
		String clase = "Tema01";
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(fichResultado));
			pb.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lanzador2 l2 = new Lanzador2();
		l2.lanzarSumador(1, 5, "result1.txt");
	}

}
