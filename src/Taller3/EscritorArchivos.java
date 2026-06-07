package Taller3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritorArchivos {

	public void escribirHechizo(List<Hechizo> hechizos) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter("Hechizos.txt"));
		String linea;
		for (Hechizo h : hechizos) {
			linea = h.escribirse();
			escritor.write(linea);
			escritor.newLine();
			}
		escritor.close();
	}
	
	public void escribirMago(List<Mago> magos) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter("Magos.txt"));
			String linea;
			for (Mago m : magos) {
				linea = m.getNombre() + ";";
				int contadorHechizosMago = m.getHechizos().size();
				int i = 1;
				
				for (Hechizo h : m.getHechizos()) {
					linea = linea + h.getNombre();
					if ( i < contadorHechizosMago) {
						linea = linea + "|";
					}
					i++;
				}
				escritor.write(linea);
				escritor.newLine();
		}
		escritor.close();
	}
}
