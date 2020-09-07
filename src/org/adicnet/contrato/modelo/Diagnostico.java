package org.adicnet.contrato.modelo;

import javax.persistence.*;

import org.adicnet.contrato.modelo.Paciente.*;

@Entity
public class Diagnostico {
	
	
	
	public Diagnostico() {
		super();
	}
	
	
	public Diagnostico(int codigo, String nombre, int edadMin, int edadMax, int edad1, int edad2, Sex sex) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.edadMin = edadMin;
		this.edadMax = edadMax;
		this.edad1 = edad1;
		this.edad2 = edad2;
		this.sex = sex;
	}
	
	
	@Id
	@Column(length=32)
	private int codigo;

	@Column(length=300)
	private String nombre;
	
	private int edadMin;
	
	private int edadMax;
	
	private int edad1;
	
	private int edad2;
	
	private Sex sex;
	public enum Sex { HOMBRE, MUJER, TRANSEXUAL }
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdadMin() {
		return edadMin;
	}
	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}
	public int getEdadMax() {
		return edadMax;
	}
	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}
	public int getEdad1() {
		return edad1;
	}
	public void setEdad1(int edad1) {
		this.edad1 = edad1;
	}
	public int getEdad2() {
		return edad2;
	}
	public void setEdad2(int edad2) {
		this.edad2 = edad2;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
}
