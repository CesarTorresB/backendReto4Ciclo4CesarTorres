package com.ciclo4.reto4.controlador;

import com.ciclo4.reto4.modelo.Supplements;
import com.ciclo4.reto4.servicio.SupplementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/supplements")
@CrossOrigin("*")

public class SupplementsController {
    @Autowired
    private SupplementsService supplementsService;

    @GetMapping("/all")
    public List<Supplements> getAll() {
        return supplementsService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Supplements> getSupplements(@PathVariable("reference") String reference) {
        return supplementsService.getSupplements(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplements create(@RequestBody Supplements gadget) {
        return supplementsService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplements update(@RequestBody Supplements gadget) {
        return supplementsService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return supplementsService.delete(reference);
    }
}
