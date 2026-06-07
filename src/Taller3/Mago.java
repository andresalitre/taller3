package Taller3;

import java.util.ArrayList;
import java.util.List;

public class Mago {
	private String nombre;
	private List<Hechizo> hechizos;
	
	public Mago(String nombre) {
		this.nombre = nombre;
		this.hechizos = new ArrayList<>();
	}
	
	public void añadirHechizo(Hechizo h) {
	    if (!hechizos.contains(h)) { //si la lista de hechizos no lo tiene lo agrega
	        hechizos.add(h);
	    } else {
	        System.out.println("El mago ya tiene ese hechizo."); // si ya lo tiene no lo agrega
	    }
	}
	
	public String getNombre() {
		return nombre; //get el nombre
	}
	
	public List<Hechizo> getHechizos() { //get de el hechizo
		return hechizos;
	}
	
	public void cambiarNombre(String nombre) { //cambiar el nombre
		this.nombre = nombre;
	}
	
	public void eliminarHechizo(int opcion) { //borrar hechizo
		hechizos.remove(opcion);
	}
	
	public void mostrarHechizos() { //mostrar hechizos del mago, prints
		int i = 1;
		for (Hechizo h : hechizos) {
			System.out.println(i + ") " + h.getNombre());
			i++;
		}
	}
	
	public String hechizoAñadido(String añadido) {
		return añadido; //añadir hechizo
	}
	
}
