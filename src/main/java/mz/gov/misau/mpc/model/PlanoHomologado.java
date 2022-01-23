package mz.gov.misau.mpc.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mz.gov.misau.mpc.enums.TipoPlanoHomologado;

@Entity
@Table(name = "plano_homologado")
@SequenceGenerator(name = "seq_plano_homologado", sequenceName = "seq_plano_homologado", allocationSize = 1, initialValue = 1)
public class PlanoHomologado {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plano_homologado")
	private Long id;

	@Column(nullable = false)
	private Long ano;

	
	@Enumerated(EnumType.STRING)
	private TipoPlanoHomologado tipoPlanoHomologado;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getAno() {
		return ano;
	}


	public void setAno(Long ano) {
		this.ano = ano;
	}


	public TipoPlanoHomologado getTipoPlanoHomologado() {
		return tipoPlanoHomologado;
	}


	public void setTipoPlanoHomologado(TipoPlanoHomologado tipoPlanoHomologado) {
		this.tipoPlanoHomologado = tipoPlanoHomologado;
	}


	

	
}
