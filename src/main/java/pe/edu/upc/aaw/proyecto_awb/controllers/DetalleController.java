package pe.edu.upc.aaw.proyecto_awb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.proyecto_awb.dtos.DetalleDTO;
import pe.edu.upc.aaw.proyecto_awb.entities.Detalle;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IDetalleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalle")
public class DetalleController {
    @Autowired
    private IDetalleService ids;
    @PostMapping
    public void registrar(@RequestBody DetalleDTO dto){
        ModelMapper m= new ModelMapper();
        Detalle o = m.map(dto,Detalle.class);
        ids.insertar(o);
    }

    @GetMapping
    public List<DetalleDTO> listar(){
        return ids.list().stream().map(x->{
            ModelMapper M=new ModelMapper();
            return M.map(x,DetalleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){ids.delete(id);}

    @PutMapping
    public void modificar(@RequestBody DetalleDTO dto)
    {
        ModelMapper m= new ModelMapper();
        Detalle o = m.map(dto,Detalle.class);
        ids.insertar(o);
    }

    @GetMapping("/{id}")
    public DetalleDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        DetalleDTO dto=m.map(ids.listID(id),DetalleDTO.class);
        return dto;
    }
}
