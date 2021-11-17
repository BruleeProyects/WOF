package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Servicios {

    private int id;
    private String[] servicios = {"Consulta Veterinaria", "Esterilización felina","Esterilización canina","Castración felina","Castración canina", "Toma de muestras", "Radiografía", "Ecografía", "Peluquería", "Desparasitación EX", "Desparasitación INT"};
    private int precios[] = {10000, 50000,50000,50000,50000,25000,30000,20000,15000,10000,7000};

    public Servicios()
    {
        int id = 01;
    }

    public Servicios(int id, String[] servicios, int[] precios)
    {
        this.id=id;
        this.servicios=servicios;
        this.precios=precios;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getServicios() {
        return servicios;
    }

    public void setServicios(String[] servicios) {
        this.servicios = servicios;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicios servicios1 = (Servicios) o;
        return id == servicios1.id && Arrays.equals(servicios, servicios1.servicios) && Arrays.equals(precios, servicios1.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(servicios);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    //Regla de negocios
    public int AnadirAdicional(int valor, int adicional)
    {
        return valor + adicional;
    }
}
