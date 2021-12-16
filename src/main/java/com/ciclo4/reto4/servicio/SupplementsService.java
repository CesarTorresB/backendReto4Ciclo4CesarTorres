package com.ciclo4.reto4.servicio;

import com.ciclo4.reto4.modelo.Supplements;
import com.ciclo4.reto4.repositorio.SupplementsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplementsService {
    @Autowired
    private SupplementsRepositorio supplementsRepository;

    public List<Supplements> getAll() {
        return supplementsRepository.getAll();
    }

    public Optional<Supplements> getSupplements(String reference) {
        return supplementsRepository.getSupplements(reference);
    }

    public Supplements create(Supplements supplements) {
        if (supplements.getReference() == null) {
            return supplements;
        } else {
            return supplementsRepository.create(supplements);
        }
    }

    public Supplements update(Supplements supplements) {

        if (supplements.getReference() != null) {
            Optional<Supplements> supplementsDb = supplementsRepository.getSupplements(supplements.getReference());
            if (!supplementsDb.isEmpty()) {

                if (supplements.getBrand()!= null) {
                    supplementsDb.get().setBrand(supplements.getBrand());
                }

                if (supplements.getCategory() != null) {
                    supplementsDb.get().setCategory(supplements.getCategory());
                }

                if (supplements.getDescription() != null) {
                    supplementsDb.get().setDescription(supplements.getDescription());
                }
                if (supplements.getPrice() != 0.0) {
                    supplementsDb.get().setPrice(supplements.getPrice());
                }
                if (supplements.getQuantity() != 0) {
                    supplementsDb.get().setQuantity(supplements.getQuantity());
                }
                if (supplements.getPhotography() != null) {
                    supplementsDb.get().setPhotography(supplements.getPhotography());
                }
                supplementsDb.get().setAvailability(supplements.isAvailability());
                supplementsRepository.update(supplementsDb.get());
                return supplementsDb.get();
            } else {
                return supplements;
            }
        } else {
            return supplements;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getSupplements(reference).map(supplements -> {
            supplementsRepository.delete(supplements);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
