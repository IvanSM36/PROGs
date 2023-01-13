package PrimerTrimestre.Tema01;

public class Lanzador {
	
	public static void LanzarSumador(Integer n1, Integer n2) {
		String clase = "Tema01";
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
		pb.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lanzador l = new Lanzador();
		l.LanzarSumador(1, 51);
		l.LanzarSumador(51, 100);
		System.out.println("OK");
	}

}
