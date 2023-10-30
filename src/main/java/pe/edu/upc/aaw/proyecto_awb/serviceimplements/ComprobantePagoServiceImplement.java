package pe.edu.upc.aaw.proyecto_awb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.proyecto_awb.entities.ComprobantePago;
import pe.edu.upc.aaw.proyecto_awb.repositories.IComprobantePagoRepository;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IComprobantePagoService;

import java.util.List;

@Service
public class ComprobantePagoServiceImplement implements IComprobantePagoService {
    @Autowired
    private IComprobantePagoRepository dvR;

    @Override
    public void insertar(ComprobantePago s) {
        dvR.save(s);
    }
    @Override
    public List<ComprobantePago> list() {
        return dvR.findAll();
    }

    public void delete(int id) {
        dvR.deleteById(id);
    }

    @Override
    public ComprobantePago listID(int id) {
        return dvR.findById(id).orElse(new ComprobantePago());
    }


}
