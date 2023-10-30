package pe.edu.upc.aaw.proyecto_awb.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Detalle")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "eventos_id")
    private Eventos eventos;

    @Column(name = "subTotal",scale = 2)
    private double subTotal;

    public Detalle() {
    }

    public Detalle(int id, Eventos eventos, double subTotal) {
        this.id = id;
        this.eventos = eventos;
        this.subTotal = subTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Eventos getEventos() {
        return eventos;
    }

    public void setEventos(Eventos eventos) {
        this.eventos = eventos;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
