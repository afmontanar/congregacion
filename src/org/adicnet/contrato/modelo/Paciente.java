package org.adicnet.contrato.modelo;


import java.util.*;

import javax.persistence.*;


import org.openxava.annotations.*;

@Entity
@View(members="numeroId;primerNombre;segundoNombre;primerApellido;segundoApellido;entidadPrestadora;contrato;direccion;barrio;telefono;celular;email;sex;estadoCivil;estrato;zonaDeResidenciaHabitual;"
		+ "ocupacion;fechaDeNacimiento;fechaDeCreacion;discapacidad;photo;departamento;municipio;unidadDeMedidaDeEdad;tipoDeAfiliado;numeroDeAfiliado;"
		+ "numeroDeHospital;numeroDeCarnet;nombreDelPadre;fechaDeActualizacion;nombreDeLaMadre,edad")
public class Paciente {
	
// Datos de pacientes -------------------------------------------------------------------------------------------------------------
	
	@Id
	@Column(length=32)
	private int numeroId;
	
	@Column(length=20)
	private String primerNombre;
	
	@Column(length=20)
	private String segundoNombre;
	
	@Column(length=20)
	private String primerApellido;
	
	@Column(length=20)
	private String segundoApellido;
	
	@ManyToOne( // La referencia se almacena como una relación en la base de datos
	    	fetch=FetchType.LAZY // La referencia se carga bajo demanda
	    	) // La referencia puede estar sin valor
	    	@DescriptionsList(
	    			  descriptionProperties="codigo, description")   // Así la referencia se visualiza usando un combo
	    	private EntidadPrestadora entidadPrestadora; // Una referencia Java convencional
	
		@ManyToOne
		private Contrato contrato; // Una referencia Java convencional
	
	// Registro de pacientes -------------------------------------------------------------------------------------------------------------
	
		@Column(length=20)
		private String direccion;
		
		@Column(length=20)
		private String barrio;
		
		@Stereotype("TELEPHONE")
		private String telefono;

		@Stereotype("TELEPHONE")
		private String celular;
		
		@Stereotype("EMAIL")  // La longitud de columna se usa a nivel UI y a nivel DB
		private String email;

		private Sex sex;
		public enum Sex { HOMBRE, MUJER, TRANSEXUAL }
		
		private EstadoCivil estadoCivil; 
		public enum EstadoCivil { Soltero, Casado, Divorciado, Viudo, Separado, UnionLibre }
		
		private Estrato estrato; 
		public enum Estrato { uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez }
		
		private ZonaDeResidenciaHabitual zonaDeResidenciaHabitual; 
		public enum ZonaDeResidenciaHabitual {Urbana, Rural}
		
		@Column(length=50)
		private String ocupacion;
		
		/*
		@OnChange(CalcularEdad.class)
		@PropertyValidator(valFechNacim.class)
		*/
		@Required 
		private Date fechaDeNacimiento;
			
		private Date fechaDeCreacion;
		
		private Discapacidad discapacidad; 
		public enum Discapacidad { Autismo,  DeficienciaAuditivaSordera,  IntellectualDisability,  DiscapacidadIntelectual, DificultadesDelAprendizaje, EnfermedadesMentales,  DiscapacidadFísica, TrastornosDelHablaYDelLenguaje,  DeficienciaVisualYCeguera}
		
		@Stereotype("PHOTO") 
		private byte[] photo;
		
		@ManyToOne( // La referencia se almacena como una relación en la base de datos
		    	fetch=FetchType.LAZY // La referencia se carga bajo demanda
		    	) // La referencia puede estar sin valor
		    	@DescriptionsList(orderByKey=true) // Así la referencia se visualiza usando un combo
		    	private Departamento departamento; // Una referencia Java convencional

		
		@ManyToOne(fetch=FetchType.LAZY) @NoCreate // 2
		@DescriptionsList(
		 descriptionProperties="descripcion", // 3
		 depends="this.departamento", // 4
		 condition="${departamento.description} = ?", // 5
		 order="${descripcion} desc" // 6
		 )
		private Municipio municipio;
		
		private UnidadDeMedidaDeEdad unidadDeMedidaDeEdad; 
		public enum UnidadDeMedidaDeEdad {uno, dos, tres}
		
