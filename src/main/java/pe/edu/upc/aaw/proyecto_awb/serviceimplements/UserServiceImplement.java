package pe.edu.upc.aaw.proyecto_awb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.proyecto_awb.entities.Users;
import pe.edu.upc.aaw.proyecto_awb.repositories.IUserRepository;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public int insert(Users users) {
        int rpta = uR.buscarUsername(users.getUsername());
        if (rpta == 0) {
            uR.save(users);
        }
        return rpta;
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public Users listID(int id) {
        return uR.findById(id).orElse(new Users());
    }
}
