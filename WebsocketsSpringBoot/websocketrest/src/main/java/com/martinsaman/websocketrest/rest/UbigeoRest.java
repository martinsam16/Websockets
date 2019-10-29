package com.martinsaman.websocketrest.rest;

import java.util.List;

import com.martinsaman.websocketrest.model.Ubigeo;
import com.martinsaman.websocketrest.repo.IUbigeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({ "*" })
@RestController
@RequestMapping("/api/v1/ubigeo")
public class UbigeoRest {

    @Autowired
    private IUbigeo repo;

    @GetMapping
    public List<Ubigeo> listar() {
        return repo.findAll();
    }
}