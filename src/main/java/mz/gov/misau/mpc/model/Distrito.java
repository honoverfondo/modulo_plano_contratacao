package mz.gov.misau.mpc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "distrito")
@SequenceGenerator(name = "seq_distrito",sequenceName = "seq_distrito",initialValue = 1,allocationSize = 1)
public class Distrito  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_distrito")
	private Long id;
	
	private String nome;
	
	private String abrevDistrito;
	
	private Date dataRegisto;
	
	@OneToMany(mappedBy = "distrito",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<PostoAdministratitvo>postos=new ArrayList<PostoAdministratitvo>();
	
	@ManyToOne(targetEntity = Provincia.class)
	@JoinColumn(name = "provincia_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "provincia_fk"))
	private Provincia provincia;


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


	public String getAbrevDistrito() {
		return abrevDistrito;
	}


	public void setAbrevDistrito(String abrevDistrito) {
		this.abrevDistrito = abrevDistrito;
	}


	public Date getDataRegisto() {
		return dataRegisto;
	}


	public void setDataRegisto(Date dataRegisto) {
		this.dataRegisto = dataRegisto;
	}


	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
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
		Distrito other = (Distrito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
