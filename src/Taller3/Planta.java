package Taller3;

public class Planta extends Hechizo {
    private int stun;
    private int plantas;

    public Planta(String nombre, String tipo, int daño, int stun, int plantas) {
        super(nombre, tipo, daño);
        this.stun = stun;
        this.plantas = plantas;
    }
    
    public String escribirse() {
        return getNombre() + ";Planta;" + getDaño() + ";" + stun + "," + plantas;
    }
}