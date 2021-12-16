package com.ciclo4.reto4.controlador;

import com.ciclo4.reto4.modelo.User;
import com.ciclo4.reto4.servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author cesartbossa
 */
/*
*Anotacion springboot de controlador
 */
@RestController
/*
*Anotacion que se encarga de relacionar un metodo con una petición http 
 */
@RequestMapping("/api/user")
/*
*Anotacion springboot para evitar errores de cross origin
 */
@CrossOrigin("*")
/*
*Clase publica controlador de usuario
 */
public class UserController {

    /*
    *Anotacion que permite inyectar unas dependencias con otras dentro de Spring
     */
    @Autowired
    /*
    *Sercio de usuario
     */
    private UserService userService;

    /*
    *Anotacion que se encarga de relacionar un metodo GET de obetencion con una 
    *petición http "all"
     */
    @GetMapping("/all")
    /*
    *Clase publica de consulta de lista de usuario
     */
    public List<User> getAll() {
        return userService.getAll();
    }

    /*
    *Anotacion que se encarga de relacionar un metodo GET de obetencion con una 
    *petición http "/{id}"
     */
    @GetMapping("/{id}")
    /**
     *
     */
    public Optional<User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    /*
    *Anotacion que se encarga de relacionar un metodo POST de adicion con una 
    *petición http "new"
     */
    @PostMapping("/new")
    /*
    *Anotacion que se encarga de agregar atributos a los encabezados de respuesta 
    *para proporcionar mensajes de éxito o error
     */
    @ResponseStatus(HttpStatus.CREATED)
    /*
    *Clase publica para crear un usuario
     */
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    /*
    *Anotacion que se encarga de relacionar un metodo PUT de edicion con una 
    *petición http "update"
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    /*
    *Anotacion que se encarga de agregar atributos a los encabezados de respuesta 
    *para proporcionar mensajes de éxito o error
     */
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /*
    *Anotacion que se encarga de indicar que un parámetro del metodo debe estar 
    *vinculado al valor del cuerpo de la solicitud HTTP
     */
    @DeleteMapping("/{id}")
    /*
    *Anotacion que se encarga de indicar que un parámetro del metodo debe estar 
    *vinculado al valor del cuerpo de la solicitud HTTP
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /*
    *Clase publica para el borrado
     */
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    /*
    *Anotacion que se encarga de relacionar un metodo GET de obetencion con una 
    *petición http "email/password"
     */
    @GetMapping("/{email}/{password}")
    /*
    *Clase publica para autenticar el usuario
     */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    /*
    *Anotacion que se encarga de relacionar un metodo GET de obetencion con una 
    *petición http "emailexistente/email"
     */
    @GetMapping("/emailexist/{email}")
    /*
    *Clase publica para corroborar si existe el usuario por medio del email
     */
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
}
