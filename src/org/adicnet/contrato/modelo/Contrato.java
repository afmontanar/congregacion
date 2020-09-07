package org.adicnet.contrato.modelo;
 
import java.math.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.adicnet.contrato.soat.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
 
@EntityValidator(
value=MayorFechaValidator.class, // Clase con la lógica de validación
properties= {
@PropertyValue(name="fechaInicial"), // El contenido de estas propiedades
@PropertyValue(name="fechaFinal"), // se mueve desde la entidad Order
}
)
@Entity
//@Table(name="contrato", schema="public")
//@SecondaryTable(name="configuracionfacturab", schema="public", pkJoinColumns=@PrimaryKeyJoinColumn(name="numerob"))
public class Contrato{
	
	@Id
    @Column(length=32)  // La longitud de columna se usa a nivel UI y a nivel DB
    private String numero;
 
    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
    @Required  // Se mostrará un error de validación si la propiedad nombre se deja en blanco
    private String nombre;
    
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
    		fetch=FetchType.LAZY, // La referencia se carga bajo demanda
    		optional=true) // La referencia puede estar sin valor
    		@DescriptionsList // Así la referencia se visualiza usando un combo
    		private ContratoPyp contratoPyp; // Una referencia Java convencional
    	
    
    public ContratoPyp getContratoPyp() {
		return contratoPyp;
	}

	public void setContratoPyp(ContratoPyp contratoPyp) {
		this.contratoPyp = contratoPyp;
	}

	@ManyToOne( // La referencia se almacena como una relación en la base de datos
    		fetch=FetchType.LAZY, // La referencia se carga bajo demanda
    		optional=true) // La referencia puede estar sin valor
    		@DescriptionsList // Así la referencia se visualiza usando un combo
    		private Tarifa tarifa; // Una referencia Java convencional
    	
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
    		fetch=FetchType.LAZY, // La referencia se carga bajo demanda
    		optional=true) // La referencia puede estar sin valor
    		@DescriptionsList // Así la referencia se visualiza usando un combo
    		private TipoDeContrato tipoDeContrato; // Una referencia Java convencional
    
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
    		fetch=FetchType.LAZY, // La referencia se carga bajo demanda
    		optional=true) // La referencia puede estar sin valor
    		@DescriptionsList // Así la referencia se visualiza usando un combo
    		private TipoDePago tipoDePago; // Una referencia Java convencional
    
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
    		fetch=FetchType.LAZY, // La referencia se carga bajo demanda
    		optional=true) // La referencia puede estar sin valor
    		@DescriptionsList // Así la referencia se visualiza usando un combo
    		private Entidad entidad; // Una referencia Java convencional
    
    
	@Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
    private BigDecimal valorMensual;
 
    @Stereotype("MONEY") // La propiedad price se usa para almacenar dinero
    private BigDecimal valorTotal;
 
    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
    private String poliza;

    
    private Date fechaInicial;
   
   
    private Date fechaFinal;
    
    /*
    @ManyToMany( // La colección es persistente (1)
			mappedBy="contrato",
	        cascade=CascadeType.REMOVE)
			private Collection<Procedimientos> procedimientos;
	*/
    
    /*
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
    		fetch=FetchType.LAZY, // La referencia se carga bajo demanda
    		optional=true) // La referencia puede estar sin valor
    		@DescriptionsList // Así la referencia se visualiza usando un combo
    		private ProcedimientosAFacturar procedimientosAFacturar; // Una referencia Java convencional
	*/
    
    public Entidad getEntidad() {
  		return entidad;
  	}

  	public void setEntidad(Entidad entidad) {
  		this.entidad = entidad;
  	}
    
	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getPoliza() {
		return poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	public TipoDePago getTipoDePago() {
		return tipoDePago;
	}

	public void setTipoDePago(TipoDePago tipoDePago) {
		this.tipoDePago = tipoDePago;
	}

	public TipoDeContrato getTipoDeContrato() {
		return tipoDeContrato;
	}

	public void setTipoDeContrato(TipoDeContrato tipoDeContrato) {
		this.tipoDeContrato = tipoDeContrato;
	}
    
    public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorMensual() {
		return valorMensual;
	}

	public void setValorMensual(BigDecimal valorMensual) {
		this.valorMensual = valorMensual;
	}
	
	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	
 
    public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombre() {
        return this.nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
	public Collection<Procedimientos> getProcedimientos() {
		return procedimientos;
	}

	public void setProcedimientos(Collection<Procedimientos> procedimientos) {
		this.procedimientos = procedimientos;
	}
     */
  
	/*
	 * -- Table: public.contrato

-- DROP TABLE public.contrato;

CREATE TABLE public.contrato
(
  numero character varying(32) NOT NULL,
  fechafinal timestamp without time zone,
  fechainicial timestamp without time zone,
  nombre character varying(50),
  poliza character varying(50),
  valormensual numeric(19,2),
  valortotal numeric(19,2),
  contratopyp_description character varying(32),
  entidad_oid character varying(32),
  tarifa_oid character varying(32),
  tipodecontrato_tid character varying(32),
  tipodepago_tid character varying(32),
  CONSTRAINT contrato_pkey PRIMARY KEY (numero),
  CONSTRAINT fk_57aqxbxmh2l07i16v2e7t95a3 FOREIGN KEY (tipodecontrato_tid)
      REFERENCES public.tipodecontrato (tid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_au0crwa6416omkoa9csvwdx8b FOREIGN KEY (tipodepago_tid)
      REFERENCES public.tipodepago (tid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_dmw3s657vt9lio786k3tl1b67 FOREIGN KEY (entidad_oid)
      REFERENCES public.entidad (oid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_e2hwer5cqyxopvovxa6666skp FOREIGN KEY (contratopyp_description)
      REFERENCES public.contratopyp (description) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_hdnfkwsdq6qbu7d3ikjhu2xgk FOREIGN KEY (tarifa_oid)
      REFERENCES public.tarifa (oid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.contrato
  OWNER TO postgres;
	 * */
	
}