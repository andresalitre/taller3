package Taller3;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Administrador {
	private List<Mago> magos;
	private List<Hechizo> hechizos;
	private Scanner sc;
	private EscritorArchivos escritor;
	 
	public Administrador(List<Mago> magos, List<Hechizo> hechizos) {
        this.magos = magos;
        this.hechizos = hechizos;
        this.sc = new Scanner(System.in);
        this.escritor = new EscritorArchivos();
    }
	
	public void menu() throws IOException {
    	String opcion;
    	do {
		System.out.println("1. Agregar Mago\r\n"
				+ "2. Modificar Mago\r\n"
				+ "3. Eliminar Mago\r\n"
				+ "4. Agregar Hechizo\r\n"
				+ "5. Modificar Hechizo\r\n"
				+ "6. Eliminar Hechizo\r\n"
				+ "7. Salir");
		opcion = sc.nextLine();
		
		switch (opcion) {
	    case "1":
	        agregarMago();
	        break;
	    case "2":
	        modificarMago();
	        break;
	    case "3":
	        eliminarMago();
	        break;
	    case "4":
	        agregarHechizo();
	        break;
	    case "5":
	        modificarHechizo();
	        break;
	    case "6":
	        eliminarHechizo();
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
	
	private void agregarMago() throws IOException { // solo agrega mago
		System.out.println("Ingresa el nombre del mago: ");
		String nombre = sc.nextLine();
		magos.add(new Mago(nombre));
		System.out.println("Mago añadido correctamente!");
		escritor.escribirMago(magos);
	}
	
	private void modificarMago() {
		
	}
	
	private void eliminarMago() {
		
	}
	
	private void agregarHechizo() {
		
	}
	
	private void modificarHechizo() {
		
	}
	
	private void eliminarHechizo() {
		
	}

}
