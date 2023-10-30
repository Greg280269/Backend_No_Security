package pe.edu.upc.aaw.proyecto_awb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.proyecto_awb.dtos.LocalesDTO;
import pe.edu.upc.aaw.proyecto_awb.entities.Locales;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.ILocalesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locales")
public class LocalesController {
    @Autowired
    private ILocalesService ilS;
    @PostMapping
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public void registrar(@RequestBody LocalesDTO dto){
        ModelMapper m= new ModelMapper();
        Locales o = m.map(dto,Locales.class);
        ilS.insertar(o);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public List<LocalesDTO> listar(){
        return ilS.list().stream().map(x->{
            ModelMapper M=new ModelMapper();
            return M.map(x,LocalesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public void eliminar(@PathVariable("id")Integer id){ilS.delete(id);}

    @PutMapping
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public void modificar(@RequestBody LocalesDTO dto)
    {
        ModelMapper m= new ModelMapper();
        Locales o = m.map(dto,Locales.class);
        ilS.insertar(o);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PROPIETARIO') or hasAuthority('ASISTENTE') or hasAuthority('ORGANIZADOR')")
    public LocalesDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        LocalesDTO dto=m.map(ilS.listID(id),LocalesDTO.class);
        return dto;
    }
}
