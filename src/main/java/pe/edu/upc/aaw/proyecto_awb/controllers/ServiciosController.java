package pe.edu.upc.aaw.proyecto_awb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.proyecto_awb.dtos.QuantityByServiceDTO;
import pe.edu.upc.aaw.proyecto_awb.dtos.ServiciosDTO;
import pe.edu.upc.aaw.proyecto_awb.entities.Servicios;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IServiciosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Servicios Disponibles")
public class ServiciosController {
    @Autowired
    private IServiciosService sdS;

    @PostMapping
    public void registrar (@RequestBody ServiciosDTO dto){
        ModelMapper m = new ModelMapper();
        Servicios n = m.map(dto,Servicios.class);
        sdS.insert(n);
    }

    @GetMapping
    public List<ServiciosDTO> listar(){
        return sdS.list().stream().map((x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ServiciosDTO.class);
        })).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        sdS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody ServiciosDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Servicios n = m.map(dto,Servicios.class);
        sdS.insert(n);
    }

    @GetMapping("/{id}")
    public ServiciosDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ServiciosDTO dto=m.map(sdS.listID(id),ServiciosDTO.class);
        return dto;
    }
    @GetMapping("/cantidadServicios")
    public List<QuantityByServiceDTO> CantidadDeServicio(){
        List<String[]> pslista= sdS.cantidadDeServicio();
        List<QuantityByServiceDTO>psListDTO = new ArrayList<>();
        for (String[] data: pslista){
            QuantityByServiceDTO psdto= new QuantityByServiceDTO();
            psdto.setQuanttiyByService(Integer.parseInt(data[0]));
            psListDTO.add(psdto);
        }
        return psListDTO;
    }
}
