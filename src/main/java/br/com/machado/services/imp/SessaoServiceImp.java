package br.com.machado.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.machado.models.Sessao;
import br.com.machado.models.exception.NegocioException;
import br.com.machado.services.ISessaoService;
import br.com.machado.services.abs.SuperAbs;
import br.com.machado.services.repository.SessaoRepository;

@Service
public class SessaoServiceImp extends SuperAbs<SessaoRepository> implements ISessaoService {

	@Override
	public Sessao buscarPorId(Long id) {
		return repository.findById(id)
				.map( s -> {
					return s;
				}).orElseThrow(() -> new NegocioException("Nenhuma sessão encontrada pelo id: " + id));
	}

	@Override
	public List<Sessao> listarPaginado(Pageable pageable) {
		List<Sessao>  sessaos = repository.findAll(pageable)
									.get()
									.collect(Collectors.toList());
		if(sessaos.size() < 1 )
			throw new NegocioException("Nenhuma sessão encontrada");
		return sessaos;
	}

	@Override
	public Sessao inserir(Sessao t) {
		return repository.save(t);
	}

	@Override
	public Sessao atualizar(Sessao t) {
		if(!repository.existsById(t.getId()))
			throw new NegocioException("Nenhuma sessão encontrada pelo id: " + t.getId());		
		return repository.save(t);
	}

	@Override
	public void deletarPorId(Long id) {
		if(!repository.existsById(id))
			throw new NegocioException("Nenhuma sessão encontrada pelo id: " + id);
		repository.deleteById(id);
	}

}
