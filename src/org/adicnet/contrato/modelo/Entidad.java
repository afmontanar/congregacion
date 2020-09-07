package org.adicnet.contrato.modelo;


import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

@Entity
public class Entidad {
	
	
@Id
@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
@GenericGenerator(name="system-uuid", strategy = "uuid")
@Column(length=32)
private String oid;


@Column(length=50)
private String description;

public String getNit() {
	return nit;
}
public void setNit(String nit) {
	this.nit = nit;
}

public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getMunicipio() {
	return municipio;
}
public void setMunicipio(String municipio) {
	this.municipio = municipio;
}
public String getDepartamento() {
	return departamento;
}
public void setDepartamento(String departamento) {
	this.departamento = departamento;
}
@Column(length=30)  // La longitud de columna se usa a nivel UI y a nivel DB
private String nit;

@Column(length=30)  // La longitud de columna se usa a nivel UI y a nivel DB
private String direccion;

@Stereotype("EMAIL")  // La longitud de columna se usa a nivel UI y a nivel DB
private String email;

@Stereotype("TELEPHONE")
private String telefono;

@Column(length=30) 
private String municipio;

@Column(length=30) 
private String departamento;


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