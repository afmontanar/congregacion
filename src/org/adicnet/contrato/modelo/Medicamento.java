package org.adicnet.contrato.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Medicamento {

	@Id
	@Column(length=32)
	private int codigoMedicamento;
	
	@Column(length=400)
	private String descripcion;
	
	@Column(length=400)
	private String principioActivo;
	
	@Column(length=100)
	private String concentracion;
	
	@Column(length=400)
	private String formaFarmaceutica;
	
	@Column(length=400)
	private String aclaracion;
	
	@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
	private BigDecimal valorDelMedicamento;

	@Column(length=512)
	private String detalleAnexo;
	
	public int getCodigoMedicamento() {
		return codigoMedicamento;
	}

	public void setCodigoMedicamento(int codigoMedicamento) {
		this.codigoMedicamento = codigoMedicamento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrincipioActivo() {
		return principioActivo;
	}

	public void setPrincipioActivo(String principioActivo) {
		this.principioActivo = principioActivo;
	}

	public String getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public String getFormaFarmaceutica() {
		return formaFarmaceutica;
	}

	public void setFormaFarmaceutica(String formaFarmaceutica) {
		this.formaFarmaceutica = formaFarmaceutica;
	}

	public String getAclaracion() {
		return aclaracion;
	}

	public void setAclaracion(String aclaracion) {
		this.aclaracion = aclaracion;
	}

	public BigDecimal getValorDelMedicamento() {
		return valorDelMedicamento;
	}

	public void setValorDelMedicamento(BigDecimal valorDelMedicamento) {
		this.valorDelMedicamento = valorDelMedicamento;
	}

	public String getDetalleAnexo() {
		return detalleAnexo;
	}

	public void setDetalleAnexo(String detalleAnexo) {
		this.detalleAnexo = detalleAnexo;
	}
	
	
	
}
