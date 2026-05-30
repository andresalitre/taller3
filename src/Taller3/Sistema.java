package Taller3;

import java.util.List;
import java.io.FileNotFoundException;

public class Sistema {
    private List<Mago> magos;
    private List<Hechizo> hechizos;

    public Sistema() throws FileNotFoundException {
        this.hechizos = LectorArchivos.leerHechizos("Hechizos.txt");
        this.magos = LectorArchivos.leerMagos("Magos.txt", hechizos);
    }

    public void iniciar() {
        Testing();
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