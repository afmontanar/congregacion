package org.adicnet.contrato.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
public class TipoDeContrato {
	   
		
		@Id
		@Hidden // La propiedad no se muestra al usuario. Es un identificador interno
		@GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
		@GenericGenerator(name="system-uuid", strategy = "uuid")
		@Column(length=32)
		private String tid;
		
		public String getTid() {
			return tid;
		}

		public void setTid(String tid) {
			this.tid = tid;
		}

		@Column(length=50)  // La longitud de columna se usa a nivel UI y a nivel DB
		private String descripcion;
		
		@Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
		private String detalle;

			   
	
		public String getDetalle() {
			return detalle;
		}

		public void setDetalle(String detalle) {
			this.detalle = detalle;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

	  
}
