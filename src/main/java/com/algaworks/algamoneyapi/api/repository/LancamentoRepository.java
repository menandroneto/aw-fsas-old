package com.algaworks.algamoneyapi.api.repository;

import com.algaworks.algamoneyapi.api.model.Lancamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    
}
