package com.list.biblioteca.dto;

import com.list.biblioteca.entity.Carteira;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private String nome;
    private String email;
    private long id;
    private Carteira carteira;


}
