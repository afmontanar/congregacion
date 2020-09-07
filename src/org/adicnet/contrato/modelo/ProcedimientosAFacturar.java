package org.adicnet.contrato.modelo;

import java.util.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.adicnet.contrato.soat.*;
import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity

public class ProcedimientosAFacturar {
	
	@Id
	@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
	@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String oid;
	
	@Column(length=50)
	@Required
	private String description;
	
	/*
	@ManyToMany( // La colección es persistente (1)
			mappedBy="procedimientosAFacturar",
	        cascade=CascadeType.REMOVE)
			private Collection<Procedimientos> procedimientos;
	*/
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	/*
	public Collection<Procedimientos> getProcedimientos() {
		return procedimientos;
	}

	public void setProcedimientos(Collection<Procedimientos> procedimientos) {
		this.procedimientos = procedimientos;
	}
	*/
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

}
