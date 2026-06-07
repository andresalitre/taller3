package Taller3;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LectorArchivos {

    public static List<Hechizo> leerHechizos(String archivo) throws FileNotFoundException {
        List<Hechizo> hechizos = new ArrayList<>();
        Scanner lector = new Scanner(new File(archivo));

        while (lector.hasNextLine()) {
            String linea = lector.nextLine();
            String[] partes = linea.split(";");

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
                    String[] tipoPlanta = partes[3].split(",");
                    h = new Planta(nombre, tipo, daño, Integer.valueOf(tipoPlanta[0]), Integer.valueOf(tipoPlanta[1]));
                    break;
                case "Agua":
                    String[] tipoAgua = partes[3].split(",");
                    h = new Agua(nombre, tipo, daño, Integer.valueOf(tipoAgua[0]), Integer.valueOf(tipoAgua[1]));
                    break;
            }

            hechizos.add(h);
        }

        lector.close();
        return hechizos;
    }

    public static List<Mago> leerMagos(String archivo, List<Hechizo> hechizos) throws FileNotFoundException {
        List<Mago> magos = new ArrayList<>();
        Scanner lector = new Scanner(new File(archivo));

        while (lector.hasNextLine()) {
            String linea = lector.nextLine();
            String[] partes = linea.split(";");

            String nombre = partes[0];
            Mago m = new Mago(nombre);

            if (partes.length > 1 && !partes[1].isEmpty()) {
	            String[] hechizosMago = partes[1].split("\\|");
	            
	            for (String hm : hechizosMago) {
	                for (Hechizo h : hechizos) {
	                    if (hm.equals(h.getNombre())) {
	                        m.añadirHechizos(h);
	                    }
	                }
	            }
            }
            magos.add(m);
        }

        lector.close();
        return magos;
    }
}