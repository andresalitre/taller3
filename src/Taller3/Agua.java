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
    
    public int modificarse() {
    	System.out.println("3) Curación\n4) Presión");
    	return 4;
    }
    
    public void modificar(int opcion, int valor) {
        switch (opcion) {
            case 3: 
            	this.heal = valor; 
            	break;
            case 4: 
            	this.presion = valor; 
            	break;
        }
    }
}