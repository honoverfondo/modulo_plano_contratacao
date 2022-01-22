package mz.gov.misau.mpc.model;

import java.io.Serializable;



//@Entity
//@Table(name = "contact_departamento")
//@SequenceGenerator(name = "seq_contact_departamento",sequenceName = "seq_contact_departamento",allocationSize = 1,initialValue = 1)
public class ContactoDepartamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
