package modelo;

public class CartaEventoCampus extends Carta {

    private String efecto;
    private int energiaOtorgada;

    public CartaEventoCampus(int id, String nombre, int costoEnergia,
            String descripcion, String efecto, int energiaOtorgada) {

        super(id, nombre, costoEnergia, descripcion);
        this.efecto = efecto;
        this.energiaOtorgada = energiaOtorgada;
    }

    public String getEfecto() {
        return efecto;
    }

    public int getEnergiaOtorgada() {
        return energiaOtorgada;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public void setEnergiaOtorgada(int energiaOtorgada) {
        this.energiaOtorgada = energiaOtorgada;
    }

    @Override
    public String jugarCarta() {
        return "Ocurre el evento " + getNombre()
                + ". Efecto en el tablero: " + efecto
                + ". Energia obtenida: " + energiaOtorgada + ".";
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTipo: Evento Campus"
                + "\nEfecto: " + efecto
                + "\nEnergia otorgada: " + energiaOtorgada
                + "\n---";
    }
}