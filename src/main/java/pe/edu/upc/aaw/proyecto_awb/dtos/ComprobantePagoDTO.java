package pe.edu.upc.aaw.proyecto_awb.dtos;

import pe.edu.upc.aaw.proyecto_awb.entities.Detalle;
import pe.edu.upc.aaw.proyecto_awb.entities.TipoComprobante;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ComprobantePagoDTO {

    private int id;

    private double monto;

    private LocalDate fecha;

    private String metodo;

    private String RUC;

    private Detalle detalle;

    private TipoComprobante tipoComprobante;

    private int IGV;

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

    public void setIGV(int IGV) {
        this.IGV = IGV;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
