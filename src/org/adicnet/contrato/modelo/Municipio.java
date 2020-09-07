package org.adicnet.contrato.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
public class Municipio {

	
	@Id
	@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
	@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String oid;

	@Column(length=200)
	private String descripcion;

	@ManyToOne( // La referencia se almacena como una relación en la base de datos
	    	fetch=FetchType.LAZY // La referencia se carga bajo demanda
	    	) // La referencia puede estar sin valor
	    	@DescriptionsList // Así la referencia se visualiza usando un combo
	    	private Departamento departamento; // Una referencia Java convencional
	
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
