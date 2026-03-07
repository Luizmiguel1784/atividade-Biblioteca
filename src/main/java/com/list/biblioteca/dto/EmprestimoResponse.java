package com.list.biblioteca.dto;

import com.list.biblioteca.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoResponse {
    private long id;
    private Date dataEmprestimo;
    private Date dataDevoluao;
    private Usuario usuario;
}
