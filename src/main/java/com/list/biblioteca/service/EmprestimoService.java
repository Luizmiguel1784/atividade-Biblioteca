package com.list.biblioteca.service;

import com.list.biblioteca.dto.EmprestimoRequest;
import com.list.biblioteca.dto.EmprestimoResponse;
import com.list.biblioteca.entity.Emprestimo;
import com.list.biblioteca.entity.Usuario;
import com.list.biblioteca.repositories.EmprestimoRepository;
import com.list.biblioteca.repositories.UsuarioRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {

        private final EmprestimoRepository emprestimoRepository;
        private final UsuarioRepository usuarioRepository;

        public EmprestimoService(EmprestimoRepository emprestimoRepository, UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
            this.usuarioRepository = usuarioRepository;
        }


    //Post
    public EmprestimoResponse criarEmprestimo(Long usuarioid, EmprestimoRequest request){

    Usuario usuario = usuarioRepository.findById(usuarioid).
            orElseThrow(()->new RuntimeException("Usuario não encontrado"));

        Emprestimo Emprestimo = new Emprestimo();


        Emprestimo.setDataEmprestimo(request.getDataEmprestimo());
        Emprestimo.setDataDevolucao(request.getDataDevolucao());
        Emprestimo.setUsuario(usuario);
        emprestimoRepository.save(Emprestimo);

        EmprestimoResponse EmprestimoResponse = new EmprestimoResponse(
                Emprestimo.getEmprestimoId(),
                Emprestimo.getDataEmprestimo(),
                Emprestimo.getDataDevolucao(),
                Emprestimo.getUsuario()
        );
        return EmprestimoResponse;
    }


    //Get
    public List<EmprestimoResponse> listarEmprestimos(Long usuarioid ){
            Usuario usuario = usuarioRepository.findById(usuarioid).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));

            List<Emprestimo> emprestimos = usuario.getEmprestimos();

            return emprestimos.stream().map(emprestimo -> new EmprestimoResponse(

                emprestimo.getEmprestimoId(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao(),
                emprestimo.getUsuario()
            )).toList();

    }


    //Delete
    public void deletarEmprestimo(Long emprestimoid){
            Emprestimo emprestimo = emprestimoRepository.findById(emprestimoid).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
            emprestimoRepository.delete(emprestimo);

    }


    //Put
    public EmprestimoResponse atualizarEmprestimo(Long emprestimoid, EmprestimoRequest request){

            Emprestimo emprestimo = emprestimoRepository.findById(emprestimoid).orElseThrow(()->new RuntimeException("Emprestimo não encontrado"));

            emprestimo.setDataEmprestimo(request.getDataEmprestimo());
            emprestimo.setDataDevolucao(request.getDataDevolucao());
            emprestimo.setUsuario(emprestimo.getUsuario());
            emprestimoRepository.save(emprestimo);

            return new EmprestimoResponse(
                    emprestimo.getEmprestimoId(),
                    emprestimo.getDataEmprestimo(),
                    emprestimo.getDataDevolucao(),
                    emprestimo.getUsuario()
            );

    }

}
