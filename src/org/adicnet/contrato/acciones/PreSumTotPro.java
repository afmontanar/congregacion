package org.adicnet.contrato.acciones;

import org.openxava.actions.*;


import java.math.*;
import java.util.*;

import javax.inject.*;



public class PreSumTotPro extends ViewBaseAction{

	@Inject @Named("xavatest_totprefact")
	private String total; 

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		
		BigDecimal totalu = new BigDecimal(total);
		
		
		try{
			List purien = getView().getSubview("procedimientos").getCollectionValues();
			for(int i=0; purien.size()>i; i++){
	 			Map treos = (Map) purien.get(i);
	 			totalu = totalu.add(new BigDecimal(treos.get("totalProcedimiento")+"")); 	
	 		}
			getView().setValue("total", totalu);
			total=""+totalu;
	 		
		}catch(org.openxava.util.ElementNotFoundException r){
			
 		}
		
		
	}

}
