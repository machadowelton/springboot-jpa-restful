package br.com.machado.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.machado.models.audit.AuditModel;

@Entity
public class Livro extends AuditModel {

	private static final long serialVersionUID = 3044107981508316174L;

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
	private String desTituloLivro;
	
	@NotNull
	@Lob
	private String desSinopse;
	
	@NotNull
	private String nomAutor;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sessao_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("sessao_id")
	private Sessao sessao;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "livros")
	@JsonIgnore
	private Set<Emprestimo> emprestimos = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesTituloLivro() {
		return desTituloLivro;
	}

	public void setDesTituloLivro(String desTituloLivro) {
		this.desTituloLivro = desTituloLivro;
	}

	public String getDesSinopse() {
		return desSinopse;
	}

	public void setDesSinopse(String desSinopse) {
		this.desSinopse = desSinopse;
	}

	public String getNomAutor() {
		return nomAutor;
	}

	public void setNomAutor(String nomAutor) {
		this.nomAutor = nomAutor;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Set<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(Set<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	public String toString() {
		return "["
				+ "id=" + this.id
				+ ", desTituloLivro=" + this.desTituloLivro
				+ ", desSinopse=" + this.desSinopse
				+ ", nomAutor=" + this.nomAutor
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desSinopse == null) ? 0 : desSinopse.hashCode());
		result = prime * result + ((desTituloLivro == null) ? 0 : desTituloLivro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomAutor == null) ? 0 : nomAutor.hashCode());
		result = prime * result + ((sessao == null) ? 0 : sessao.hashCode());
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
		Livro other = (Livro) obj;
		if (desSinopse == null) {
			if (other.desSinopse != null)
				return false;
		} else if (!desSinopse.equals(other.desSinopse))
			return false;
		if (desTituloLivro == null) {
			if (other.desTituloLivro != null)
				return false;
		} else if (!desTituloLivro.equals(other.desTituloLivro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomAutor == null) {
			if (other.nomAutor != null)
				return false;
		} else if (!nomAutor.equals(other.nomAutor))
			return false;
		if (sessao == null) {
			if (other.sessao != null)
				return false;
		} else if (!sessao.equals(other.sessao))
			return false;
		return true;
	}
	
}
