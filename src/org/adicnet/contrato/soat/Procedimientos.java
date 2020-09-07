package org.adicnet.contrato.soat;

import javax.persistence.*;

import org.adicnet.contrato.modelo.*;
import org.openxava.annotations.*;
@Entity
@View(members="codigo, description, grupoQuirurgico")
public class Procedimientos {
	@Id
	@Column(length=32)
	private int codigo;
	
	
	public Procedimientos() {
		super();
	}

	public Procedimientos(int codigo, String description, String grupoQuirurgico) {
		super();
		this.codigo = codigo;
		this.description = description;
		this.grupoQuirurgico = grupoQuirurgico;
	}

	/*
	 * @ManyToOne
	private Contrato contrato;
	*/
	@Column( length=400)
	private String description;
	
	@Column(length=400)
	private String grupoQuirurgico;
	
	
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

	public String getGrupoQuirurgico() {
		return grupoQuirurgico;
	}

	public void setGrupoQuirurgico(String grupoQuirurgico) {
		this.grupoQuirurgico = grupoQuirurgico;
	}

	/*
	 * public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}*/
	

	
}
