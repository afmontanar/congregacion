package org.adicnet.contrato.modelo;

import org.openxava.actions.*;
import org.openxava.util.*;
import org.openxava.validators.*;

import java.util.Date;

public class CalcularEdad extends OnChangePropertyBaseAction {
	

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		try{
		 Date fn=(Date) getView().getValue("fechaDeNacimiento");
		 Date hoy = new Date();
		 int año = hoy.getYear() - fn.getYear();
		 año-=1;
		 if(hoy.getMonth()>=fn.getMonth() && hoy.getDay()>=fn.getDay()){
		 	 año+=1;
		 }
		 if(año<0){
			
			 getView().setValue("edad", 0); // 3
		 }else{
			
		 getView().setValue("edad", año); // 3
		 }
		}catch (Exception e){
			
		}
		 
	}
	
	
	


}
