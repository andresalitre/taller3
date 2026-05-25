package Taller3;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Sistema {
	private List<Mago> magos;
	private List<Hechizo> hechizos;
	
	public Sistema() throws FileNotFoundException {
		this.magos = new ArrayList<>();
		this.hechizos = new ArrayList<>();
		leerHechizos("Hechizos.txt");
		leerMagos("Magos.txt");
	}
	
	public void iniciar() {
		Testing();
	}
	
	private void leerMagos(String archivo) throws FileNotFoundException {
		Scanner lector = new Scanner(new File(archivo));
		while (lector.hasNextLine()) 
		{
			String linea = lector.nextLine();
			String partes[] = linea.split(";");
			
			String nombre = partes[0];
			
			Mago m = new Mago(nombre);
			
			// aqui añado los hechizos
			String hechizosMago[] = partes[1].split("\\|"); // regex raro
			
			for (String hm : hechizosMago) {
				for(Hechizo h : hechizos) {
					if(hm.equals(h.getNombre())) {
						m.añadirHechizos(h);
					}
				}
			}
			
			magos.add(m);
			
		}
		
	}
	
	private void leerHechizos(String archivo) throws FileNotFoundException {
		Scanner lector = new Scanner(new File(archivo));
		while (lector.hasNextLine()) 
		{
			String linea = lector.nextLine();
			String partes[] = linea.split(";");
			
			String nombre = partes[0];
			String tipo = partes[1];
			int daño = Integer.valueOf(partes[2]);
			
			Hechizo h = null;
			
			switch (tipo) {
			case "Fuego":
				h = new Fuego(nombre, tipo, daño, Integer.valueOf(partes[3]));
				break;
			case "Tierra":
				h = new Tierra(nombre, tipo, daño, Integer.valueOf(partes[3]));
				break;
			case "Planta":
				String tipoPlanta[] = partes[3].split(",");
				h = new Planta(nombre, tipo, daño, Integer.valueOf(tipoPlanta[0]), Integer.valueOf(tipoPlanta[1]));
				break;
			case "Agua":
				String tipoAgua[] = partes[3].split(",");
				h = new Agua(nombre, tipo, daño, Integer.valueOf(tipoAgua[0]), Integer.valueOf(tipoAgua[1]));
				break;
			}
			
			hechizos.add(h);
			
		}
		lector.close();
	}
	
	private void Testing() {
		for(Mago m : magos) {
			System.out.println(m.getNombre());
			for(Hechizo h : m.getHechizos()) {
				System.out.println(h.getNombre() + " " + h.getTipo() + " " + h.getDaño());
			}
		}
	}
	

	
}
