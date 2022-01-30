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
@Table(name = "fonte_recurso")
@SequenceGenerator(name = "seq_fonte_recurso", sequenceName = "seq_fonte_recurso", allocationSize = 1, initialValue = 1)
public class FonteRecurso implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_fonte_recurso")
	private Long id;
	
	@Column(nullable = false)
	private String abreviatura;

	@Temporal(TemporalType.DATE)
	private Date dataRegisto;
	
	@OneToMany(mappedBy ="fonterecurso",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	private List<PlanoServico> planoservicos=new ArrayList<PlanoServico>();
	
	public Date getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(Date dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
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
		FonteRecurso other = (FonteRecurso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
