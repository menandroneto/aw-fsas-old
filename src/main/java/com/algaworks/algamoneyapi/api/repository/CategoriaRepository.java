package com.algaworks.algamoneyapi.api.repository;

import com.algaworks.algamoneyapi.api.model.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
