package modelo;

public class CartaCatedratico extends Carta {

    private String departamento;
    private int llamadasAtencion;
    private int tiempoAtencion;

    public CartaCatedratico(int id, String nombre, int costoEnergia,
            String descripcion, String departamento,
            int llamadasAtencion, int tiempoAtencion) {

        super(id, nombre, costoEnergia, descripcion);
        this.departamento = departamento;
        this.llamadasAtencion = llamadasAtencion;
        this.tiempoAtencion = tiempoAtencion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getLlamadasAtencion() {
        return llamadasAtencion;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setLlamadasAtencion(int llamadasAtencion) {
        this.llamadasAtencion = llamadasAtencion;
    }

    public void setTiempoAtencion(int tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    @Override
    public String jugarCarta() {
        return getNombre() + " entra al tablero. "
                + "Genera " + llamadasAtencion
                + " llamadas de atencion y tiene "
                + tiempoAtencion + " puntos de tiempo de atencion.";
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Tipo: Catedratico"
                + " | Departamento: " + departamento
                + " | Llamadas de atencion: " + llamadasAtencion
                + " | Tiempo de atencion: " + tiempoAtencion;
    }
}
