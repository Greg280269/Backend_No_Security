package pe.edu.upc.aaw.proyecto_awb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.proyecto_awb.entities.Comentario;

import java.util.List;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario,Integer> {
    @Query(value = "Select count(id_comentario) from comentario where valoracion > 5",nativeQuery = true)
    public List<String[]>ComentarioMayor5();
}
