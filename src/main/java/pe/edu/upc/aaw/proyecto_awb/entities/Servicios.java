package pe.edu.upc.aaw.proyecto_awb.entities;

import javax.persistence.*;

@Entity
@Table(name = "Servicios")
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSerDisp;

    @Column(name ="Nombre", length = 250, nullable = false )
    private String nombre;

    @Column(name ="Descripcion", length = 250, nullable = false )
    private String descripcion;

    @Column(name = "costo",nullable = false,scale = 2)
    private double costo;

    @Column(name ="estado", length = 50, nullable = false )
    private boolean estado;

    public Servicios() {
    }

    public Servicios(int idSerDisp, String nombre, String descripcion, double costo, boolean estado) {
        this.idSerDisp = idSerDisp;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.estado = estado;

    }

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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
