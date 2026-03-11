package com.list.biblioteca.service;

import com.list.biblioteca.dto.CarteiraRequest;
import com.list.biblioteca.dto.CarteiraResponse;
import com.list.biblioteca.entity.Carteira;
import com.list.biblioteca.entity.Usuario;
import com.list.biblioteca.repositories.CarteiraRepository;
import com.list.biblioteca.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService {

    private final CarteiraRepository  carteiraRepository;
    private final UsuarioRepository usuarioRepository;

    public CarteiraService(CarteiraRepository carteiraRepository, UsuarioRepository usuarioRepository) {
        this.carteiraRepository = carteiraRepository;
        this.usuarioRepository = usuarioRepository;
    }


    //Post

    public CarteiraResponse criarCarteria(Long id, CarteiraRequest carteirarequest){

        Carteira carteira = new Carteira();

        carteira.setDataEmissao(carteirarequest.getDataEmissao());
        carteira.setUsuario(carteira.getUsuario());
        carteiraRepository.save(carteira);

        CarteiraResponse carteiraResponse = new CarteiraResponse(
          carteira.getNCarteira(),
          carteira.getDataEmissao(),
          carteira.isValid(),
          carteira.getUsuario()


        );
        return carteiraResponse;

    }


    }

