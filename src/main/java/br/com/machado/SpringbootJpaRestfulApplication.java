package br.com.machado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.com.machado.services.repository.EmprestimoRepository;
import br.com.machado.services.repository.LivroRepository;
import br.com.machado.services.repository.SessaoRepository;
import br.com.machado.services.repository.UsuarioRepository;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootJpaRestfulApplication implements CommandLineRunner {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRestfulApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		emprestimoRepository.deleteAllInBatch();
		livroRepository.deleteAllInBatch();
		sessaoRepository.deleteAllInBatch();
		usuarioRepository.deleteAllInBatch();
	}

}
