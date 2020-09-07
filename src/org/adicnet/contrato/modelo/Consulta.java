package org.adicnet.contrato.modelo;


import java.math.*;

import javax.persistence.*;

import org.adicnet.contrato.soat.*;
import org.apache.commons.beanutils.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.jpa.*;


@Entity
public class Consulta{
	
	@Id
	@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
	@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String oico;
	
	@ManyToOne
	@Required
	private Prefactura prefactura; 

	@ManyToOne
	private Procedimientos procedimiento;
	
	private Finalidad finalidad;
	public enum Finalidad {Diagnostico, Terapéutico, ProtecciónEspecifica,
		DetecciónTempranaEnfermedadGeneral, DetecciónTempranaDeEnfermedadProfesional}
	
	/*
	 {"01", "Accidente de trabajo"},
     {"02", "Accidente de trancito"},
     {"03 ", "Accidente rabico"},
     {"04", "Accidente ofilico"},
     {"05", "Otro tipo de accidente"},
     {"06", "Evento catastrofico"},
     {"07 ", "Lesion por agrecion"},
     {"08", "Lesion auto infligida"},
     {"09", "Sospecha de maltrato fisico"},
     {"10", "Sospecha de abuso sexual"},
     {"11", "Sospecha de violencia sexual"},
     {"12", "Sospecha de maltroto emocional"},
     {"13", "Enfermedad general"},
     {"14", " Enfermedad profecional"},
     {"15 ", "Otra"}
     */
	private CausaExterna causaExterna;
	public enum CausaExterna {AccidenteDeTrabajo,
		AccidenteDeTrancito,
		AccidenteRabico,
		AccidenteOfilico,
		OtroTipoDeAccidente,
		EventoCatastrofico,
		LesionPorAgrecion,
		LesionAutoInfligida,
		SospechaDeMaltratoFisico,
		SospechaDeAbusoSexual,
		SospechaDeViolenciasexual,
		SospechaDeMaltratoEmocional,
		EnfermedadGeneral,
		EnfermedadProfecional,
		Otra}
	
	private boolean pyp;
	
	@ManyToOne
	private Diagnostico diagnostico1;
	
	@ManyToOne
	private Diagnostico diagnostico2;
	
	@ManyToOne
	private Diagnostico diagnostico3;
	
	@ManyToOne
	private Diagnostico diagnostico4;
	
	private TipoDeDiagnostico tipoDeDiagnostico;
	public enum TipoDeDiagnostico {ImpresionDiagnostica,ConfirmandoNuevo, ConfirmandoRepetido}
	
	@Required
	@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
    private BigDecimal cuotaModeradora;
	
	@Required
	@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
    private BigDecimal valorDeLaConsulta;
	
	public String getOico() {
		return oico;
	}

	public void setOico(String oico) {
		this.oico = oico;
	}
	
	public Prefactura getPrefactura() {
		return prefactura;
	}

	public void setPrefactura(Prefactura prefactura) {
		this.prefactura = prefactura;
	}

	public Finalidad getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(Finalidad finalidad) {
		this.finalidad = finalidad;
	}

	public CausaExterna getCausaExterna() {
		return causaExterna;
	}

	public void setCausaExterna(CausaExterna causaExterna) {
		this.causaExterna = causaExterna;
	}

	public Procedimientos getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimientos procedimiento) {
		this.procedimiento = procedimiento;
	}

	
	public boolean isPyp() {
		return pyp;
	}

	public void setPyp(boolean pyp) {
		this.pyp = pyp;
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


	public Diagnostico getDiagnostico4() {
		return diagnostico4;
	}


	public void setDiagnostico4(Diagnostico diagnostico4) {
		this.diagnostico4 = diagnostico4;
	}

	public TipoDeDiagnostico getTipoDeDiagnostico() {
		return tipoDeDiagnostico;
	}

	public void setTipoDeDiagnostico(TipoDeDiagnostico tipoDeDiagnostico) {
		this.tipoDeDiagnostico = tipoDeDiagnostico;
	}

	public BigDecimal getCuotaModeradora() {
		return cuotaModeradora;
	}

	public void setCuotaModeradora(BigDecimal cuotaModeradora) {
		this.cuotaModeradora = cuotaModeradora;
	}

	public BigDecimal getValorDeLaConsulta() {
		return valorDeLaConsulta;
	}

	public void setValorDeLaConsulta(BigDecimal valorDeLaConsulta) {
		this.valorDeLaConsulta = valorDeLaConsulta;
	}
	
	@Depends("valorDeLaConsulta, cuotaModeradora")
	public BigDecimal getTotalConsulta(){
		if(this.cuotaModeradora!=null && this.valorDeLaConsulta!=null ){
			return (this.valorDeLaConsulta.add(cuotaModeradora));
		}
		if(this.cuotaModeradora==null && this.valorDeLaConsulta!=null ){
			return (this.valorDeLaConsulta);
		}
		return null;
	}
	
	
	
}
