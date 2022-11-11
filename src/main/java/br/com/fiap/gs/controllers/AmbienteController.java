package br.com.fiap.gs.controllers;

import java.util.List;
import java.util.Optional;

import br.com.fiap.gs.models.Ambiente;
import br.com.fiap.gs.repositories.AmbienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/ambiente")
public class AmbienteController {
	@Autowired
	private AmbienteRepository repo;
	
	@GetMapping
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<List<Ambiente>> getAll() {
        List<Ambiente> data = repo.findAll();
        return new ResponseEntity<List<Ambiente>>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<Ambiente> findById(@PathVariable Long id){
        Optional<Ambiente> data = repo.findById(id);
        return new ResponseEntity<Ambiente>(data.get(), data.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Ambiente> salvar(@RequestBody Ambiente model){
        
        repo.save(model);
        return new ResponseEntity<Ambiente>(model, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
    	Optional<Ambiente> modelExistente = repo.findById(id);
    	
    	if (!modelExistente.isPresent()) {
    		return new ResponseEntity("Registro não existe", HttpStatus.BAD_REQUEST);
    	}
    	
    	repo.deleteById(id);
    	return new ResponseEntity(Boolean.TRUE, HttpStatus.OK);
    }
}
