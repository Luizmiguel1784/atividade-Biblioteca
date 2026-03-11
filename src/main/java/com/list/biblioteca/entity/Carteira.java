package com.list.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long nCarteira;
    private Date dataEmissao;
    private boolean isValid ;
    @OneToOne
    @MapsId
    private Usuario usuario;
}