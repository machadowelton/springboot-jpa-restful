package br.com.machado.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.machado.models.Usuario;
import br.com.machado.models.exception.AplicacaoException;
import br.com.machado.models.exception.NegocioException;
import br.com.machado.services.IUsuarioService;
import br.com.machado.services.abs.SuperAbs;
import br.com.machado.services.repository.UsuarioRepository;


@Service
public class UsuarioServiceImp extends SuperAbs<UsuarioRepository> implements IUsuarioService {

	@Override
	public Usuario buscarPorId(Long id) {
		logger.info("metodo=buscarPorId, id=" + id);
		try {
			return repository.findById(id)
					.map( u -> {
						logger.info("metodo=buscarPorId, usuario=" + u);
						return u;
					}).orElseThrow(() -> new NegocioException("Nenhum usuário encontrado pelo id: " + id));
		} catch (Exception e) {
			if(e instanceof NegocioException) {
				logger.warn("metodo=buscarPorId, throw=Nenhum usuário encontrado pelo id: " + id);
				throw e;
			} 
			logger.error("metodo=buscarPorId, throw=Ocorreu um erro no processamento da requisição", e);
			throw new AplicacaoException("Ocorreu um erro no processamento da requisição", e);
		}
	}

	@Override
	public List<Usuario> listarPaginado(Pageable pageable) {
		logger.info("metodo=listarPaginado");
		try {
			List<Usuario> usuarios = repository.findAll(pageable)
												.get()
												.collect(Collectors.toList());
			if (usuarios.size() < 1) {
				logger.warn("metodo=listarPaginado, throw=Nenhum usuário encontrado ou fim da pagina");
				throw new NegocioException("Nenhum usuário encontrado ou fim da pagina");
			}
			logger.info("metodo=listarPaginado, usuarios=" + usuarios);
			return usuarios;
		} catch (Exception e) {
			if(e instanceof NegocioException)
				throw e;
			logger.error("metodo=listarPaginado, throw=Ocorreu um erro no processamento da requisição");
			throw new AplicacaoException("Ocorreu um erro no processamento da requisição", e);
		}		
	}

	@Override
	public Usuario inserir(Usuario t) {
		logger.info("metodo=inserir, usuario=" + t);		
		try {
			Usuario usuario = repository.save(t);
			logger.info("metodo=inserir, usuario=" + t.toString());
			return usuario;
		} catch (Exception e) {
			logger.error("metodo=inserir, throw=Ocorreu um erro no processamento da requisição", e);
			throw new AplicacaoException("Ocorreu um erro no processamento da requisição", e);
		}
	}

	@Override
	public Usuario atualizar(Usuario t) {
		logger.info("metodo=atualizar, usuario=" + t);
		if(!repository.existsById(t.getId()))
			throw new NegocioException("Nenhum usuário encontrado pelo id: " + t.getId());
		return repository.save(t);
	}

	@Override
	public void deletarPorId(Long id) {
		logger.info("metodo=deletarPorId, id=" + id);
		if(!repository.existsById(id))
			throw new NegocioException("Nenhum usuário encontrado pelo id: " + id);
		repository.deleteById(id);
	}

}
