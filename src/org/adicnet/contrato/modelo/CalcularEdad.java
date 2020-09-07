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
		 int a�o = hoy.getYear() - fn.getYear();
		 a�o-=1;
		 if(hoy.getMonth()>=fn.getMonth() && hoy.getDay()>=fn.getDay()){
		 	 a�o+=1;
		 }
		 if(a�o<0){
			
			 getView().setValue("edad", 0); // 3
		 }else{
			
		 getView().setValue("edad", a�o); // 3
		 }
		}catch (Exception e){
			
		}
		 
	}
	
	
	


}
