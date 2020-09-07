package org.adicnet.contrato.acciones;

import java.math.*;
import java.util.*;

import javax.inject.*;

import org.openxava.actions.*;



public class AccionSumTot extends ViewBaseAction{

	@Inject @Named("xavatest_totprefact")
	private String total; 
	
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		
		BigDecimal totalu = new BigDecimal(total);
		
		try{
			List purien = getView().getSubview("consultas").getCollectionValues();
			for(int i=0; purien.size()>i; i++){
	 			Map treos = (Map) purien.get(i);
	 			totalu = totalu.add(new BigDecimal(treos.get("totalConsulta")+"")); 	
	 		}
			
			getView().setValue("total", totalu);
			total=""+totalu;
	 		
		}catch(org.openxava.util.ElementNotFoundException r){
	 		
	 		}
		
		/*
		try{
			List purien = getView().getSubview("procedimientos").getCollectionValues();
			for(int i=0; purien.size()>i; i++){
	 			Map treos = (Map) purien.get(i);
	 			total = total.add(new BigDecimal(treos.get("totalProcedimiento")+"")); 	
	 		}
		}catch(org.openxava.util.ElementNotFoundException r){
			
 		}
		*/
		/*
		try{
			       
			 		
			 		List purien = getView().getSubview("consultas").getCollectionValues();
			 		for(int i=0; purien.size()>i; i++){
			 			Map treos = (Map) purien.get(i);
			 			total = total.add(new BigDecimal(treos.get("totalConsulta")+"")); 	
			 		}
			 		getView().setValue("total", total);
			 		getView().refresh();
			 		}catch(org.openxava.util.ElementNotFoundException r){
			 		
			 		}
					 
					try{
						//System.out.println("correcto:");
						//System.out.println(getView().getSubview("procedimientos"));
				 		
					}catch(org.openxava.util.ElementNotFoundException r){
						
			 		}
					
					*/
					/*
					try{
			 		List purien = getView().getSubview("procedimientos").getCollectionValues();
			 		for(int i=0; purien.size()>i; i++){
			 			Map treos = (Map) purien.get(i);
			 			total = total.add(new BigDecimal(treos.get("totalProcedimientosF")+""));
			 			System.out.println("que pasa?");
			 		}
			 		getView().setValue("total", total);
			 		getView().refresh();
			 		}catch(org.openxava.util.ElementNotFoundException r){
			 		}
			 		*/
	}

}
