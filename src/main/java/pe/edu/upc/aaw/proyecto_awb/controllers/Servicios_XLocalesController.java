package pe.edu.upc.aaw.proyecto_awb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public void registrar(@RequestBody Servicios_XLocalesDTO dto){
        ModelMapper m= new ModelMapper();
        Servicios_XLocales o = m.map(dto,Servicios_XLocales.class);
        islS.insertar(o);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public List<Servicios_XLocalesDTO> listar(){
        return islS.list().stream().map(x->{
            ModelMapper M=new ModelMapper();
            return M.map(x,Servicios_XLocalesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public void eliminar(@PathVariable("id")Integer id){islS.delete(id);}

    @PutMapping
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public void modificar(@RequestBody Servicios_XLocalesDTO dto)
    {
        ModelMapper m= new ModelMapper();
        Servicios_XLocales o = m.map(dto,Servicios_XLocales.class);
        islS.insertar(o);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public Servicios_XLocalesDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        Servicios_XLocalesDTO dto=m.map(islS.listID(id),Servicios_XLocalesDTO.class);
        return dto;
    }
}
