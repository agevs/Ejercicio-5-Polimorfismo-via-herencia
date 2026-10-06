package modelo;

public class CartaEventoCampus extends Carta {

    private String efecto;

    public CartaEventoCampus(int id, String nombre, int costoEnergia,
            String descripcion, String efecto) {

        super(id, nombre, costoEnergia, descripcion);
        this.efecto = efecto;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    @Override
    public String jugarCarta() {
        return "Ocurre el evento " + getNombre()
                + ". Efecto en el tablero: " + efecto;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Tipo: Evento Campus"
                + " | Efecto: " + efecto;
    }
}
