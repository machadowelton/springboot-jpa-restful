package br.com.machado.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.machado.models.Usuario;
import br.com.machado.services.imp.UsuarioServiceImp;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImp service;
	
	@GetMapping("/{idUsuario}")
	public Usuario buscarPorId(@PathVariable("idUsuario")Long id) {
		return service.buscarPorId(id);
	}
	
	@GetMapping
	public List<Usuario> listarPaginado(Pageable pageable) {
		return service.listarPaginado(pageable);
	}
	
	@PostMapping
	public Usuario inserir(@Valid @RequestBody Usuario usuario) {
		return service.inserir(usuario);
	}
	
	@PutMapping
	public Usuario atualizar(@Valid @RequestBody Usuario usuario) {
		return service.atualizar(usuario);
	}
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<?> deletarPorId(@PathVariable("idUsuario")Long id) {
		service.deletarPorId(id);
		return ResponseEntity.ok().build();
	}
	
}
