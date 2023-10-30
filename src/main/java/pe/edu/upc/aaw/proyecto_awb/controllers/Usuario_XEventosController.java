package pe.edu.upc.aaw.proyecto_awb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.proyecto_awb.dtos.Usuarios_XEventosDTO;
import pe.edu.upc.aaw.proyecto_awb.entities.Usuarios_XEventos;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IUsuarios_XEventos;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuariosEventos")
public class Usuario_XEventosController {
    @Autowired
    private IUsuarios_XEventos iueS;
    @PostMapping
    public void registrar(@RequestBody Usuarios_XEventosDTO dto){
        ModelMapper m= new ModelMapper();
        Usuarios_XEventos o = m.map(dto,Usuarios_XEventos.class);
        iueS.insertar(o);
    }

    @GetMapping
    public List<Usuarios_XEventosDTO> listar(){
        return iueS.list().stream().map(x->{
            ModelMapper M=new ModelMapper();
            return M.map(x,Usuarios_XEventosDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){iueS.delete(id);}

    @PutMapping
    public void modificar(@RequestBody Usuarios_XEventosDTO dto)
    {
        ModelMapper m= new ModelMapper();
        Usuarios_XEventos o = m.map(dto,Usuarios_XEventos.class);
        iueS.insertar(o);
    }

    @GetMapping("/{id}")
    public Usuarios_XEventosDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        Usuarios_XEventosDTO dto=m.map(iueS.listID(id),Usuarios_XEventosDTO.class);
        return dto;
    }

}
