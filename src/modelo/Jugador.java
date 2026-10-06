package modelo;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int energia;
    private ArrayList<Carta> mano;

    public Jugador(String nombre, int energiaInicial) {
        this.nombre = nombre;
        this.energia = energiaInicial;
        this.mano = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEnergia(int cantidad) {
        energia += cantidad;
    }

    public void tomarCarta(Carta carta) {
        if (carta != null) {
            mano.add(carta);
        }
    }

    public String usarCarta(int indice) {

        if (indice < 0 || indice >= mano.size()) {
            return "La carta seleccionada no existe.";
        }

        Carta carta = mano.get(indice);

        if (energia < carta.getCostoEnergia()) {
            return "No tienes suficiente energia para jugar esta carta.";
        }

        energia -= carta.getCostoEnergia();
        mano.remove(indice);

        return carta.jugarCarta();
    }

    public String pasarTurno() {
        return nombre + " ha pasado su turno.";
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre
                + " | Energia: " + energia
                + " | Cartas en mano: " + mano.size();
    }
}