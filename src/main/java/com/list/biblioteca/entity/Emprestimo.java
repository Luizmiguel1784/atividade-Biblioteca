package com.list.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emprestimoId;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
