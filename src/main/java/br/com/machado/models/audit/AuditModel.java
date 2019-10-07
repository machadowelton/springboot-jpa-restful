package br.com.machado.models.audit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"criadoEm", "atualizadoEm"},
        allowGetters = true
)
public abstract class AuditModel implements Serializable  {
	
	private static final long serialVersionUID = 5792572642022720231L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "criado_em", nullable = false, updatable = false)
	@CreatedDate
	private Date criadoEm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "atualizado_em", nullable = false)
	@LastModifiedDate
	private Date atualizadoEm;
	
	
}
