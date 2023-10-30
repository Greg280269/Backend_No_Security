package pe.edu.upc.aaw.proyecto_awb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.proyecto_awb.dtos.Servicios_XLocalesDTO;
import pe.edu.upc.aaw.proyecto_awb.entities.Servicios_XLocales;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IServicios_XLocalesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/serviciosLocales")
public class Servicios_XLocalesController {
    @Autowired
    private IServicios_XLocalesService islS;
    @PostMapping
    public void registrar(@RequestBody Servicios_XLocalesDTO dto){
        ModelMapper m= new ModelMapper();
        Servicios_XLocales o = m.map(dto,Servicios_XLocales.class);
        islS.insertar(o);
    }

    @GetMapping
    public List<Servicios_XLocalesDTO> listar(){
        return islS.list().stream().map(x->{
            ModelMapper M=new ModelMapper();
            return M.map(x,Servicios_XLocalesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){islS.delete(id);}

    @PutMapping
    public void modificar(@RequestBody Servicios_XLocalesDTO dto)
    {
        ModelMapper m= new ModelMapper();
        Servicios_XLocales o = m.map(dto,Servicios_XLocales.class);
        islS.insertar(o);
    }

    @GetMapping("/{id}")
    public Servicios_XLocalesDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        Servicios_XLocalesDTO dto=m.map(islS.listID(id),Servicios_XLocalesDTO.class);
        return dto;
    }
}
