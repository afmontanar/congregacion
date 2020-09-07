package org.adicnet.contrato.modelo;

import java.math.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.adicnet.contrato.soat.*;
import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
public class Nacidos {
	
	@Id
	@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
	@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String oico;
	
	@ManyToOne
	private Procedimientos procedimiento;
	
	private int cantidad;
	
	@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
	private BigDecimal valorDelProcedimiento;

	@Stereotype("FECHAHORA")
	private Date fechaDeNacimiento;
	
	@Column(length=20)
	private String edadGet;
	
	@Column(length=20)
	private String peso;
	
	private Sexo sexo;
	public enum Sexo{Masculino, Femenino}

	private ControlPrenatal controlPrenatal;
	public enum ControlPrenatal{Uno,Dos};
	
	@ManyToOne
	private Diagnostico diagnosticoRecienNacido;
	 
	@Stereotype("FECHAHORA")
	private Date fechaDeMuerte;
	
	@Column(length=20)
	private String causaBasicaDeMuerte;
	
	@ManyToOne
	@Required
	private Prefactura prefactura; 

	public String getOico() {
		return oico;
	}

	public void setOico(String oico) {
		this.oico = oico;
	}

	public Procedimientos getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimientos procedimiento) {
		this.procedimiento = procedimiento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValorDelProcedimiento() {
		return valorDelProcedimiento;
	}

	public void setValorDelProcedimiento(BigDecimal valorDelProcedimiento) {
		this.valorDelProcedimiento = valorDelProcedimiento;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getEdadGet() {
		return edadGet;
	}

	public void setEdadGet(String edadGet) {
		this.edadGet = edadGet;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	
	public ControlPrenatal getControlPrenatal() {
		return controlPrenatal;
	}

	public void setControlPrenatal(ControlPrenatal controlPrenatal) {
		this.controlPrenatal = controlPrenatal;
	}

	public Diagnostico getDiagnosticoRecienNacido() {
		return diagnosticoRecienNacido;
	}

	public void setDiagnosticoRecienNacido(Diagnostico diagnosticoRecienNacido) {
		this.diagnosticoRecienNacido = diagnosticoRecienNacido;
	}

	public Date getFechaDeMuerte() {
		return fechaDeMuerte;
	}

	public void setFechaDeMuerte(Date fechaDeMuerte) {
		this.fechaDeMuerte = fechaDeMuerte;
	}

	public String getCausaBasicaDeMuerte() {
		return causaBasicaDeMuerte;
	}

	public void setCausaBasicaDeMuerte(String causaBasicaDeMuerte) {
		this.causaBasicaDeMuerte = causaBasicaDeMuerte;
	}

	public Prefactura getPrefactura() {
		return prefactura;
	}

	public void setPrefactura(Prefactura prefactura) {
		this.prefactura = prefactura;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
}
