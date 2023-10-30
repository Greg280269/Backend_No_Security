package pe.edu.upc.aaw.proyecto_awb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.proyecto_awb.entities.Usuarios_XEventos;
import pe.edu.upc.aaw.proyecto_awb.repositories.IUsuarios_XEventoRepository;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IUsuarios_XEventos;


import java.util.List;

@Service
public class Usuarios_XEventosImplement implements IUsuarios_XEventos {

    @Autowired
    private IUsuarios_XEventoRepository ueR;


    @Override
    public void insertar(Usuarios_XEventos s) {
        ueR.save(s);
    }

    @Override
    public List<Usuarios_XEventos> list() {
        return ueR.findAll();
    }

    @Override
    public void delete(int id) {
        ueR.deleteById(id);
    }

    @Override
    public Usuarios_XEventos listID(int id) {
        return ueR.findById(id).orElse(new Usuarios_XEventos());
    }
}
