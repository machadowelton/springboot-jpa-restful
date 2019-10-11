package br.com.machado.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.machado.models.Usuario;
import br.com.machado.models.emb.Telefone;
import br.com.machado.models.enums.ETipoTelefone;
import br.com.machado.models.enums.ETipoUsoTelefone;
import br.com.machado.models.exception.AplicacaoException;
import br.com.machado.models.exception.NegocioException;
import br.com.machado.services.imp.UsuarioServiceImp;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioServiceImpTest {
	
	
	@TestConfiguration
	static class UsuarioServiceImpTestContextConfiguration {
		
		@Bean
		public UsuarioServiceImp service() {
			return new UsuarioServiceImp();
		}
		
	}
	
	@Autowired
	private UsuarioServiceImp service;
			
	@Test
	public void testBuscarPorIdSucesso() {
		Usuario usuario = 
				new Usuario("Bill Gates", new Date(), 
						new Telefone(55, 11, 978451245L, ETipoTelefone.CELULAR, ETipoUsoTelefone.PESSOAL));
		Usuario persist = service.inserir(usuario);
		assertThat(service.buscarPorId(persist.getId()).equals(persist)).isEqualTo(Boolean.TRUE);
	}
	
	@Test(expected = NegocioException.class)	
	public void testBuscarPorIdNegocioException() {
		service.buscarPorId(5000L);
	}
	
	@Test(expected = AplicacaoException.class)
	public void testBuscarPorIdNuloAplicacaoException() {
		service.buscarPorId(null);
	}
	
}
