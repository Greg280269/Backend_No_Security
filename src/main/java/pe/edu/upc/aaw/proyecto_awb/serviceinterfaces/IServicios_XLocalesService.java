package pe.edu.upc.aaw.proyecto_awb.serviceinterfaces;

import pe.edu.upc.aaw.proyecto_awb.entities.Servicios_XLocales;

import java.util.List;

public interface IServicios_XLocalesService {
    public void insertar(Servicios_XLocales s);
    List<Servicios_XLocales> list();

    public void delete(int id);
    public Servicios_XLocales listID(int id);
}
