package Taller3;

import java.util.List;
import java.util.Scanner;

public class Analista {
	private List<Mago> magos;
	private List<Hechizo> hechizos;
	
	public Analista(List<Mago> magos, List<Hechizo> hechizos) {
        this.magos = magos;
        this.hechizos = hechizos;
    }

	public void menu() {
		Scanner sc = new Scanner(System.in);
    	String opcion;
    	do {
		System.out.println("1. Top 10 Mejores Hechizos\r\n"
				+ "2. Top 3 Mejores Magos\r\n"
				+ "3. Mostrar todos los Hechizos\r\n"
				+ "4. Mostrar todos los magos\r\n"
				+ "5. Mostrar todos los Hechizos junto a su puntuacion\r\n"
				+ "6. Mostrar todos los magos junto a su puntuacion\r\n"
				+ "7. Salir");
		opcion = sc.nextLine();
		
		switch (opcion) {
	    case "1":
	        top10Hechizos();
	        break;
	    case "2":
	        top3Magos();
	        break;
	    case "3":
	        mostrarHechizos();
	        break;
	    case "4":
	        mostrarMagos();
	        break;
	    case "5":
	        mostrarHechizosConPuntaje();
	        break;
	    case "6":
	        mostrarMagosConPuntaje();
	        break;
	    case "7":
	        System.out.println("Saliendo...");
	        break;
	    default:
	        System.out.println("Opcion invalida\n");
	        break;
	}
		
		
    	} while (!opcion.equals("7"));
	}
	
	private void top10Hechizos() {
		
	}
	
	private void top3Magos() {
		
	}
	
	private void mostrarHechizos() {
		
	}
	
	private void mostrarMagos() {
		
	}
	
	private void mostrarHechizosConPuntaje() {
		
	}
	
	private void mostrarMagosConPuntaje() {
		
	}
}
