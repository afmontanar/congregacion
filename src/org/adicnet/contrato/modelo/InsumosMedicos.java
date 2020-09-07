package org.adicnet.contrato.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class InsumosMedicos {

	@Id
	@Column(length=32)
	private String codigo;
	
	@Column(length=400)
	private String nombre;
	
	@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
	private BigDecimal valor;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	

	
}
