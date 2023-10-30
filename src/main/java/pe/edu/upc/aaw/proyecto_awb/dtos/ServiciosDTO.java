package pe.edu.upc.aaw.proyecto_awb.dtos;

public class ServiciosDTO {
    private int idSerDisp;
    private String nombre;
    private String descripcion;
    private double costo;
    private String Estado;

    public int getIdSerDisp() {
        return idSerDisp;
    }

    public void setIdSerDisp(int idSerDisp) {
        this.idSerDisp = idSerDisp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
