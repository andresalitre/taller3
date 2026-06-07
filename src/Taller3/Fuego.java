package Taller3;

import java.util.Scanner;

public class Fuego extends Hechizo {
    private int quemadura;

    public Fuego(String nombre, String tipo, int daño, int quemadura) {
        super(nombre, tipo, daño);
        this.quemadura = quemadura;
    }
    
    public String escribirse() {
        return getNombre() + ";Fuego;" + getDaño() + ";" + quemadura;
    }
  
    
    public int modificarse() {
    	System.out.println("3) Quemadura");
    	return 3;
    }
    
	public void modificar(int opcion, int valor) {
		this.quemadura = valor;
	}
    
    
}