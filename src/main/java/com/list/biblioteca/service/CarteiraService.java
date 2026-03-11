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
    public Carteira criarCarteira(Long id, CarteiraRequest carteira){

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario não encontrado"));

        Carteira Carteira = new Carteira();

        Carteira.setUsuario(usuario);
        Carteira.setDataEmissao(Carteira.getDataEmissao());
        carteiraRepository.save(Carteira);

        CarteiraResponse carteiraResponse = new CarteiraResponse(
                Carteira.getNCarteira(),
                Carteira.getDataEmissao(),
                Carteira.isValid(),
                Carteira.getUsuario()

        );
                return carteiraResponse;

    }
}
