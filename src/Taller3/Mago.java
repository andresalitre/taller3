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
	
	public void añadirHechizos(Hechizo h) {
		hechizos.add(h);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<Hechizo> getHechizos() {
		return hechizos;
	}
	
	
}
