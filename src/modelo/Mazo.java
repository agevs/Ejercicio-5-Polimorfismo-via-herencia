package modelo;

import java.util.ArrayList;
import java.util.Comparator;

public class Mazo {

    private ArrayList<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    // Overloading: busca una carta por ID
    public Carta buscarCarta(int id) {
        for (Carta carta : cartas) {
            if (carta.getId() == id) {
                return carta;
            }
        }

        return null;
    }

    // Overloading: busca una carta por nombre
    public Carta buscarCarta(String nombre) {
        for (Carta carta : cartas) {
            if (carta.getNombre().equalsIgnoreCase(nombre)) {
                return carta;
            }
        }

        return null;
    }

    public void ordenarPorCostoEnergia() {
        cartas.sort(Comparator.comparingInt(Carta::getCostoEnergia));
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public int cantidadCartas() {
        return cartas.size();
    }
}