package pe.edu.upc.aaw.proyecto_awb.dtos;

import pe.edu.upc.aaw.proyecto_awb.entities.Locales;
import pe.edu.upc.aaw.proyecto_awb.entities.Servicios;

public class Servicios_XLocalesDTO {
    private int idSErxL;
    private Locales locales;
    private Servicios servicios;
    private String Descripcion;

    public int getIdSErxL() {
        return idSErxL;
    }

    public void setIdSErxL(int idSErxL) {
        this.idSErxL = idSErxL;
    }

    public Locales getLocales() {
        return locales;
    }

    public void setLocales(Locales locales) {
        this.locales = locales;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
