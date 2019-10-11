package br.com.machado.models.emb;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import br.com.machado.models.enums.ETipoTelefone;
import br.com.machado.models.enums.ETipoUsoTelefone;

@Embeddable
public class Telefone {
	
	@NotNull
	private Integer numDDI;
	
	@NotNull
	private Integer numDDD;	
	
	@NotNull
	private Long numTelefone;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ETipoTelefone tpoTelefone;
 
	@Enumerated(EnumType.STRING)
	private ETipoUsoTelefone tpoUsoTelefone;
	
	public Telefone() {
		
	}
	
	public Telefone(int numDDI, int numDDD, long numTelefone, 
			ETipoTelefone tpoTelefone, ETipoUsoTelefone tpoUsoTelefone) {
		this.numDDI = numDDI;
		this.numDDD = numDDD;
		this.numTelefone = numTelefone;
		this.tpoTelefone = tpoTelefone;
		this.tpoUsoTelefone = tpoUsoTelefone;
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof Telefone)) return false;
		Telefone telefone = (Telefone)o;
		return this.numDDI == telefone.numDDI
				&& this.numDDD == telefone.numDDD
				&& this.numTelefone == telefone.numTelefone
				&& this.tpoTelefone == null && telefone.tpoTelefone == null ?
						Boolean.TRUE : this.tpoTelefone.equals(telefone.tpoTelefone)
				&& this.tpoUsoTelefone == null && this.tpoUsoTelefone == null ?
						Boolean.TRUE : this.tpoUsoTelefone.equals(telefone.tpoUsoTelefone);
	}

	public Integer getNumDDI() {
		return numDDI;
	}

	public void setNumDDI(Integer numDDI) {
		this.numDDI = numDDI;
	}

	public Integer getNumDDD() {
		return numDDD;
	}

	public void setNumDDD(Integer numDDD) {
		this.numDDD = numDDD;
	}

	public Long getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(Long numTelefone) {
		this.numTelefone = numTelefone;
	}

	public ETipoTelefone getTpoTelefone() {
		return tpoTelefone;
	}

	public void setTpoTelefone(ETipoTelefone tpoTelefone) {
		this.tpoTelefone = tpoTelefone;
	}

	public ETipoUsoTelefone getTpoUsoTelefone() {
		return tpoUsoTelefone;
	}

	public void setTpoUsoTelefone(ETipoUsoTelefone tpoUsoTelefone) {
		this.tpoUsoTelefone = tpoUsoTelefone;
	}
	
	public String toString() {
		return "["
				+ "numDDI="  + this.numDDI
				+ ", numDDD=" + this.numDDD
				+ ", numTelefone=" + this.numTelefone
				+ ", tpoTelefone=" + this.tpoTelefone
				+ ", tpoUsoTelefone=" + this.tpoUsoTelefone
				+ "]";
	}
	
}
