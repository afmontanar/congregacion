package org.adicnet.contrato.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;



@Entity
public class Departamento {

	@Id
	@Column(length=5)
	private int codigo;
	


	@Column(length=50)
	private String description;
	


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
}
