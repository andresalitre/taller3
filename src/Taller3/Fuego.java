package Taller3;

public class Fuego extends Hechizo {
    private int quemadura;

    public Fuego(String nombre, String tipo, int daño, int quemadura) {
        super(nombre, tipo, daño);
        this.quemadura = quemadura;
    }
    
    public String escribirse() {
        return getNombre() + ";Fuego;" + getDaño() + ";" + quemadura;
    }
}