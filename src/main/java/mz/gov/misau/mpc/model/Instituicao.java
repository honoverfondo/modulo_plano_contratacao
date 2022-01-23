package mz.gov.misau.mpc.model;

import java.io.Serializable;
import java.util.ArrayList;
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

@Entity
@Table(name = "instituicao")
@SequenceGenerator(name = "seq_instituicao", sequenceName = "seq_instituicao", allocationSize = 1, initialValue = 1)
public class Instituicao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_instituicao")
	private Long id;

	@Column(nullable = false)
	private String nome;

	private String abrevInstituicao;

	@Column(nullable = false)
	private Long nuit;

	private Long casaN;

	private Long quart;
	
	@OneToMany(mappedBy = "instituicao",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Direcao> direcoes=new ArrayList<Direcao>();

	@ManyToOne(targetEntity = Rua.class)
	@JoinColumn(name = "rua_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "rua_fk"))
	private Rua rua;

	
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

	public String getAbrevInstituicao() {
		return abrevInstituicao;
	}

	public void setAbrevInstituicao(String abrevInstituicao) {
		this.abrevInstituicao = abrevInstituicao;
	}

	public Long getNuit() {
		return nuit;
	}

	public void setNuit(Long nuit) {
		this.nuit = nuit;
	}

	public Long getCasaN() {
		return casaN;
	}

	public void setCasaN(Long casaN) {
		this.casaN = casaN;
	}

	public Long getQuart() {
		return quart;
	}

	public void setQuart(Long quart) {
		this.quart = quart;
	}

	public Rua getRua() {
		return rua;
	}

	public void setRua(Rua rua) {
		this.rua = rua;
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
		Instituicao other = (Instituicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Direcao> getDirecoes() {
		return direcoes;
	}

	public void setDirecoes(List<Direcao> direcoes) {
		this.direcoes = direcoes;
	}

}
