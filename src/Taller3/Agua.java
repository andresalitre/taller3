package Taller3;

public class Agua extends Hechizo {
    private int heal;
    private int presion;

    public Agua(String nombre, String tipo, int daño, int heal, int presion) {
        super(nombre, tipo, daño);
        this.heal = heal;
        this.presion = presion;
    }
    
    public String escribirse() {
        return getNombre() + ";Agua;" + getDaño() + ";" + heal + "," + presion;
    }
}