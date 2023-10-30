package pe.edu.upc.aaw.proyecto_awb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.proyecto_awb.entities.Comentario;
import pe.edu.upc.aaw.proyecto_awb.repositories.IComentarioRepository;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IComentarioService;

import java.util.List;

@Service
public class ComentarioServiceImplement implements IComentarioService {
    @Autowired
    private IComentarioRepository cR;

    @Override
    public void insertar(Comentario s) {
        cR.save(s);
    }

    @Override
    public List<Comentario> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public Comentario listID(int id) {
        return cR.findById(id).orElse(new Comentario());
    }

    @Override
    public List<String[]> ComentarioMayor5() {
        return cR.ComentarioMayor5();
    }
}
