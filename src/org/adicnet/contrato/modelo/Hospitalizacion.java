package org.adicnet.contrato.modelo;

import java.math.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.adicnet.contrato.modelo.Consulta.*;
import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
public class Hospitalizacion {
	@Id
	@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
	@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String oico;
	
	@ManyToOne
	private ViaIngreso viaIngreo;
	
	@Stereotype("FECHAHORA")
	private Date fechaDeIngreso;
	
	private CausaExterna causaExterna;
	public enum CausaExterna {AccidenteDeTrabajo, AccidenteDeTrancito, AccidenteRabico,
		AccidenteOfilico, OtroTipoDeAccidente, EventoCatastrofico, LesionPorAgrecion,
		LesionAutoInfligida,SospechaDeMaltratoFisico,SospechaDeAbusoSexual,SospechaDeViolenciasexual,
		SospechaDeMaltratoEmocional, EnfermedadGeneral,EnfermedadProfecional, Otra}
	
	@ManyToOne
	private Diagnostico diagnosticoIngreso;
	
	@ManyToOne
	private Diagnostico diagnosticoEgreso;
	
	@ManyToOne
	private Diagnostico diagnosticoPrincipal;
	
	@ManyToOne
	private Diagnostico diagnostico1;
	
	@ManyToOne
	private Diagnostico diagnostico2;
	
	@ManyToOne
	private Diagnostico diagnostico3;

	@ManyToOne
	private Diagnostico diagnosticoComplicado;
	
	@ManyToOne
	private Diagnostico diagnosticoMuerte;

	@Column(length=100)
	private String estadoDeSalida;
	
	@Stereotype("FECHAHORA")
	private Date fechaDeSalida;
	
	@Column(length=100)
	private String identificadorHospital;
	
    @Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
	private BigDecimal valorNetoPagar;
    
    @ManyToOne
	@Required
	private Prefactura prefactura; 
	
	public String getOico() {
		return oico;
	}

	public void setOico(String oico) {
		this.oico = oico;
	}

	public ViaIngreso getViaIngreo() {
		return viaIngreo;
	}

	public void setViaIngreo(ViaIngreso viaIngreo) {
		this.viaIngreo = viaIngreo;
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

	public Diagnostico getDiagnosticoIngreso() {
		return diagnosticoIngreso;
	}

	public void setDiagnosticoIngreso(Diagnostico diagnosticoIngreso) {
		this.diagnosticoIngreso = diagnosticoIngreso;
	}

	public Diagnostico getDiagnosticoEgreso() {
		return diagnosticoEgreso;
	}

	public void setDiagnosticoEgreso(Diagnostico diagnosticoEgreso) {
		this.diagnosticoEgreso = diagnosticoEgreso;
	}

	public Diagnostico getDiagnosticoPrincipal() {
		return diagnosticoPrincipal;
	}

	public void setDiagnosticoPrincipal(Diagnostico diagnosticoPrincipal) {
		this.diagnosticoPrincipal = diagnosticoPrincipal;
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

	public Diagnostico getDiagnosticoComplicado() {
		return diagnosticoComplicado;
	}

	public void setDiagnosticoComplicado(Diagnostico diagnosticoComplicado) {
		this.diagnosticoComplicado = diagnosticoComplicado;
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

	public Date getFechaDeSalida() {
		return fechaDeSalida;
	}

	public void setFechaDeSalida(Date fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}

	public String getIdentificadorHospital() {
		return identificadorHospital;
	}

	public void setIdentificadorHospital(String identificadorHospital) {
		this.identificadorHospital = identificadorHospital;
	}

	public BigDecimal getValorNetoPagar() {
		return valorNetoPagar;
	}

	public void setValorNetoPagar(BigDecimal valorNetoPagar) {
		this.valorNetoPagar = valorNetoPagar;
	}

	public Prefactura getPrefactura() {
		return prefactura;
	}

	public void setPrefactura(Prefactura prefactura) {
		this.prefactura = prefactura;
	}

	
	
	

}
