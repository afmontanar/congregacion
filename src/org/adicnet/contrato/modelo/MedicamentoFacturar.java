package org.adicnet.contrato.modelo;

import java.math.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
public class MedicamentoFacturar {

	@Id
	@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
	@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String oico;
	
	private TipoDeMedicamento tipoDeMedicamento; 
	public enum TipoDeMedicamento{MedicamentoPos,MedicamentoNoPos}
	
    @ManyToOne
    private Medicamento medicamento;
    
    private int numeroDeUnidades;
    
    @Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
	private BigDecimal valorUnitarioDelMedicamento;
    
    @Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
	private BigDecimal cuotaModeradora;
    
    @ManyToOne
	@Required
	private Prefactura prefactura; 


	public String getOico() {
		return oico;
	}

	public void setOico(String oico) {
		this.oico = oico;
	}

	public TipoDeMedicamento getTipoDeMedicamento() {
		return tipoDeMedicamento;
	}

	public void setTipoDeMedicamento(TipoDeMedicamento tipoDeMedicamento) {
		this.tipoDeMedicamento = tipoDeMedicamento;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public int getNumeroDeUnidades() {
		return numeroDeUnidades;
	}

	public void setNumeroDeUnidades(int numeroDeUnidades) {
		this.numeroDeUnidades = numeroDeUnidades;
	}

	public BigDecimal getValorUnitarioDelMedicamento() {
		return valorUnitarioDelMedicamento;
	}

	public void setValorUnitarioDelMedicamento(BigDecimal valorUnitarioDelMedicamento) {
		this.valorUnitarioDelMedicamento = valorUnitarioDelMedicamento;
	}

	public BigDecimal getCuotaModeradora() {
		return cuotaModeradora;
	}

	public void setCuotaModeradora(BigDecimal cuotaModeradora) {
		this.cuotaModeradora = cuotaModeradora;
	}

	public Prefactura getPrefactura() {
		return prefactura;
	}

	public void setPrefactura(Prefactura prefactura) {
		this.prefactura = prefactura;
	}

}
