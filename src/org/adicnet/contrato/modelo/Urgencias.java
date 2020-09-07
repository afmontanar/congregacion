package org.adicnet.contrato.modelo;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.adicnet.contrato.modelo.Hospitalizacion.*;
import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
public class Urgencias {
	@Id
	@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
	@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String oico;
	
	@Stereotype("FECHAHORA")
	private Date fechaDeIngreso;
	
	private CausaExterna causaExterna;
	public enum CausaExterna {AccidenteDeTrabajo, AccidenteDeTrancito, AccidenteRabico,
		AccidenteOfilico, OtroTipoDeAccidente, EventoCatastrofico, LesionPorAgrecion,
		LesionAutoInfligida,SospechaDeMaltratoFisico,SospechaDeAbusoSexual,SospechaDeViolenciasexual,
		SospechaDeMaltratoEmocional, EnfermedadGeneral,EnfermedadProfecional, Otra}
	
	@ManyToOne
	private Diagnostico diagnosticoSalida;
	
	@ManyToOne
	private Diagnostico diagnostico1;
	
	@ManyToOne
	private Diagnostico diagnostico2;
	
	@ManyToOne
	private Diagnostico diagnostico3;
	
	@ManyToOne
	private Diagnostico diagnosticoMuerte;
	
	@Column(length=100)
	private String estadoDeSalida;
	
	@Column(length=100)
	private String identificadorDeUrgencia;
	
	@ManyToOne
	@Required
	private Prefactura prefactura; 


	public String getOico() {
		return oico;
	}

	public void setOico(String oico) {
		this.oico = oico;
	}

	public Date getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(Date fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public CausaExterna getCausaExterna() {
		return causaExterna;
	}

	public void setCausaExterna(CausaExterna causaExterna) {
		this.causaExterna = causaExterna;
	}

	public Diagnostico getDiagnosticoSalida() {
		return diagnosticoSalida;
	}

	public void setDiagnosticoSalida(Diagnostico diagnosticoSalida) {
		this.diagnosticoSalida = diagnosticoSalida;
	}

	public Diagnostico getDiagnostico1() {
		return diagnostico1;
	}

	public void setDiagnostico1(Diagnostico diagnostico1) {
		this.diagnostico1 = diagnostico1;
	}

	public Diagnostico getDiagnostico2() {
		return diagnostico2;
	}

	public void setDiagnostico2(Diagnostico diagnostico2) {
		this.diagnostico2 = diagnostico2;
	}

	public Diagnostico getDiagnostico3() {
		return diagnostico3;
	}

	public void setDiagnostico3(Diagnostico diagnostico3) {
		this.diagnostico3 = diagnostico3;
	}

	public Diagnostico getDiagnosticoMuerte() {
		return diagnosticoMuerte;
	}

	public void setDiagnosticoMuerte(Diagnostico diagnosticoMuerte) {
		this.diagnosticoMuerte = diagnosticoMuerte;
	}

	public String getEstadoDeSalida() {
		return estadoDeSalida;
	}

	public void setEstadoDeSalida(String estadoDeSalida) {
		this.estadoDeSalida = estadoDeSalida;
	}

	public String getIdentificadorDeUrgencia() {
		return identificadorDeUrgencia;
	}

	public void setIdentificadorDeUrgencia(String identificadorDeUrgencia) {
		this.identificadorDeUrgencia = identificadorDeUrgencia;
	}

	public Prefactura getPrefactura() {
		return prefactura;
	}

	public void setPrefactura(Prefactura prefactura) {
		this.prefactura = prefactura;
	}
	
	
	
}
