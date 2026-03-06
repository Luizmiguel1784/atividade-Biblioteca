package com.list.biblioteca.entitie;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.Date;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private Date dataEmprestimo;
    private Date dataDevoluçao;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
