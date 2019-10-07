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

import br.com.machado.models.Emprestimo;
import br.com.machado.services.imp.EmprestimoServiceImp;

@RestController
public class EmprestimoController {
	
	@Autowired
	private EmprestimoServiceImp service;
	
	@GetMapping("/usuario/{idUsuario}/emprestimo/{idEmprestimo}")
	public Emprestimo buscarPorIdEIdUsuario(
			@PathVariable("idUsuario") Long idUsuario,
			@PathVariable("idEmprestimo") Long idEmprestimo
			) {
		return service.buscarPorIdEIdUsuario(idEmprestimo, idUsuario);
	}
	
	@GetMapping("/usuario/{idUsuario}/emprestimo")
	public List<Emprestimo> listarPorIdUsuarioPaginado(
			@PathVariable("idUsuario") Long idUsuario,
			Pageable pageable
			) {
		return service.listarPorIdUsuarioPaginado(idUsuario, pageable);
	}
	
	
	@PostMapping("/usuario/{idUsuario}/emprestimo")
	public Emprestimo inserir(
			@PathVariable("idUsuario") Long idUsuario,
			@Valid @RequestBody Emprestimo emprestimo			
			) {
		return service.inserir(idUsuario, emprestimo);
	}
	
	@PutMapping("/usuario/{idUsuario}/emprestimo")
	public Emprestimo atualizar(
			@PathVariable("idUsuario") Long idUsuario,
			@Valid @RequestBody Emprestimo emprestimo			
			) {
		return service.atualizar(idUsuario, emprestimo);
	}
	
	@PutMapping("/usuario/{idUsuario}/emprestimo/{idEmprestimo}/livro/{idLivro}")
	public ResponseEntity<?> addLivro(
			@PathVariable("idUsuario") Long idUsuario,
			@PathVariable("idEmprestimo") Long idEmprestimo,
			@PathVariable("idLivro") Long idLivro
			) {
		service.addLivro(idUsuario, idEmprestimo, idLivro);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/usuario/{idUsuario}/emprestimo/{idEmprestimo}")
	public ResponseEntity<?> deletarPorIdEIdUsuario(
			@PathVariable("idUsuario") Long idUsuario,
			@PathVariable("idEmprestimo") Long idEmprestimo
			) {
		service.deletarPorIdEIdUsuario(idEmprestimo, idUsuario);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/emprestimo")
	public List<Emprestimo> listarTodosPaginado(Pageable pageable) {
		return service.listarTodosPaginado(pageable);
	}
	
	
}
