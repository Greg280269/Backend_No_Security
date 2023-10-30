package pe.edu.upc.aaw.proyecto_awb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.proyecto_awb.entities.TipoComprobante;

@Repository
public interface ITipoComprobanteRepository extends JpaRepository<TipoComprobante,Integer> {
}
