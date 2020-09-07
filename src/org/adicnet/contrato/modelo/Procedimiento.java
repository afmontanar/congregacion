package org.adicnet.contrato.modelo;

import java.math.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.adicnet.contrato.modelo.Consulta.*;
import org.adicnet.contrato.soat.*;
import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
public class Procedimiento {
	
	@Id
	@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
	@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String oico;
	
	@ManyToOne
	private Procedimientos procedimiento;
	
	@ManyToOne
	@Required
	private Prefactura prefactura; 
	
	
	private int cantidad;
	
	private boolean pyp;

	private Finalidad finalidad;
	public enum Finalidad {Diagnostico, Terapéutico, ProtecciónEspecifica,
		DetecciónTempranaEnfermedadGeneral, DetecciónTempranaDeEnfermedadProfesional}
	
	private AmbitoDelProcedimiento ambitoDelProcedimiento;
	public enum AmbitoDelProcedimiento{Diagnostico, Terapéutico, ProtecciónEspecifica,
		DetecciónTempranaEnfermedadGeneral, DetecciónTempranaDeEnfermedadProfesional}
	
	@ManyToOne
	private Diagnostico diagnostico1;
	
	@ManyToOne
	private Diagnostico diagnostico2;
	
	@ManyToOne
	private Diagnostico diagnostico3;
	
	@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
    private BigDecimal cuotaModeradora;
	
	private PersonaQueAtiende personaQueAtiende;
	public enum PersonaQueAtiende{MedicoEspecialista, MedicoGeneral, Enfermera,
		AuxiliarDeEnfermera, Otro}
	
	private FormaDeRealizacion formaDeRealizacion;
	public enum FormaDeRealizacion{UnicoUnilateral, MultipleOBilateralMismaViaDiferenteEspecializadad, MultipleOBilateralMismaViaIgualEspecialidad,
		MultipleOBilateralDiferenteViaDiferenteEspecialidad, MultipleOBilateralDiferenteViaIgualEspecialidad}
	
	@Column(length=500)
	private String complicacion;
	
	@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
    private BigDecimal valorDeProcedimiento;

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

	public Prefactura getPrefactura() {
		return prefactura;
	}

	public void setPrefactura(Prefactura prefactura) {
		this.prefactura = prefactura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isPyp() {
		return pyp;
	}

	public void setPyp(boolean pyp) {
		this.pyp = pyp;
	}

	public Finalidad getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(Finalidad finalidad) {
		this.finalidad = finalidad;
	}

	public AmbitoDelProcedimiento getAmbitoDelProcedimiento() {
		return ambitoDelProcedimiento;
	}

	public void setAmbitoDelProcedimiento(AmbitoDelProcedimiento ambitoDelProcedimiento) {
		this.ambitoDelProcedimiento = ambitoDelProcedimiento;
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

	public BigDecimal getCuotaModeradora() {
		return cuotaModeradora;
	}

	public void setCuotaModeradora(BigDecimal cuotaModeradora) {
		this.cuotaModeradora = cuotaModeradora;
	}

	public PersonaQueAtiende getPersonaQueAtiende() {
		return personaQueAtiende;
	}

	public void setPersonaQueAtiende(PersonaQueAtiende personaQueAtiende) {
		this.personaQueAtiende = personaQueAtiende;
	}

	public FormaDeRealizacion getFormaDeRealizacion() {
		return formaDeRealizacion;
	}

	public void setFormaDeRealizacion(FormaDeRealizacion formaDeRealizacion) {
		this.formaDeRealizacion = formaDeRealizacion;
	}

	public String getComplicacion() {
		return complicacion;
	}

	public void setComplicacion(String complicacion) {
		this.complicacion = complicacion;
	}

	public BigDecimal getValorDeProcedimiento() {
		return valorDeProcedimiento;
	}

	public void setValorDeProcedimiento(BigDecimal valorDeProcedimiento) {
		this.valorDeProcedimiento = valorDeProcedimiento;
	}
 
	@Depends("valorDeProcedimiento, cuotaModeradora, cantidad")
	public BigDecimal getTotalProcedimiento(){
		BigDecimal canti = new BigDecimal(this.cantidad);
		
		if(this.cuotaModeradora!=null && this.valorDeProcedimiento!=null && canti!=null){
			BigDecimal tolotely = this.valorDeProcedimiento.multiply(canti);
			BigDecimal finately = tolotely.add(this.cuotaModeradora);
			return finately;
		}
		
		if(this.cuotaModeradora!=null && this.valorDeProcedimiento!=null && canti==null){
			return null;
		}
		
		if(this.cuotaModeradora!=null && this.valorDeProcedimiento==null && canti==null){
			
			return null;
			
		}
		
		if(this.cuotaModeradora!=null && this.valorDeProcedimiento!=null && canti!=null){
			BigDecimal tolotely = this.valorDeProcedimiento.multiply(canti);
			return tolotely;
		}
		return null;
	}

	
		
	
	
}
