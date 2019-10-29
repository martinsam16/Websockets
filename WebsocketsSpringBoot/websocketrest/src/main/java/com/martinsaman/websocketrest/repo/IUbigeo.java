package com.martinsaman.websocketrest.repo;

import com.martinsaman.websocketrest.model.Ubigeo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUbigeo extends JpaRepository<Ubigeo, Integer>{
    
}