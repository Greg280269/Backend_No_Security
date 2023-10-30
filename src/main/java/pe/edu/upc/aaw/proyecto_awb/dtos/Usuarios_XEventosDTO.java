package pe.edu.upc.aaw.proyecto_awb.dtos;

import pe.edu.upc.aaw.proyecto_awb.entities.Eventos;
import pe.edu.upc.aaw.proyecto_awb.entities.Users;

public class Usuarios_XEventosDTO {
    private int idUsuXEve;
    private Eventos eventos;
    private Users users;
    private String descripcion;

    public int getIdUsuXEve() {
        return idUsuXEve;
    }

    public void setIdUsuXEve(int idUsuXEve) {
        this.idUsuXEve = idUsuXEve;
    }

    public Eventos getEventos() {
        return eventos;
    }

    public void setEventos(Eventos eventos) {
        this.eventos = eventos;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
