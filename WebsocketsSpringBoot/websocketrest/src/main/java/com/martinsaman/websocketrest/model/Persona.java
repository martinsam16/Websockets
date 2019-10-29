package com.martinsaman.websocketrest.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PERSONA")
@Data
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PERSONA_GEN", sequenceName = "PERSONA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_GEN")
    private int IDPER;

    @Column(length = 50, nullable = false)
    private String APEPATPER;

    @Column(length = 50, nullable = false)
    private String APEMATPER;

    @Column(length = 50, nullable = false)
    private String NOMPER;

    @Column(length = 8, unique = true)
    private String DNIPER;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CODUBI", referencedColumnName = "CODUBI")
    private Ubigeo ubigeo;

    @Column(length = 100)
    private String DIRPER;

    @Column(columnDefinition = "char(1) default 'M'", nullable = false)
    private char GENPER;

    @Column(columnDefinition = "char(1) default 'A'", nullable = false)
    private char ESTPER;

}