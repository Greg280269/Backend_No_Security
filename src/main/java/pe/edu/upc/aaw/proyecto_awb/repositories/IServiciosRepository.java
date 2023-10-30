package pe.edu.upc.aaw.proyecto_awb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.proyecto_awb.entities.Servicios;

import java.util.List;

@Repository
public interface IServiciosRepository extends JpaRepository<Servicios,Integer> {
    @Query(value = "select count(id_ser_disp) from servicios where id_ser_disp = '1'",nativeQuery = true)
    public List<String[]> cantidadDeServicio();
}
