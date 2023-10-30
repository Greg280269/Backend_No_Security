package pe.edu.upc.aaw.proyecto_awb.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(name = "DNI", length = 8, nullable = false)
    private long dni;
    @Column(length = 30, unique = true)
    private String username;
    @Column(name = "Apellido", length = 45, nullable = false)
    private String apellido;
    @Column(name = "Email", length = 50, nullable = false)
    private String email;
    @Column(name = "Telefono", length = 9, nullable = false)
    private long telefono;

    private Boolean enabled;


    @Column(length = 200)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private List<Roles> roles;

    public Users(int idUser, long dni, String username, String apellido, String email, long telefono, Boolean enabled, String password, List<Roles> roles) {
        this.idUser = idUser;
        this.dni = dni;
        this.username = username;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;
    }

    public Users() {
    }



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}