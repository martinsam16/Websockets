package com.martinsaman.websocketrest.rest;

import java.util.List;

import com.martinsaman.websocketrest.model.Persona;
import com.martinsaman.websocketrest.repo.IPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({ "*" })
@RestController
@RequestMapping("/api/v1/persona")
public class PersonaRest {

    @Autowired
    private IPersona repo;

    @GetMapping
    public List<Persona> listar() {
        return repo.findAll();
    }

    @PostMapping
    public void registrar(@RequestBody Persona persona) {
        try {
            repo.save(persona);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping
    public void actualizar(@RequestBody Persona persona) {
        try {
            repo.save(persona);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") int id) {
        try {
            repo.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}