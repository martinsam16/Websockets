package com.martinsaman.websocketrest.repo;

import java.util.List;

import com.martinsaman.websocketrest.model.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IPersona extends JpaRepository<Persona, Integer> {

    @Query("select p from Persona p where p.ESTPER = 'A'")
    List<Persona> listar();

    @Transactional
    @Modifying
    @Query("update Persona p set p.ESTPER = 'I' where p.IDPER = :IDPER")
    void eliminar(@Param("IDPER") int IDPER);
    
}