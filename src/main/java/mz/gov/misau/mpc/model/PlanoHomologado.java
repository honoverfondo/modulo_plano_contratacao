package mz.gov.misau.mpc.model;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "plano_homologado")
@SequenceGenerator(name = "seq_plano_homologado", sequenceName = "seq_plano_homologado", allocationSize = 1, initialValue = 1)
public class PlanoHomologado {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plano_homologado")
	private Long id;

	@Column(nullable = false)
	private Long ano;

	@Column(nullable = false)
	private String estado;

}
