package pe.edu.upc.aaw.proyecto_awb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.proyecto_awb.entities.Roles;
import pe.edu.upc.aaw.proyecto_awb.repositories.IRolesRepository;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IRoleServices;

import javax.management.relation.Role;
import java.util.List;

@Service
public class RoleServiceImplements implements IRoleServices {
    @Autowired
    IRolesRepository rR;


    @Override
    public void insertar(Roles r) {
        rR.save(r);
    }

    @Override
    public void delete(Long idRole) {
        rR.deleteById(idRole);
    }

    @Override
    public List<Roles> list() {
        return rR.findAll();
    }

    @Override
    public Roles listId(Long id) {
        return rR.findById(id).orElse(new Roles());
    }
}
