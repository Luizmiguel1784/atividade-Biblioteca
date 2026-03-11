package com.list.biblioteca.dto;

import com.list.biblioteca.entity.Carteira;
import com.list.biblioteca.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CarteiraResponse {
    private long nCarteira;
    private Date dataEmissao;
    private boolean isValid;
    private Usuario usuario;
}
