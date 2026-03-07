package com.list.biblioteca.repositories;

import com.list.biblioteca.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    Long EmprestimoId(long emprestimoId);

}
