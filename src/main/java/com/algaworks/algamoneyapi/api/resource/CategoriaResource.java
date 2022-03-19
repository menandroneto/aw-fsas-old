package com.algaworks.algamoneyapi.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.algaworks.algamoneyapi.api.model.Categoria;
import com.algaworks.algamoneyapi.api.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Categoria buscarPeloCodigo(@PathVariable Long codigo) {
      return this.categoriaRepository.findById(codigo).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequestUri().path("/{codigo}")
            .buildAndExpand(categoriaSalva.getCodigo())
            .toUri();
        response.setHeader("Location", uri.toASCIIString());    
        return ResponseEntity.created(uri).body(categoriaSalva);
    }

}