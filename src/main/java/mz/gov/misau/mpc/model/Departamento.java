package mz.gov.misau.mpc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "departamento")
@SequenceGenerator(name = "seq_departamento", sequenceName = "seq_departamento", allocationSize = 1, initialValue = 1)
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_departamento")
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String abrevDepartamento;

	@Temporal(TemporalType.DATE)
	private Date dataRegisto;

	@OneToMany(mappedBy = "departamento", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContactDepartamento> contactosDepartamento = new ArrayList<ContactDepartamento>();

	@OneToMany(mappedBy = "departamento", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PlanoServico> planoservico = new ArrayList<PlanoServico>();

	@ManyToOne(targetEntity = Direcao.class)
	@JoinColumn(name = "direcao_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "direcao_fk"))
	private Direcao direcao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAbrevDepartamento() {
		return abrevDepartamento;
	}

	public void setAbrevDepartamento(String abrevDepartamento) {
		this.abrevDepartamento = abrevDepartamento;
	}

	public Date getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(Date dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public List<ContactDepartamento> getContactosDepartamento() {
		return contactosDepartamento;
	}

	public void setContactosDepartamento(List<ContactDepartamento> contactosDepartamento) {
		this.contactosDepartamento = contactosDepartamento;
	}

	public List<PlanoServico> getPlanoservico() {
		return planoservico;
	}

	public void setPlanoservico(List<PlanoServico> planoservico) {
		this.planoservico = planoservico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
