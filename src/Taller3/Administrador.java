package Taller3;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Administrador {
	private List<Mago> magos;
	private List<Hechizo> hechizos;
	private Scanner sc;
	private EscritorArchivos escritor;
	 
	public Administrador(List<Mago> magos, List<Hechizo> hechizos) {
        this.magos = magos;
        this.hechizos = hechizos;
        this.sc = new Scanner(System.in);
        this.escritor = new EscritorArchivos();
    }
	
	public void menu() throws IOException { //menu de admin
    	String opcion;
    	do {
		System.out.println("1. Agregar Mago\r\n"
				+ "2. Modificar Mago\r\n"
				+ "3. Eliminar Mago\r\n"
				+ "4. Agregar Hechizo\r\n"
				+ "5. Modificar Hechizo\r\n"
				+ "6. Eliminar Hechizo\r\n"
				+ "7. Salir");
		opcion = sc.nextLine();
		
		switch (opcion) {
	    case "1":
	        agregarMago();
	        break;
	    case "2":
	        modificarMago();
	        
	        break;
	    case "3":
	        eliminarMago();
	        break;
	    case "4":
	        agregarHechizo();
	        break;
	    case "5":
	        modificarHechizo();
	        break;
	    case "6":
	        eliminarHechizo();
	        break;
	    case "7":
	        System.out.println("Saliendo...");
	        break;
	    default:
	        System.out.println("Opcion invalida\n");
	        break;
	}
		
    	} while (!opcion.equals("7"));
	}
	
	private void agregarMago() throws IOException { //crear mago, pide nombre y muestra los hechizos para agregarle uwwu
	    System.out.println("Ingresa el nombre del mago: ");
	    String nombre = sc.nextLine();
	    Mago m = new Mago(nombre);
	    System.out.println("Agrega al menos un hechizo (0 para terminar, mínimo 1):");
	    mostrarHechizos();
	    int opcion;
	    do { //agregar minimo 1 hechizo al crear el mago
	        opcion = seleccionar(0,hechizos.size());
	        if (opcion != 0) {
	            m.añadirHechizo(hechizos.get(opcion - 1));
	            System.out.println(hechizos.get(opcion - 1).getNombre() + " añadido! (Agrega otro o usa '0' para volver)");
	        } else if (m.getHechizos().isEmpty()) {
	            System.out.println("Debes agregar al menos un hechizo.");
	        }
	    } while (opcion != 0 || m.getHechizos().isEmpty());

	    magos.add(m);
	    escritor.escribirMago(magos);
	    System.out.println("Mago añadido correctamente!");
	}
	
	private void modificarMago() throws IOException {
	    System.out.println("¿Que mago deseas modificar? (Usa '0' para volver)");
	    mostrarMagos();
	    int opcion = seleccionar(0, magos.size());
	    if (opcion == 0) return;
	    Mago m = magos.get(opcion - 1);

	    System.out.println("Mago seleccionado: " + m.getNombre() + "\n0) Volver\n1) Cambiar nombre\n2) Agregar hechizo\n3) Quitar hechizo");
	    opcion = seleccionar(0, 3);

	    switch (opcion) {
	        case 0:
	            return;
	        case 1:
	            System.out.print("Ingrese nuevo nombre: ");
	            String nombre = sc.nextLine();
	            m.cambiarNombre(nombre);
	            break;
	        case 2:
	            mostrarHechizos();
	            int agregar = seleccionar(0, hechizos.size());
	            if (agregar != 0) {
	                m.añadirHechizo(hechizos.get(agregar - 1));
	                System.out.println("¡Hechizo añadido!");
	            }
	            break;
	        case 3:
	            m.mostrarHechizos();
	            int quitar = seleccionar(0, m.getHechizos().size());
	            if (quitar != 0) {
	                m.eliminarHechizo(quitar - 1);
	                System.out.println("Hechizo eliminado!");
	            }
	            break;
	    }
	    System.out.println("Cambio exitoso!");
	    escritor.escribirMago(magos);
	}
	
	private void eliminarMago() throws IOException { //borra el mago con .remove de la lista, luego modifica el archivo
		System.out.println("¿Que mago quieres eliminar? (Usa '0' para volver)");
		System.out.println("0) Volver");
		mostrarMagos();
		int opcion = seleccionar(0,magos.size());
		if (opcion == 0) {
			System.out.println("Regresando...");
			return;
		}
		opcion = opcion - 1;
		System.out.println("¡El mago " + magos.get(opcion).getNombre() + " ha sido eliminado!");
		magos.remove(opcion);
		escritor.escribirMago(magos);
	}
	
	private void agregarHechizo() throws IOException {
	    System.out.println("¿De que tipo sera el nuevo hechizo?");
	    System.out.println("1) Fuego\n2) Agua\n3) Planta\n4) Tierra");
	    int tipo = seleccionar(1,4);
	    System.out.println("Ingrese nombre del hechizo: ");
	    String nombre = sc.nextLine();
	    System.out.println("Ingrese daño del hechizo: ");
	    int daño = seleccionarSinMaximo();
	    Hechizo h;

	    switch (tipo) {
	        case 1:
	            System.out.println("Ingrese duracion de quemadura: ");
	            int quemadura = seleccionarSinMaximo();
	            h = new Fuego(nombre, "Fuego", daño, quemadura);
	            break;
	        case 2:
	            System.out.println("Ingrese cantidad de heal: ");
	            int heal = seleccionarSinMaximo();
	            System.out.println("Ingrese presion del agua: ");
	            int presion = seleccionarSinMaximo();
	            h = new Agua(nombre, "Agua", daño, heal, presion);
	            break;
	        case 3:
	            System.out.println("Ingrese duracion del stun: ");
	            int stun = seleccionarSinMaximo();
	            System.out.println("Ingrese cantidad de plantas: ");
	            int plantas = seleccionarSinMaximo();
	            h = new Planta(nombre, "Planta", daño, stun, plantas);
	            break;
	        case 4:
	            System.out.println("Ingrese mejora de defensa: ");
	            int defensa = seleccionarSinMaximo();
	            h = new Tierra(nombre, "Tierra", daño, defensa);
	            break;
	        default:
	            return; //esto por si acaso pero no deberia pasar pq segun el rango que el usuario elige de 1 a 4 se selecciona el tipo
	    }

	    hechizos.add(h);
	    escritor.escribirHechizo(hechizos);
	    System.out.println("¡Hechizo añadido correctamente!");
	}
		
	
	private void modificarHechizo() throws IOException { // modificar hechizos
		System.out.println("¿Que hechizo deseas modificar? (Usa '0' para volver)");
		mostrarHechizos();
		int opcion = seleccionar(0, hechizos.size());
		if (opcion == 0) return;
		Hechizo h = hechizos.get(opcion - 1);
		System.out.println("Hechizo a modificar: " + h.getNombre() + " | (Usa '0' para volver)\n¿Que deseas modificar?\n0) Volver\n1) Nombre\n2) Daño"); // printa lo basico
		opcion = seleccionar(0,h.modificarse()); // elegir el hechizo a modificar, el metodo "modificarse" printea las otras opciones segun el tipo del hechizo
		
		switch (opcion) { //si es 1 cambia nombre, si es 2 cambia daño, si es otro, cada clase de hechizo tiene su metodo para cambiar
			case 1:
				System.out.print("Ingrese nuevo nombre: ");
				String nombre = sc.nextLine();
				h.cambiarNombre(nombre);
				break;
			case 2:
				System.out.print("Ingrese nuevo daño: ");
				int daño = seleccionarSinMaximo();
				h.cambiarDaño(daño);
				break;
			default:
				System.out.print("Ingrese nuevo valor: ");
				int valor = seleccionarSinMaximo();
				h.modificar(opcion, valor);
		}
		System.out.println("Cambio exitoso!");
		escritor.escribirHechizo(hechizos); //guardar
	}
	
	private void eliminarHechizo() throws IOException { //eliminar el hechizo con .remove de la lista, luego modifica el archivo
		System.out.println("¿Que hechizo quieres eliminar? (Usa '0' para volver)");
		System.out.println("0) Volver");
		mostrarHechizos();
		int opcion = seleccionar(0,hechizos.size());
		if (opcion == 0) {
			System.out.println("Regresando...");
			return;
		}
		opcion = opcion - 1;
		System.out.println("¡El hechizo " + hechizos.get(opcion).getNombre() + " ha sido eliminado!");
		hechizos.remove(opcion);
		escritor.escribirHechizo(hechizos);
		
	}
	
	private void mostrarMagos() { //muestra todos los maguitos
		int i = 1;
		for (Mago m : magos) {
			System.out.println(i + ") " + m.getNombre());
			i++;
		}
	}
	
	private void mostrarHechizos() { //muestra todos los hechizos
		int i = 1;
		for (Hechizo h : hechizos) {
			System.out.println(i + ") " + h.getNombre());
			i++;
		}
		
	}
	
	public int seleccionar(int min, int max) { //seleccionar, el metodo para que el usuario elija un numero entre un min y un maximo, osea para retornar un numero entre un rango
	    int opcion = -1;
	    while (opcion < min || opcion > max) {
	        if (sc.hasNextInt()) {
	            opcion = sc.nextInt();
	            sc.nextLine();
	            if (opcion < min || opcion > max) {
	                System.out.println("Número fuera de rango, intente nuevamente.");
	            }
	        } else {
	            System.out.println("Debe ingresar un número, intente nuevamente.");
	            sc.nextLine();
	        }
	    }
	    return opcion;
	}
	
	public int seleccionarSinMaximo() { //seleccionar un numero entre 0 e infinito 
	    int opcion = -1;
	    while (opcion < 0) {
	        if (sc.hasNextInt()) {
	            opcion = sc.nextInt();
	            sc.nextLine();
	            if (opcion < 0) {
	                System.out.println("Número fuera de rango, intente nuevamente.");
	            }
	        } else {
	            System.out.println("Debe ingresar un número, intente nuevamente.");
	            sc.nextLine();
	        }
	    }
	    return opcion;
	}

}
