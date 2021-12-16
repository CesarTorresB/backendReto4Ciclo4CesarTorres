package com.ciclo4.reto4.interfaces;

import com.ciclo4.reto4.modelo.Supplements;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceSupplements extends MongoRepository <Supplements, String>{
}
