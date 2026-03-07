package com.list.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;
    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL)
    private CarteiraBiblioteca carteira;
}
