package pe.edu.upc.aaw.proyecto_awb.serviceinterfaces;

import pe.edu.upc.aaw.proyecto_awb.entities.Detalle;

import java.util.List;

public interface IDetalleService {
    public void insertar(Detalle s);
    List<Detalle> list();

    public void delete(int id);
    public Detalle listID(int id);
}
