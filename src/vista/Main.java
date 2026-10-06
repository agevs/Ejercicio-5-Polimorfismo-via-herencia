package vista;

import controlador.JuegoControlador;
import modelo.Mazo;

public class Main {

    public static void main(String[] args) {

        Mazo mazo = new Mazo();
        JuegoVista vista = new JuegoVista();

        JuegoControlador controlador
                = new JuegoControlador(mazo, vista);

        controlador.iniciar();
    }
}