package com.ciclo4.reto4.repositorio;


import com.ciclo4.reto4.interfaces.InterfaceUser;
import com.ciclo4.reto4.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositorio {

    @Autowired
    private InterfaceUser interfaceUser;

    public List<User> getAll() {
        return (List<User>) interfaceUser.findAll();
    }

    public Optional<User> getUser(int id) {
        return interfaceUser.findById(id);
    }

    public User create(User user) {
        return interfaceUser.save(user);
    }

    public void update(User user) {
        interfaceUser.save(user);
    }

    public void delete(User user) {
        interfaceUser.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = interfaceUser.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return interfaceUser.findByEmailAndPassword(email, password);
    }

    public Optional<User> lastUserId(){
        return interfaceUser.findTopByOrderByIdDesc();
    }
}
