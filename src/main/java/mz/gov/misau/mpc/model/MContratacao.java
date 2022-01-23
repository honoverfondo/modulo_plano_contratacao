package mz.gov.misau.mpc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mContratacao")
@SequenceGenerator(name = "seq_mcontratacao", sequenceName = "seq_mcontratacao", allocationSize = 1, initialValue = 1)
public class MContratacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_mcontratacao")
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Date dataRegisto;
	
	@OneToMany(mappedBy = "mcontratacao",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<PlanoServico>planoservicos=new ArrayList<PlanoServico>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(Date dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	
	public List<PlanoServico> getPlanoservicos() {
		return planoservicos;
	}

	public void setPlanoservicos(List<PlanoServico> planoservicos) {
		this.planoservicos = planoservicos;
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
		MContratacao other = (MContratacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
