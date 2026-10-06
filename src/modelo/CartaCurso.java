package modelo;

public class CartaCurso extends Carta {

    private int creditos;
    private int nivelDificultad;

    public CartaCurso(int id, String nombre, int costoEnergia,
            String descripcion, int creditos, int nivelDificultad) {

        super(id, nombre, costoEnergia, descripcion);
        this.creditos = creditos;
        this.nivelDificultad = nivelDificultad;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setNivelDificultad(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    @Override
    public String jugarCarta() {
        return "Se juega el curso " + getNombre()
                + ". Aporta " + creditos
                + " creditos y tiene dificultad "
                + nivelDificultad + ".";
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTipo: Curso"
                + "\nCreditos: " + creditos
                + "\nNivel de dificultad: " + nivelDificultad
                + "\n--";
    }
}