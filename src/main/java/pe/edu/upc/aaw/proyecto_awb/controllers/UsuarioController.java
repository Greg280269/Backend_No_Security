package pe.edu.upc.aaw.proyecto_awb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder bcrypt;
    @Autowired
    private IUserService uS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody UsuarioDTO dto){
        ModelMapper m= new ModelMapper();
        String bcryptPassword = bcrypt.encode(dto.getPassword());
        dto.setPassword(bcryptPassword);
        Users u = m.map(dto,Users.class);
        uS.insert(u);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('ADMIN')")
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

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveUser(@Valid Users user, BindingResult result, Model model, SessionStatus status)
            throws Exception {
        if (result.hasErrors()) {
            return "usersecurity/user";
        } else {
            String bcryptPassword = bcrypt.encode(user.getPassword());
            user.setPassword(bcryptPassword);
            int rpta = uS.insert(user);
            if (rpta > 0) {
                model.addAttribute("mensaje", "Ya existe");
                return "usersecurity/user";
            } else {
                model.addAttribute("mensaje", "Se guardó correctamente");
                status.setComplete();
            }
        }
        model.addAttribute("listaUsuarios", uS.list());

        return "usersecurity/listUser";
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
