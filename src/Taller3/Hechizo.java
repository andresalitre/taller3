package Taller3;

public class Hechizo {
	private String nombre;
	private String tipo;
	private int daño;
	
	public Hechizo(String nombre, String tipo, int daño) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.daño = daño;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getDaño() {
		return daño;
	}

	public String escribirse() {
		return null;
	}
	
	public int modificarse() {
		return 0;
	}
	
	public void cambiarDaño(int daño) {
		this.daño = daño;
	}
	
	public void cambiarNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void modificar(int opcion, int valor) {
		
	}
	
}
