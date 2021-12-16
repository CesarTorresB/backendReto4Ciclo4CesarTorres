package com.ciclo4.reto4.interfaces;

import com.ciclo4.reto4.modelo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InterfaceUser extends MongoRepository <User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    Optional<User> findTopByOrderByIdDesc();

}
