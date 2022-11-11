package br.com.fiap.gs.controllers;

import java.util.List;
import java.util.Optional;

import br.com.fiap.gs.models.Veiculo;
import br.com.fiap.gs.repositories.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	@Autowired
	private VeiculoRepository repo;
	
	@GetMapping
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<List<Veiculo>> getAll() {
        List<Veiculo> data = repo.findAll();
        return new ResponseEntity<List<Veiculo>>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<Veiculo> findById(@PathVariable Long id){
        Optional<Veiculo> data = repo.findById(id);
        return new ResponseEntity<Veiculo>(data.get(), data.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Veiculo> salvar(@RequestBody Veiculo model){
        
        repo.save(model);
        return new ResponseEntity<Veiculo>(model, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
    	Optional<Veiculo> modelExistente = repo.findById(id);
    	
    	if (!modelExistente.isPresent()) {
    		return new ResponseEntity("Registro não existe", HttpStatus.BAD_REQUEST);
    	}
    	
    	repo.deleteById(id);
    	return new ResponseEntity(Boolean.TRUE, HttpStatus.OK);
    }
}
