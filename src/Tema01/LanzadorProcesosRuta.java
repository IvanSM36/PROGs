package Tema01;
/**
 * 
 */

/**
 * @author IvanSM
 *
 */
public class LanzadorProcesosRuta {

	public void ejecutar(String ruta) {
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder(ruta);
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		LanzadorProcesosRuta lp = new LanzadorProcesosRuta();
		lp.ejecutar(ruta);
		System.out.println("Finalizado");
	}

}
