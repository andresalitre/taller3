package Taller3;

public class Tierra extends Hechizo {
    private int defensa;

    public Tierra(String nombre, String tipo, int daño, int defensa) {
        super(nombre, tipo, daño);
        this.defensa = defensa;
    }
}