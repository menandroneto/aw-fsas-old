package com.algaworks.algamoneyapi.api.repository;

import com.algaworks.algamoneyapi.api.model.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    void delete(Long codigo);
    
}
