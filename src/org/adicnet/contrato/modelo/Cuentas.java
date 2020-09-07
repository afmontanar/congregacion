package org.adicnet.contrato.modelo;

import javax.persistence.*;

@Entity
public class Cuentas {
	  @Id
	  @Column(length=32)  // La longitud de columna se usa a nivel UI y a nivel DB
	  private String numero2;
	  
	  @Column(length=20)  // La longitud de columna se usa a nivel UI y a nivel DB
	  private String nombre2;

	public String getNumero2() {
		return numero2;
	}

	public void setNumero2(String numero2) {
		this.numero2 = numero2;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	  
	  
}
