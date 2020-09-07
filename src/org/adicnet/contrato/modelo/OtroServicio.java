package org.adicnet.contrato.modelo;

import java.math.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
public class OtroServicio {
	
	@Id
	@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
	@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String oico;
	
	private Traslado traslado;
	public enum Traslado{MaterialesInsumos,Traslados,Estancias,Honorarios}
	
	@ManyToOne
	private Servicio servicio;
	
	@ManyToOne
	private InsumosMedicos insumosMedicos;
	
	private int cantidad;
	
	@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
	private BigDecimal valorUnitarioDelMdicamento;

	@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
	private BigDecimal cuotaModeradora;
	
	@ManyToOne
	@Required
	private Prefactura prefactura; 


	public Traslado getTraslado() {
		return traslado;
	}

	public void setTraslado(Traslado traslado) {
		this.traslado = traslado;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public InsumosMedicos getInsumosMedicos() {
		return insumosMedicos;
	}

	public void setInsumosMedicos(InsumosMedicos insumosMedicos) {
		this.insumosMedicos = insumosMedicos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValorUnitarioDelMdicamento() {
		return valorUnitarioDelMdicamento;
	}

	public void setValorUnitarioDelMdicamento(BigDecimal valorUnitarioDelMdicamento) {
		this.valorUnitarioDelMdicamento = valorUnitarioDelMdicamento;
	}

	public BigDecimal getCuotaModeradora() {
		return cuotaModeradora;
	}

	public void setCuotaModeradora(BigDecimal cuotaModeradora) {
		this.cuotaModeradora = cuotaModeradora;
	}

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
}
