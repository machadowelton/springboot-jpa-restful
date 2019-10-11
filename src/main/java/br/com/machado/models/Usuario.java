package br.com.machado.models;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.machado.models.audit.AuditModel;
import br.com.machado.models.emb.Telefone;

@Entity
public class Usuario extends AuditModel {
	
	private static final long serialVersionUID = -3845894238032917099L;

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
	private String nomUsuario;
	
	@Embedded
	private Telefone telefone;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date datNascimento;
	
	public Usuario() {}	
	
	public Usuario(String nomUsuario, Date datNascimento, Telefone telefone) {
		this.nomUsuario = nomUsuario;
		this.datNascimento = datNascimento;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Date getDatNascimento() {
		return datNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datNascimento == null) ? 0 : datNascimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomUsuario == null) ? 0 : nomUsuario.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Usuario other = (Usuario) obj;
		if (datNascimento == null) {
			if (other.datNascimento != null)
				return false;
		} else if (!datNascimento.equals(other.datNascimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomUsuario == null) {
			if (other.nomUsuario != null)
				return false;
		} else if (!nomUsuario.equals(other.nomUsuario))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	public void setDatNascimento(Date datNascimento) {
		this.datNascimento = datNascimento;
	}
	
	public String toString() {
		return "["
				+ "id=" + this.id
				+ ", nomUsuario=" + this.nomUsuario
				+ ", datNascimento=" + this.datNascimento
				+ ", telefone=" + this.telefone
				+ "]";
	}

	
	
}
