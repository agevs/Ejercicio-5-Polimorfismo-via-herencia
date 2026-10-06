package controlador;

import java.util.ArrayList;
import java.util.Collections;

import modelo.Carta;
import modelo.CartaCatedratico;
import modelo.CartaCurso;
import modelo.CartaEventoCampus;
import modelo.Jugador;
import modelo.Mazo;
import vista.JuegoVista;

public class JuegoControlador {

    private Mazo mazo;
    private JuegoVista vista;

    public JuegoControlador(Mazo mazo, JuegoVista vista) {
        this.mazo = mazo;
        this.vista = vista;
        cargarCartasIniciales();
    }

    private void cargarCartasIniciales() {

        mazo.agregarCarta(new CartaCatedratico(
                1, "Profe de POO", 3,
                "Especialista en programacion orientada a objetos.",
                "Ciencias de la Computacion", 4, 3));

        mazo.agregarCarta(new CartaCatedratico(
                2, "Profe de Calculo", 4,
                "Domina derivadas e integrales.",
                "Matematica", 5, 2));

        mazo.agregarCarta(new CartaCatedratico(
                3, "Profe de Fisica", 3,
                "Experto en las leyes del universo.",
                "Fisica", 3, 4));

        mazo.agregarCarta(new CartaCurso(
                4, "Programacion Orientada a Objetos", 4,
                "Curso de programacion utilizando objetos.",
                4, 5));

        mazo.agregarCarta(new CartaCurso(
                5, "Calculo", 3,
                "Curso de fundamentos matematicos.",
                4, 4));

        mazo.agregarCarta(new CartaCurso(
                6, "Fisica", 3,
                "Curso sobre fenomenos fisicos.",
                4, 4));

        mazo.agregarCarta(new CartaCurso(
                7, "Algoritmos y Estructuras de Datos", 5,
                "Curso para desarrollar soluciones eficientes.",
                4, 5));

        mazo.agregarCarta(new CartaEventoCampus(
                8, "Semana de Parciales", 2,
                "Una semana llena de evaluaciones.",
                "Todos los estudiantes sienten la presion de los parciales."));

        mazo.agregarCarta(new CartaEventoCampus(
                9, "Feria de Clubes", 1,
                "Los clubes presentan sus actividades.",
                "El ambiente universitario aumenta la motivacion."));

        mazo.agregarCarta(new CartaEventoCampus(
                10, "Semana de Proyectos", 4,
                "Todos intentan terminar sus proyectos.",
                "Aumenta la carga academica en el campus."));

        Collections.shuffle(mazo.getCartas());
    }

    public void iniciar() {

        boolean continuar = true;

        while (continuar) {

            vista.mostrarMenuPrincipal();
            int opcion = vista.leerOpcion();

            switch (opcion) {

                case 1:
                    vista.mostrarCartas(mazo.getCartas());
                    break;

                case 2:
                    buscarPorId();
                    break;

                case 3:
                    buscarPorNombre();
                    break;

                case 4:
                    mazo.ordenarPorCostoEnergia();
                    vista.mostrarMensaje(
                            "Mazo ordenado por costo de energia.");
                    vista.mostrarCartas(mazo.getCartas());
                    break;

                case 5:
                    iniciarPartida();
                    break;

                case 6:
                    continuar = false;
                    vista.mostrarMensaje("Gracias por jugar UVG Card Battle.");
                    break;

                default:
                    vista.mostrarMensaje("Opcion no valida.");
                    break;
            }
        }
    }

    private void buscarPorId() {

        int id = vista.leerEntero("Ingrese el ID de la carta: ");

        Carta carta = mazo.buscarCarta(id);

        vista.mostrarCarta(carta);
    }

    private void buscarPorNombre() {

        String nombre = vista.leerTexto(
                "Ingrese el nombre de la carta: ");

        Carta carta = mazo.buscarCarta(nombre);

        vista.mostrarCarta(carta);
    }

    private void iniciarPartida() {

        if (mazo.cantidadCartas() == 0) {
            vista.mostrarMensaje("No hay cartas disponibles.");
            return;
        }

        String nombre = vista.leerTexto(
                "Ingrese el nombre del jugador: ");

        Jugador jugador = new Jugador(nombre, 10);

        ArrayList<Carta> cartasDisponibles
                = new ArrayList<>(mazo.getCartas());

        Collections.shuffle(cartasDisponibles);

        for (int i = 0; i < 3 && !cartasDisponibles.isEmpty(); i++) {
            jugador.tomarCarta(cartasDisponibles.remove(0));
        }

        boolean partidaActiva = true;

        while (partidaActiva) {

            vista.mostrarEstadoJugador(jugador);
            vista.mostrarMano(jugador);
            vista.mostrarMenuTurno();

            int opcion = vista.leerOpcion();

            switch (opcion) {

                case 1:
                    usarCarta(jugador);
                    break;

                case 2:
                    tomarCarta(jugador, cartasDisponibles);
                    break;

                case 3:
                    vista.mostrarMensaje(jugador.pasarTurno());
                    jugador.agregarEnergia(1);
                    break;

                case 4:
                    partidaActiva = false;
                    vista.mostrarMensaje("Partida terminada.");
                    break;

                default:
                    vista.mostrarMensaje("Opcion no valida.");
                    break;
            }
        }
    }

    private void usarCarta(Jugador jugador) {

        if (jugador.getMano().isEmpty()) {
            vista.mostrarMensaje(
                    "No tienes cartas disponibles para jugar.");
            return;
        }

        int numeroCarta = vista.leerEntero(
                "Seleccione el numero de la carta: ");

        String resultado = jugador.usarCarta(numeroCarta - 1);

        vista.mostrarMensaje(resultado);
    }

    private void tomarCarta(
            Jugador jugador, ArrayList<Carta> cartasDisponibles) {

        if (cartasDisponibles.isEmpty()) {
            vista.mostrarMensaje(
                    "No quedan cartas disponibles para tomar.");
            return;
        }

        Carta carta = cartasDisponibles.remove(0);

        jugador.tomarCarta(carta);

        vista.mostrarMensaje(
                "Tomaste la carta: " + carta.getNombre());
    }
}
