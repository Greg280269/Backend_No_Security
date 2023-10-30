package pe.edu.upc.aaw.proyecto_awb.entities;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ComprobantePago")
public class ComprobantePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "monto",scale = 2)
    private double monto;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name ="metodo", length = 50, nullable = false )
    private String metodo;

    @Column(name ="RUC", length = 10, nullable = false )
    private String RUC;

    @ManyToOne
    @JoinColumn(name = "detalle_id")
    private Detalle detalle;

    @ManyToOne
    @JoinColumn(name = "Tipo_Comprobante_id")
    private TipoComprobante tipoComprobante;

    @Column(name = "IGV")
    private int IGV;



    public ComprobantePago() {
    }

    public ComprobantePago(int id, double monto, LocalDate fecha, String metodo, String RUC, Detalle detalle, TipoComprobante tipoComprobante, int IGV) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.metodo = metodo;
        this.RUC = RUC;
        this.detalle = detalle;
        this.tipoComprobante = tipoComprobante;
        this.IGV = IGV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public int getIGV() {
        return IGV;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setIGV(int IGV) {
        this.IGV = IGV;
    }
}
