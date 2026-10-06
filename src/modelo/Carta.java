package modelo;

import java.util.Objects;

public abstract class Carta {

    private int id;
    private String nombre;
    private int costoEnergia;
    private String descripcion;

    public Carta(int id, String nombre, int costoEnergia, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCostoEnergia(int costoEnergia) {
        this.costoEnergia = costoEnergia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract String jugarCarta();

    @Override
    public String toString() {
        return "ID: " + id
                + " | Nombre: " + nombre
                + " | Costo de energia: " + costoEnergia
                + " | Descripcion: " + descripcion;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Carta)) {
            return false;
        }

        Carta otraCarta = (Carta) objeto;
        return id == otraCarta.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
