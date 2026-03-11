package com.list.biblioteca.controller;

import com.list.biblioteca.dto.UsuarioRequest;
import com.list.biblioteca.dto.UsuarioResponse;
import com.list.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuarios")
    public UsuarioResponse criarUsuario(@RequestBody UsuarioRequest request){

        return usuarioService.criarUsuario(request);
    }

    @GetMapping("/usuarios")
    public List<UsuarioResponse>listarUsuario()
    {

        return usuarioService.listarUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public UsuarioResponse buscarPorId(@PathVariable Long id)
    {
    return usuarioService.buscarPorId(id);}

    @DeleteMapping("usuarios/{id}")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }
    @PutMapping("usuarios/{id}")
    public UsuarioResponse atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequest request)
    {
        return usuarioService.atualizarUsuario(id,request);


    }



}
