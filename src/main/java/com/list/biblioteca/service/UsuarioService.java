package com.list.biblioteca.service;

import com.list.biblioteca.dto.UsuarioRequest;
import com.list.biblioteca.dto.UsuarioResponse;
import com.list.biblioteca.entity.Usuario;
import com.list.biblioteca.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;}


    //Post
    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuarioRequest.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("email ja registrado");
        }
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setNome(usuarioRequest.getNome());
        usuarioRepository.save(usuario);
        //Get
        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getId(),
                usuario.getCarteira()
                );
        return usuarioResponse;
    }


    //Get All
    public List<UsuarioResponse>listarUsuarios(){

        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream().map(
                usuario -> new UsuarioResponse(
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getId(),
                        usuario.getCarteira()
                )).toList();

    }


    
    public UsuarioResponse buscarPorId(Long id) {

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encotrado"));
        return new UsuarioResponse(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getId(),
                usuario.getCarteira());
    }


    //delete
    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
        usuarioRepository.delete(usuario);
    }


    //Put
    public UsuarioResponse atualizarUsuario(Long id, UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));

        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuarioRepository.save(usuario);
        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getId(),
                usuario.getCarteira()
        );
        return usuarioResponse;

    }


}
