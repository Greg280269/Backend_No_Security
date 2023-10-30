package pe.edu.upc.aaw.proyecto_awb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.proyecto_awb.dtos.EventosDTO;
import pe.edu.upc.aaw.proyecto_awb.entities.Eventos;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IEventosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventos")
public class EventosController {
    @Autowired
    private IEventosService ieS;
    @PostMapping
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public void registrar(@RequestBody EventosDTO dto){
        ModelMapper m= new ModelMapper();
        Eventos o = m.map(dto,Eventos.class);
        ieS.insertar(o);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public List<EventosDTO> listar(){
        return ieS.list().stream().map(x->{
            ModelMapper M=new ModelMapper();
            return M.map(x,EventosDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public void eliminar(@PathVariable("id")Integer id){ieS.delete(id);}

    @PutMapping
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public void modificar(@RequestBody EventosDTO dto)
    {
        ModelMapper m= new ModelMapper();
        Eventos o = m.map(dto,Eventos.class);
        ieS.insertar(o);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public EventosDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        EventosDTO dto=m.map(ieS.listID(id),EventosDTO.class);
        return dto;
    }
}
