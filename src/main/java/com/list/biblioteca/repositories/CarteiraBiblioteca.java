package com.list.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraBiblioteca extends JpaRepository<CarteiraBiblioteca, Long> {
}
