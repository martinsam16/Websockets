package com.martinsaman.websocketrest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "UBIGEO")
@Data
public class Ubigeo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 6)
    private String CODUBI;

    @Column(length = 13, nullable = false)
    private String DEPUBI;

    @Column(length = 25)
    private String PROVUBI;

    @Column(length = 36)
    private String DISTUBI;

}
