package org.adicnet.contrato.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Servicio {
@Id
@Column(length=32)
private String codigo;

@Column(length=500)
private String nombre;

private double puntos;

@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
private BigDecimal precio;

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

public double getPuntos() {
	return puntos;
}

public void setPuntos(double puntos) {
	this.puntos = puntos;
}

public BigDecimal getPrecio() {
	return precio;
}

public void setPrecio(BigDecimal precio) {
	this.precio = precio;
}



}
