package pe.edu.upc.aaw.proyecto_awb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.upc.aaw.proyecto_awb.dtos.UsuarioDTO;
import pe.edu.upc.aaw.proyecto_awb.entities.Users;
import pe.edu.upc.aaw.proyecto_awb.serviceinterfaces.IUserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUserService uS;

    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto){
        ModelMapper m= new ModelMapper();
        Users u = m.map(dto,Users.class);
        uS.insert(u);
    }

    @GetMapping
    public List<UsuarioDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m =  new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id)
    {
        uS.delete(id);
    }


    @GetMapping("/{id}")
    public UsuarioDTO listarID(@PathVariable ("id") Integer id)
    {
        ModelMapper m= new ModelMapper();
        UsuarioDTO dto = m.map(uS.listID(id),UsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void Modificar (@RequestBody UsuarioDTO dto){
        ModelMapper m= new ModelMapper();
        Users u = m.map(dto,Users.class);
        uS.insert(u);
    }



    @GetMapping("/list")
    public String listUser(Model model) {
        try {
            model.addAttribute("user", new Users());
            model.addAttribute("listaUsuarios", uS.list());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "usersecurity/listUser";
    }
}
