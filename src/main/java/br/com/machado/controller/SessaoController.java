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

import br.com.machado.models.Sessao;
import br.com.machado.services.imp.SessaoServiceImp;

@RestController
@RequestMapping("/sessao")
public class SessaoController {
	
	@Autowired
	private SessaoServiceImp service;
	
	@GetMapping("/{idSessao}")
	public Sessao  buscarPorId(@PathVariable("idSessao") Long idSessao) {
		return service.buscarPorId(idSessao);
	}
	
	@GetMapping
	public List<Sessao> listarPaginado(Pageable pageable) {
		return service.listarPaginado(pageable);
	}
	
	@PostMapping
	public Sessao inserir(@Valid @RequestBody Sessao sessao) {
		return service.inserir(sessao);
	}
	
	@PutMapping
	public Sessao atualizar(@Valid @RequestBody Sessao sessao) {
		return service.atualizar(sessao);
	}
	
	@DeleteMapping("/{idSessao}")
	public ResponseEntity<?> deletarPorId(@PathVariable("idSessao") Long idSessao) {
		service.deletarPorId(idSessao);
		return ResponseEntity.ok().build();
	}
	
	
}
