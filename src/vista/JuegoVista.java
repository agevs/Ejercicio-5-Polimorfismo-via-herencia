package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Carta;
import modelo.Jugador;

public class JuegoVista {

    private Scanner scanner;

    public JuegoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("\n UVG CARD BATTLE ");
        System.out.println("1. Listar cartas");
        System.out.println("2. Buscar carta por ID");
        System.out.println("3. Buscar carta por nombre");
        System.out.println("4. Ordenar cartas por costo de energia");
        System.out.println("5. Iniciar juego");
        System.out.println("6. Salir");
    }

    public int leerOpcion() {
        while (true) {
            System.out.print("Seleccione una opcion: ");

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarCarta(Carta carta) {
        if (carta == null) {
            System.out.println("Carta no encontrada.");
        } else {
            System.out.println(carta);
        }
    }

    public void mostrarCartas(ArrayList<Carta> cartas) {
        System.out.println("\n CARTAS ");

        if (cartas.isEmpty()) {
            System.out.println("No hay cartas disponibles.");
            return;
        }

        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }

    public void mostrarEstadoJugador(Jugador jugador) {
        System.out.println("\n" + jugador);
    }

    public void mostrarMano(Jugador jugador) {
        System.out.println("\n MANO DE " 
                + jugador.getNombre().toUpperCase() + " ");

        ArrayList<Carta> mano = jugador.getMano();

        if (mano.isEmpty()) {
            System.out.println("No tienes cartas en la mano.");
            return;
        }

        for (int i = 0; i < mano.size(); i++) {
            System.out.println((i + 1) + ". " + mano.get(i));
        }
    }

    public void mostrarMenuTurno() {
        System.out.println("\n1. Usar carta");
        System.out.println("2. Tomar carta");
        System.out.println("3. Pasar turno");
        System.out.println("4. Terminar partida");
    }
}
