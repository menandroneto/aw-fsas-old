package com.algaworks.algamoneyapi.api.service;

import java.util.Optional;

import javax.validation.Valid;

import com.algaworks.algamoneyapi.api.model.Lancamento;
import com.algaworks.algamoneyapi.api.model.Pessoa;
import com.algaworks.algamoneyapi.api.repository.LancamentoRepository;
import com.algaworks.algamoneyapi.api.repository.PessoaRepository;
import com.algaworks.algamoneyapi.api.service.exception.PessoaInexistenteOuInativaException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(@Valid Lancamento lancamento) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        
        
        if (!pessoaOptional.isPresent() || pessoaOptional.get().isInativo()){
            throw new PessoaInexistenteOuInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }
    
}
