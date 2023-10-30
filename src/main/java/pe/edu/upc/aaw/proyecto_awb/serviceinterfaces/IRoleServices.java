package pe.edu.upc.aaw.proyecto_awb.serviceinterfaces;

import pe.edu.upc.aaw.proyecto_awb.entities.Roles;

import java.util.List;

public interface IRoleServices {
    public void insertar(Roles r);
    public void delete(Long idRole);
    List<Roles> list();
    public Roles listId(Long id);
}
