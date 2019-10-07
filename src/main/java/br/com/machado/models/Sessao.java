package br.com.machado.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.machado.models.audit.AuditModel;

@Entity
public class Sessao extends AuditModel {
	
	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private Long id;
	
	@NotNull
	private String nomSessao;
	
	@Lob
	private String desSessao;
	
	@NotNull
	@NotBlank
	private String desLocalizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomSessao() {
		return nomSessao;
	}

	public void setNomSessao(String nomSessao) {
		this.nomSessao = nomSessao;
	}

	public String getDesSessao() {
		return desSessao;
	}

	public void setDesSessao(String desSessao) {
		this.desSessao = desSessao;
	}

	public String getDesLocalizacao() {
		return desLocalizacao;
	}

	public void setDesLocalizacao(String desLocalizacao) {
		this.desLocalizacao = desLocalizacao;
	}
	
	public String toString() {
		return "["
				+ "id=" + this.id
				+ ", nomSessao=" + this.nomSessao
				+ ", desSessao=" + this.desSessao
				+ ", desLocalizao=" + this.desLocalizacao
				+ "]";
	}
	
}
