package pe.edu.upc.aaw.proyecto_awb.serviceinterfaces;

import pe.edu.upc.aaw.proyecto_awb.entities.Users;


import java.util.List;

public interface IUserService {
    public void insert(Users usuario);
    public List<Users> list();
    public void delete (int id);
    public Users listID(int id);
}
