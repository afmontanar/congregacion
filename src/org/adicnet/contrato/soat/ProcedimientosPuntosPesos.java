package org.adicnet.contrato.soat;

import java.math.*;

import javax.persistence.*;

import org.adicnet.contrato.modelo.*;
import org.openxava.annotations.*;

@Entity
public class ProcedimientosPuntosPesos {
	@Id
	@Column(length=32)
	private int codigo;
	
	@Column(length=400)
	private String description;
	
	@Column(length=10)
	private float puntos;

	@Stereotype("MONEY") 
	private BigDecimal pesos;
	
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

	public float getPuntos() {
		return puntos;
	}

	public void setPuntos(float puntos) {
		this.puntos = puntos;
	}

	public BigDecimal getPesos() {
		return pesos;
	}

	public void setPesos(BigDecimal pesos) {
		this.pesos = pesos;
	}
	
}
