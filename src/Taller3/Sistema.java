package Taller3;

import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Sistema {
    private List<Mago> magos;
    private List<Hechizo> hechizos;
    private Administrador admin;
    private Analista analista;

    public Sistema() throws FileNotFoundException {
        this.hechizos = LectorArchivos.leerHechizos("Hechizos.txt");
        this.magos = LectorArchivos.leerMagos("Magos.txt", hechizos);
        this.admin = new Administrador(magos, hechizos);
        this.analista = new Analista(magos, hechizos);
    }

    public void iniciar() throws IOException {
        menu();
    }
    
    public void menu() throws IOException {
    	Scanner sc = new Scanner(System.in);
    	String opcion;
    	do {
    		System.out.println("1) Administrador\n" + "2) Analista\n" + "3) Cerrar menú");
    		opcion = sc.nextLine();
    		
    		switch (opcion) {
    		case "1":
    			admin.menu();
    			break;
    		case "2":
    			analista.menu();
    			break;
    		case "3":
    			System.out.println("Cerrando sistema...");
    			return;
    		default:
    			System.out.println("Opcion invalida\n");
    			break;
    		}
    		
    	} while (true);
    	
    }

    private void Testing() {
        for (Mago m : magos) {
            System.out.println(m.getNombre());
            for (Hechizo h : m.getHechizos()) {
                System.out.println(h.getNombre() + " " + h.getTipo() + " " + h.getDaño());
            }
        }
    }
}