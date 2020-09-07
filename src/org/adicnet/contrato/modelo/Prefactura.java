package org.adicnet.contrato.modelo;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

@Entity
//@Table(name="prefactura", schema="public")
//@SecondaryTable(name="prefacturadetalle", schema="public", pkJoinColumns=@PrimaryKeyJoinColumn(name="numerob"))
public class Prefactura {
	
	@Id
	@Hidden // La propiedad no se muestra al usuario. Es un identificador interno -- 402881865633089e015633679e7a0000
	@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	private String prid;
	
	
	@ManyToOne		
	private Paciente paciente; // Una referencia Java convencional

	//@Column(name="description", table="prefactura", length=10)	
	@Column(length=10)
	private String description;

	private Date fechaDePrefactura;
	
	@Column(length=10)
	private String autorizacion;
	
	@OneToMany( // Para declararla como una colección persistente
			mappedBy="prefactura", // El miembro de Detail que almacena la relación
			cascade=CascadeType.ALL) // Indica que es una colección de entidades dependientes
	 //@SaveAction("controllerConsulta.save")
			private Collection<Consulta> consultas = new ArrayList<Consulta>();
	
	@OneToMany( // Para declararla como una colección persistente
			mappedBy="prefactura", // El miembro de Detail que almacena la relación
			cascade=CascadeType.ALL) // Indica que es una colección de entidades dependientes
			private Collection<Procedimiento> procedimientos = new ArrayList<Procedimiento>();
	
	@OneToMany( // Para declararla como una colección persistente
			mappedBy="prefactura", // El miembro de Detail que almacena la relación
			cascade=CascadeType.ALL) // Indica que es una colección de entidades dependientes
			private Collection<Hospitalizacion> hospitalizacion = new ArrayList<Hospitalizacion>();
	
	@OneToMany( // Para declararla como una colección persistente
			mappedBy="prefactura", // El miembro de Detail que almacena la relación
			cascade=CascadeType.ALL) // Indica que es una colección de entidades dependientes
			private Collection<Urgencias> urgencias = new ArrayList<Urgencias>();
	
	@OneToMany( // Para declararla como una colección persistente
			mappedBy="prefactura", // El miembro de Detail que almacena la relación
			cascade=CascadeType.ALL) // Indica que es una colección de entidades dependientes
			private Collection<Nacidos> nacidos = new ArrayList<Nacidos>();
	
	@OneToMany( // Para declararla como una colección persistente
			mappedBy="prefactura", // El miembro de Detail que almacena la relación
			cascade=CascadeType.ALL) // Indica que es una colección de entidades dependientes 
			private Collection<MedicamentoFacturar> medicamentos = new ArrayList<MedicamentoFacturar>();
	
	@OneToMany( // Para declararla como una colección persistente
			mappedBy="prefactura", // El miembro de Detail que almacena la relación
			cascade=CascadeType.ALL) // Indica que es una colección de entidades dependientes 
			private Collection<OtroServicio> otroServicio = new ArrayList<OtroServicio>();
		
	public Prefactura() {
		super();
	}

	public Prefactura(String prid) {
		super();
		this.prid = prid;
	}

	public String getPrid() {
		return prid;
	}

	public void setPrid(String prid) {
		this.prid = prid;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Date getFechaDePrefactura() {
		return fechaDePrefactura;
	}

	public void setFechaDePrefactura(Date fechaDePrefactura) {
		this.fechaDePrefactura = fechaDePrefactura;
	}

	public String getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	public Collection<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(Collection<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Collection<Procedimiento> getProcedimientos() {
		return procedimientos;
	}

	public void setProcedimientos(Collection<Procedimiento> procedimientos) {
		this.procedimientos = procedimientos;
	}

	public Collection<Hospitalizacion> getHospitalizacion() {
		return hospitalizacion;
	}

	public void setHospitalizacion(Collection<Hospitalizacion> hospitalizacion) {
		this.hospitalizacion = hospitalizacion;
	}

	public Collection<Urgencias> getUrgencias() {
		return urgencias;
	}

	public void setUrgencias(Collection<Urgencias> urgencias) {
		this.urgencias = urgencias;
	}

	public Collection<Nacidos> getNacidos() {
		return nacidos;
	}

	public void setNacidos(Collection<Nacidos> nacidos) {
		this.nacidos = nacidos;
	}

	public Collection<MedicamentoFacturar> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(Collection<MedicamentoFacturar> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Collection<OtroServicio> getOtroServicio() {
		return otroServicio;
	}

	public void setOtroServicio(Collection<OtroServicio> otroServicio) {
		this.otroServicio = otroServicio;
	}

	 @Stereotype("MONEY") 
	 @Depends("consultas")
	 public BigDecimal getTotal(){
		 BigDecimal total = new BigDecimal("2");
	 		//for(int i=0; this.consultas.size()>i; i++){
	 		//Map treos = (Map) purien.get(i);
	 		//total = total.add(new BigDecimal(treos.get("totalConsulta")+"")); 	
	 		//}
		 	
		 	Iterator<Consulta> it = this.getConsultas().iterator();
			while(it.hasNext())
			{
				Consulta i = it.next();
				total = total.add(i.getTotalConsulta());
			}
	 		//getView().setValue("total", total);
	 		//}catch(org.openxava.util.ElementNotFoundException r){
	 		//	System.out.println("ocurre error");
	 		//}
		 return total;
	 	}
	
}
// primary table
/*
-- Table: public.prefactura

-- DROP TABLE public.prefactura;

CREATE TABLE public.prefactura
(
  prid character varying(32) NOT NULL,
  description character varying(10),
  paciente_numeroid integer,
  valormensual numeric(19,2),
  total numeric(19,2),
  CONSTRAINT prefactura_pkey PRIMARY KEY (prid),
  CONSTRAINT fk_1xkrgboeag0x4ym0sm46wstk3 FOREIGN KEY (paciente_numeroid)
      REFERENCES public.paciente (numeroid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.prefactura
  OWNER TO postgres;
*/

//secondary table

/*
-- Table: public.prefacturadetalle

-- DROP TABLE public.prefacturadetalle;

CREATE TABLE public.prefacturadetalle
(
  numeroid integer NOT NULL,
  prefactura_prid character varying(32),
  autorizacion character varying(10),
  CONSTRAINT prefacturadetalle_pkey PRIMARY KEY (numeroid),
  CONSTRAINT fk_q2a3l2afdxloo9stgra9g2jy2 FOREIGN KEY (prefactura_prid)
      REFERENCES public.prefactura (prid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.prefacturadetalle
  OWNER TO postgres;
*/