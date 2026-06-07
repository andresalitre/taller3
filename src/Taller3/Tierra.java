package Taller3;

public class Tierra extends Hechizo {
    private int defensa;

    public Tierra(String nombre, String tipo, int daño, int defensa) {
        super(nombre, tipo, daño);
        this.defensa = defensa;
    }
    
    public String escribirse() {
        return getNombre() + ";Tierra;" + getDaño() + ";" + defensa;
    }
    
    public int modificarse() {
    	System.out.println("3) Defensa");
    	return 3;
    }
    
    public void modificar(int opcion, int valor) {
		this.defensa = valor;
	}
    
}