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
import org.springframework.web.bind.annotation.RestController;

import br.com.machado.models.Livro;
import br.com.machado.services.imp.LivroServiceImp;

@RestController
public class LivroController {
	
	@Autowired
	private LivroServiceImp service;
	
	@GetMapping("/sessao/{idSessao}/livro/{idLivro}")
	public Livro buscarPorIdEIdSessao(
			@PathVariable("idSessao") Long idSessao,
			@PathVariable("idLivro") Long idLivro
			) {
		return service.buscarPorIdEIdSessao(idLivro, idSessao);
	}
	
	@GetMapping("/sessao/{idSessao}/livro")
	public List<Livro> listarPorIdSessaoPaginado(
			@PathVariable("idSessao") Long idSessao,
			Pageable pageable
			) {
		return service.listarPorIdSessaoPaginado(idSessao, pageable);
	}
	
	@PostMapping("/sessao/{idSessao}/livro")
	public Livro inserir(
			@PathVariable("idSessao") Long idSessao,
			@Valid @RequestBody Livro livro
			) {
		return service.inserir(idSessao, livro);
	}
	
	@PutMapping("/sessao/{idSessao}/livro")
	public Livro atualizar(
			@PathVariable("idSessao") Long idSessao,
			@Valid @RequestBody Livro livro
			) {
		return service.inserir(idSessao, livro);
	}
	
	@DeleteMapping("/sessao/{idSessao}/livro/{idLivro}")
	public ResponseEntity<?> deletarPorIdEIdSessao(
			@PathVariable("idSessao") Long idSessao,
			@PathVariable("idLivro") Long idLivro
			) {
		service.deletarPorIdEIdSessao(idLivro, idSessao);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/livro")
	public List<Livro> listarTodosPaginado(Pageable pageable) {
		return service.listarTodosPaginado(pageable);
	}
	
}
