package pe.edu.upc.aaw.proyecto_awb.serviceinterfaces;

import pe.edu.upc.aaw.proyecto_awb.entities.ComprobantePago;

import java.util.List;

public interface IComprobantePagoService {
    public void insertar(ComprobantePago s);
    List<ComprobantePago> list();
    public void delete(int id);

    public ComprobantePago listID(int id);
}
