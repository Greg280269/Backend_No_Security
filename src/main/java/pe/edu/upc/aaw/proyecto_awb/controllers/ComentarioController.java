package pe.edu.upc.aaw.proyecto_awb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.proyecto_awb.dtos.ComentarioDTO;
import pe.edu.upc.aaw.proyecto_awb.entities.Comentario;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IComentarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private IComentarioService icS;

    @PostMapping
    public void registrar(@RequestBody ComentarioDTO dto){
        ModelMapper m= new ModelMapper();
        Comentario o = m.map(dto,Comentario.class);
        icS.insertar(o);
    }

    @GetMapping
    public List<ComentarioDTO> listar(){
        return icS.list().stream().map(x->{
            ModelMapper M=new ModelMapper();
            return M.map(x,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){icS.delete(id);}

    @PutMapping
    public void modificar(@RequestBody ComentarioDTO dto)
    {
        ModelMapper m= new ModelMapper();
        Comentario o = m.map(dto,Comentario.class);
        icS.insertar(o);
    }

    @GetMapping("/{id}")
    public ComentarioDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ComentarioDTO dto=m.map(icS.listID(id),ComentarioDTO.class);
        return dto;
    }
}
