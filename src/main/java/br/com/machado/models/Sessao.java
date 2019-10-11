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
	
	private static final long serialVersionUID = -9099337855859914077L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desLocalizacao == null) ? 0 : desLocalizacao.hashCode());
		result = prime * result + ((desSessao == null) ? 0 : desSessao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomSessao == null) ? 0 : nomSessao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sessao other = (Sessao) obj;
		if (desLocalizacao == null) {
			if (other.desLocalizacao != null)
				return false;
		} else if (!desLocalizacao.equals(other.desLocalizacao))
			return false;
		if (desSessao == null) {
			if (other.desSessao != null)
				return false;
		} else if (!desSessao.equals(other.desSessao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomSessao == null) {
			if (other.nomSessao != null)
				return false;
		} else if (!nomSessao.equals(other.nomSessao))
			return false;
		return true;
	}
	
}