		// afiliacion -------------------------------------------------------------------------------------------------------------
		
		private TipoDeAfiliado tipoDeAfiliado;
		public enum TipoDeAfiliado { Cotizantes, Bancario, Adicional}
		
		@Column(length=20)
		private String numeroDeAfiliado;
		
		
		@Column(length=20)
		private String numeroDeHospital;
		

		@Column(length=100)
		private String numeroDeCarnet;
		
		@Column(length=100)
		private String nombreDelPadre;
		
		private Date fechaDeActualizacion;
		
		
		
		@Column(length=20)
		private String nombreDeLaMadre;


// generar metodos get y set -----------------------------------------------------------------------------------	


	public int getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(int numeroId) {
		this.numeroId = numeroId;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public EntidadPrestadora getEntidadPrestadora() {
		return entidadPrestadora;
	}

	public void setEntidadPrestadora(EntidadPrestadora entidadPrestadora) {
		this.entidadPrestadora = entidadPrestadora;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Estrato getEstrato() {
		return estrato;
	}

	public void setEstrato(Estrato estrato) {
		this.estrato = estrato;
	}

	public ZonaDeResidenciaHabitual getZonaDeResidenciaHabitual() {
		return zonaDeResidenciaHabitual;
	}

	public void setZonaDeResidenciaHabitual(ZonaDeResidenciaHabitual zonaDeResidenciaHabitual) {
		this.zonaDeResidenciaHabitual = zonaDeResidenciaHabitual;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	@Depends("fechaDeNacimiento")
	public int getEdad() {
		try{
			 Date fn=(Date) this.fechaDeNacimiento;
			 Date hoy = new Date();
			 int año = hoy.getYear() - fn.getYear();
			 año-=1;
			 if(hoy.getMonth()>=fn.getMonth() && hoy.getDay()>=fn.getDay()){
			 	 año+=1;
			 }
			 if(año<0){
				
				 return 0; // 3
			 }else{
				
			 return año; // 3
			 }
			}catch (Exception e){
				return 0;
			}
			 
	
	}

	

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public Discapacidad getDiscapacidad() {
		return discapacidad;
	}

	public void setDiscapacidad(Discapacidad discapacidad) {
		this.discapacidad = discapacidad;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public UnidadDeMedidaDeEdad getUnidadDeMedidaDeEdad() {
		return unidadDeMedidaDeEdad;
	}

	public void setUnidadDeMedidaDeEdad(UnidadDeMedidaDeEdad unidadDeMedidaDeEdad) {
		this.unidadDeMedidaDeEdad = unidadDeMedidaDeEdad;
	}

	public TipoDeAfiliado getTipoDeAfiliado() {
		return tipoDeAfiliado;
	}

	public void setTipoDeAfiliado(TipoDeAfiliado tipoDeAfiliado) {
		this.tipoDeAfiliado = tipoDeAfiliado;
	}

	public String getNumeroDeAfiliado() {
		return numeroDeAfiliado;
	}

	public void setNumeroDeAfiliado(String numeroDeAfiliado) {
		this.numeroDeAfiliado = numeroDeAfiliado;
	}

	public String getNumeroDeHospital() {
		return numeroDeHospital;
	}

	public void setNumeroDeHospital(String numeroDeHospital) {
		this.numeroDeHospital = numeroDeHospital;
	}

	public String getNumeroDeCarnet() {
		return numeroDeCarnet;
	}

	public void setNumeroDeCarnet(String numeroDeCarnet) {
		this.numeroDeCarnet = numeroDeCarnet;
	}

	public String getNombreDelPadre() {
		return nombreDelPadre;
	}

	public void setNombreDelPadre(String nombreDelPadre) {
		this.nombreDelPadre = nombreDelPadre;
	}

	public Date getFechaDeActualizacion() {
		return fechaDeActualizacion;
	}

	public void setFechaDeActualizacion(Date fechaDeActualizacion) {
		this.fechaDeActualizacion = fechaDeActualizacion;
	}

	public String getNombreDeLaMadre() {
		return nombreDeLaMadre;
	}

	public void setNombreDeLaMadre(String nombreDeLaMadre) {
		this.nombreDeLaMadre = nombreDeLaMadre;
	}


	
}
