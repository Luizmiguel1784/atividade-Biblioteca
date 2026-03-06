package com.list.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String email;

    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL)
    private CarteiraBiblioteca carteira;
}
