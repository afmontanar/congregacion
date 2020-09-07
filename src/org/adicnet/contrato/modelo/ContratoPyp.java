package org.adicnet.contrato.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class ContratoPyp {
	
	@Id
    @Column(length=32)  // La longitud de columna se usa a nivel UI y a nivel DB
    private String description;
 
    @Stereotype("ARCHIVO")
    @Column(length=2000)
    private String documento;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
    

}
