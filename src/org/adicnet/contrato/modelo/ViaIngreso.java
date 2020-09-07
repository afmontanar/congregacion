package org.adicnet.contrato.modelo;

import javax.persistence.*;

@Entity
public class ViaIngreso {
	@Id
	@Column(length=32)
	private int numeroId;
	
	@Column(length=400)
	private String description;

	public int getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(int numeroId) {
		this.numeroId = numeroId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
