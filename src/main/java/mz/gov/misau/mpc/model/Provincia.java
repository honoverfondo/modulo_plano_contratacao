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
@Table(name = "provincia")
@SequenceGenerator(name = "seq_provincia", sequenceName = "seq_provincia", allocationSize = 1, initialValue = 1)
public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_provincia")
	private Long id;

	@Column(nullable = false)
	private String nome;

	private String abrevProvincia;

	@Temporal(TemporalType.DATE)
	private Date dataResgisto;

	@OneToMany(mappedBy = "provincia",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Distrito>distritos=new ArrayList<Distrito>();
	
	
	public List<Distrito> getDistritos() {
		return distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

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

	public String getAbrevProvincia() {
		return abrevProvincia;
	}

	public void setAbrevProvincia(String abrevProvincia) {
		this.abrevProvincia = abrevProvincia;
	}

	public Date getDataResgisto() {
		return dataResgisto;
	}

	public void setDataResgisto(Date dataResgisto) {
		this.dataResgisto = dataResgisto;
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
		Provincia other = (Provincia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
