package org.adicnet.contrato.modelo;


import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
@Entity
public class Tarifa {
	
	
@Id
@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
@GenericGenerator(name="system-uuid", strategy = "uuid")
@Column(length=32)
private String oid;


@Column(length=50)
private String description;


@Column(length=11)  // La longitud de columna se usa a nivel UI y a nivel DB
private int salarioMinimo;

@Column(length=4)  // La longitud de columna se usa a nivel UI y a nivel DB
@Max(value=100)
@Min(value=0)
private float porcentaje;

public float getPorcentaje() {
	return porcentaje;
}
public void setPorcentaje(float porcentaje) {
	this.porcentaje = porcentaje;
}
public int getSalarioMinimo() {
	return salarioMinimo;
}
public void setSalarioMinimo(int salarioMinimo) {
	this.salarioMinimo = salarioMinimo;
}
// Getters y setters


public String getOid() {
	return oid;
}
public void setOid(String oid) {
	this.oid = oid;
}


public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}