package br.com.machado.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.machado.models.audit.AuditModel;

@Entity
public class Emprestimo extends AuditModel {

	private static final long serialVersionUID = -7342953627986625710L;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date datRetirada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date datDevolucao;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("usuario_id")
	private Usuario usuario;
	
	 @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            })
	    @JoinTable(name = "emprestimo_livro",
	            joinColumns = { @JoinColumn(name = "emprestimo_id") },
	            inverseJoinColumns = { @JoinColumn(name = "livro_id") })
	 private Set<Livro> livros = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatRetirada() {
		return datRetirada;
	}

	public void setDatRetirada(Date datRetirada) {
		this.datRetirada = datRetirada;
	}

	public Date getDatDevolucao() {
		return datDevolucao;
	}

	public void setDatDevolucao(Date datDevolucao) {
		this.datDevolucao = datDevolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
	 
	public String toString() {
		return "["
				+ "id=" + this.id
				+ ", datRetirada=" + this.datRetirada
				+ ", datDevolucao=" + this.datDevolucao
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datDevolucao == null) ? 0 : datDevolucao.hashCode());
		result = prime * result + ((datRetirada == null) ? 0 : datRetirada.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((livros == null) ? 0 : livros.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (datDevolucao == null) {
			if (other.datDevolucao != null)
				return false;
		} else if (!datDevolucao.equals(other.datDevolucao))
			return false;
		if (datRetirada == null) {
			if (other.datRetirada != null)
				return false;
		} else if (!datRetirada.equals(other.datRetirada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (livros == null) {
			if (other.livros != null)
				return false;
		} else if (!livros.equals(other.livros))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}
