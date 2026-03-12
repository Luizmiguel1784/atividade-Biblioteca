package com.list.biblioteca.controller;

import com.list.biblioteca.dto.EmprestimoRequest;
import com.list.biblioteca.dto.EmprestimoResponse;
import com.list.biblioteca.entity.Emprestimo;
import com.list.biblioteca.service.EmprestimoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller("tarefa")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/usuario/emprestimo/{id}")
    public EmprestimoResponse criarEmprestimo(@PathVariable Long usuarioid ,@RequestBody EmprestimoRequest request){

        return emprestimoService.criarEmprestimo(usuarioid, request);
    }

    @GetMapping("/usuario/emprestimo/{id}")
    public List<EmprestimoResponse> listaremprestimo(Long  usuarioid){

        return emprestimoService.listarEmprestimos(usuarioid);
    }
}
