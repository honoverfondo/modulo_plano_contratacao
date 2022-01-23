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
@Table(name = "bairro")
@SequenceGenerator(name = "seq_bairro",sequenceName ="seq_bairro",allocationSize = 1,initialValue =1 )
public class Bairro implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_bairro")
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	
	private String abrevBairro;
	
	@Temporal(TemporalType.DATE)
	private Date dataRegisto;
	
	
	

	@OneToMany(mappedBy = "bairro",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)//Mapeia com a mesma classe
	private List<Rua> ruas=new ArrayList<Rua>();

	
	@ManyToOne(targetEntity = PostoAdministratitvo.class)
	@JoinColumn(name = "posto_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "posto_fk"))
	private PostoAdministratitvo postoAdministrativo;

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

	public String getAbrevBairro() {
		return abrevBairro;
	}

	public void setAbrevBairro(String abrevBairro) {
		this.abrevBairro = abrevBairro;
	}

	public Date getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(Date dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public PostoAdministratitvo getPostoAdministrativo() {
		return postoAdministrativo;
	}

	public void setPostoAdministrativo(PostoAdministratitvo postoAdministrativo) {
		this.postoAdministrativo = postoAdministrativo;
	}

	


	public List<Rua> getRuas() {
		return ruas;
	}

	public void setRuas(List<Rua> ruas) {
		this.ruas = ruas;
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
		Bairro other = (Bairro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
