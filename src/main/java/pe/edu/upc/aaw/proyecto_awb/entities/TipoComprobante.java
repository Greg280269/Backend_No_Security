package pe.edu.upc.aaw.proyecto_awb.entities;

import javax.persistence.*;

@Entity
@Table(name = "TipoComprobante")
public class TipoComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nombre", length = 250, nullable = false)
    private String Nombre;

    @Column(name = "Descripcion", length = 250, nullable = false)
    private String Descripcion;

    public TipoComprobante() {
    }

    public TipoComprobante(int id, String nombre, String descripcion) {
        this.id = id;
        Nombre = nombre;
        Descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
