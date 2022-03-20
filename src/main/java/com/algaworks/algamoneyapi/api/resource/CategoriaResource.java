package com.algaworks.algamoneyapi.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(codigo);
        return categoria.isPresent() ?
            ResponseEntity.ok(categoria.get()) :
            ResponseEntity.notFound().build();
    }

    @GetMapping("/map/{codigo}")
    public ResponseEntity<Categoria> buscarPeloCodigoViaMap(@PathVariable Long codigo) {
        return this.categoriaRepository.findById(codigo)
            .map(categoria -> ResponseEntity.ok(categoria))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequestUri().path("/{codigo}")
            .buildAndExpand(categoriaSalva.getCodigo())
            .toUri();
        response.setHeader("Location", uri.toASCIIString());    
        return ResponseEntity.created(uri).body(categoriaSalva);
    }

}