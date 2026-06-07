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
    
    public int modificarse() {
    	System.out.println("3) Duración stun\n4) Cantidad de plantas");
    	return 4;
    }
    
    public void modificar(int opcion, int valor) {
        switch (opcion) {
            case 3: 
            	this.stun = valor; 
            	break;
            case 4: 
            	this.plantas = valor; 
            	break;
        }
    }
}