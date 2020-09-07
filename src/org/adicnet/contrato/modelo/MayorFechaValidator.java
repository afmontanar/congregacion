package org.adicnet.contrato.modelo; // En el paquete 'validators'


import java.util.*;

import org.openxava.util.*;
import org.openxava.validators.*;
public class MayorFechaValidator
implements IValidator { // Ha de implementar IValidator
	 
	 private Date fechaInicial;   
	 private Date fechaFinal;
	    
public void validate(Messages errors) // La lógica de validación
throws Exception
{

if (getFechaFinal() == null) return;
if (getFechaInicial() == null) return;
if (!(getFechaFinal() instanceof Date)) {
	errors.add( // Al añadir mensajes a errors la validación fallará
			"No es del tipo Date"); // Argumentos para el mensaje
return;
}

if (!(getFechaFinal() instanceof Date)) {
	errors.add( // Al añadir mensajes a errors la validación fallará
			"No es del tipo Date"); // Argumentos para el mensaje
return;
} 

if (!getFechaFinal().after(getFechaInicial())) {
	errors.add("La fecha inicial es mayor o igual a la final"); // Id de mensaje en el archivo i18n 
	}

}
// Getters y setters para year, number, delivered y invoice

public Date getFechaInicial() {
	return fechaInicial;
}

public void setFechaInicial(Date fechaInicial) {
	this.fechaInicial = fechaInicial;
}

public Date getFechaFinal() {
	return fechaFinal;
}

public void setFechaFinal(Date fechaFinal) {
	this.fechaFinal = fechaFinal;
}

}
