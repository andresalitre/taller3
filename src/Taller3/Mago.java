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
		hechizos.add(h);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<Hechizo> getHechizos() {
		return hechizos;
	}
	
	public void cambiarNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void eliminarHechizo(int opcion) {
		hechizos.remove(opcion);
	}
	
	public void mostrarHechizos() {
		int i = 1;
		for (Hechizo h : hechizos) {
			System.out.println(i + ") " + h.getNombre());
			i++;
		}
	}
	
	public String hechizoAñadido(String añadido) {
		return añadido;
	}
	
}
