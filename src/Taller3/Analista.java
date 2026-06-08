package Taller3;

import java.util.ArrayList;
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
	
	private int puntajeMago(Mago m) {
        int total = 0;
        for (Hechizo h : m.getHechizos()) {
            total += h.getDaño();
        }
        return total;
    }
	
	private void top10Hechizos() {
        List<Hechizo> copia = new ArrayList<>(hechizos);
        System.out.println("=== Top 10 Mejores Hechizos ===");
        int limite = copia.size() < 10 ? copia.size() : 10;

        for (int i = 0; i < limite; i++) {
            int indiceMayor = 0;
            for (int j = 1; j < copia.size(); j++) {
                if (copia.get(j).getDaño() > copia.get(indiceMayor).getDaño()) {
                    indiceMayor = j;
                }
            }
            Hechizo h = copia.get(indiceMayor);
            System.out.println((i + 1) + ") " + h.getNombre() + " [" + h.getTipo() + "] - Daño: " + h.getDaño());
            copia.remove(indiceMayor);
        }
    }
	
	private void top3Magos() {
        List<Mago> copia = new ArrayList<>(magos);
        System.out.println("=== Top 3 Mejores Magos ===");
        int limite = copia.size() < 3 ? copia.size() : 3;

        for (int i = 0; i < limite; i++) {
            int indiceMayor = 0;
            for (int j = 1; j < copia.size(); j++) {
                if (puntajeMago(copia.get(j)) > puntajeMago(copia.get(indiceMayor))) {
                    indiceMayor = j;
                }
            }
            Mago m = copia.get(indiceMayor);
            System.out.println((i + 1) + ") " + m.getNombre() + " - Puntuación: " + puntajeMago(m));
            copia.remove(indiceMayor);
        }
    }
	
	private void mostrarHechizos() {
        System.out.println("=== Todos los Hechizos ===");
        int i = 1;
        for (Hechizo h : hechizos) {
            System.out.println(i + ") " + h.getNombre() + " [" + h.getTipo() + "]");
            i++;
        }
    }
	
	private void mostrarMagos() {
        System.out.println("=== Todos los Magos ===");
        int i = 1;
        for (Mago m : magos) {
            System.out.println(i + ") " + m.getNombre());
            i++;
        }
    }
	
	private void mostrarHechizosConPuntaje() {
        System.out.println("=== Hechizos con Puntuación ===");
        int i = 1;
        for (Hechizo h : hechizos) {
            System.out.println(i + ") " + h.getNombre() + " [" + h.getTipo() + "] - Daño: " + h.getDaño());
            i++;
        }
    }
	
	private void mostrarMagosConPuntaje() {
        System.out.println("=== Magos con Puntuación ===");
        int i = 1;
        for (Mago m : magos) {
            System.out.println(i + ") " + m.getNombre() + " - Puntuación: " + puntajeMago(m));
            i++;
        }
    }
}
