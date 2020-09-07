package org.adicnet.contrato.acciones;

import java.math.BigDecimal;
import java.util.*;

import javax.inject.*;

import org.adicnet.contrato.modelo.*;
import org.adicnet.contrato.modelo.Consulta.*;
import org.adicnet.contrato.modelo.Diagnostico.*;
import org.adicnet.contrato.soat.*;
import org.apache.commons.beanutils.*;
import org.openxava.actions.*;

import org.openxava.jpa.*;
import org.openxava.util.*; 

public class ConteoConsulta extends ViewBaseAction{
	
	private boolean closeDialogDisallowed = false;
	
	@Inject @Named("xavatest_idprefactura")
	private String idprefactura;
	
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub

		
		
		if (getView().getValueString("valorDeLaConsulta").equals("")){ 
			Messages error = new Messages();
			error.add("Digite el valor de la consulta");
			addErrors(error); // Añade un mensaje para mostrar al usuario
			return;
			}
		
		/*if(!this.codigoPreFacturaDetalle.equals("")){
			Messages error = new Messages();
			error.add("Debe tener prefactura detalle");
			addErrors(error); // Añade un mensaje para mostrar al usuario
			return;
		}*/
		
		if(!getView().getValueString("cuotaModeradora").equals("") && !getView().getValueString("valorDeLaConsulta").equals("")){
			BigDecimal valCons = new BigDecimal(getView().getValueString("valorDeLaConsulta"));
			BigDecimal cuoModer = new BigDecimal(getView().getValueString("cuotaModeradora"));
			
			if(cuoModer.compareTo(valCons)>0){
				Messages error = new Messages();
				error.add("El valor de la cuota moderadora no puede ser mayor al valor de la consulta");
				addErrors(error); // Añade un mensaje para mostrar al usuario
				return;
			}
			//Creo el objeto consulta para copiar datos de la actual view y posteriormente guardar en la BD
			Consulta consulta = new Consulta();
			BeanUtils.copyProperties(consulta, this);
			
			//para que sepa que no es un objeto persistente
			consulta.setOico(null);
			//copio el valor de la consulta
			consulta.setValorDeLaConsulta(valCons);
			//copio el valor de la cuota moderadora
			consulta.setCuotaModeradora(cuoModer);
			//creo la coleccion para guardar procedimiento
			HashMap procedmiento =(HashMap)getView().getValue("procedimiento");
			
			Procedimientos p = new Procedimientos(Integer.parseInt(""+procedmiento.get("codigo")),(String)procedmiento.get("description") ,(String)procedmiento.get("grupoQuirurgico") );
			
			consulta.setProcedimiento(p);
			Finalidad f = getFinalidad();
			if(f!=null)consulta.setFinalidad(f);
			CausaExterna ce = getCausaExterna();
			if(ce!=null)consulta.setCausaExterna(ce);
			
			TipoDeDiagnostico tid = getTipoDeDiagnostico();
			if(tid!=null)consulta.setTipoDeDiagnostico(tid);
			consulta.setPyp(getPyp());
			
			//------------------------------------------Diagnostico 1----------------------------------------------
			try{
			HashMap diagnostico1 =(HashMap)getView().getValue("diagnostico1");
			System.out.println("valor de diagnostico1 : "+diagnostico1);
			Sex sex;
			//Diagnostico(int codigo, String nombre, int edadMin, int edadMax, int edad1, int edad2, Sex sex);
			if(!diagnostico1.get("codigo").equals(null)){
			Diagnostico diagnostico1n = new Diagnostico(Integer.parseInt(""+diagnostico1.get("codigo")),
					(String) procedmiento.get("nombre"),
					Integer.parseInt(""+diagnostico1.get("edadMin")),
					Integer.parseInt(""+diagnostico1.get("edadMax")),
					Integer.parseInt(""+diagnostico1.get("edad1")),
					Integer.parseInt(""+diagnostico1.get("edad2")),
					getSex()
					);
			consulta.setDiagnostico1(diagnostico1n);
			}else{
				Messages error = new Messages();
				error.add("Escoja diagnostico 1");
				addErrors(error); // Añade un mensaje para mostrar al usuario
				return;
			}
			} catch(NullPointerException e){
				System.out.println("Error en la pagina 65");
			}
			//------------------------------------------Diagnostico 1----------------------------------------------
			
			
			
			//------------------------------------------Diagnostico 2----------------------------------------------
			HashMap diagnostico2 =(HashMap)getView().getValue("diagnostico2");
			try{
			if(!diagnostico2.get("codigo").equals(null)){
			Sex sex1;
			//Diagnostico(int codigo, String nombre, int edadMin, int edadMax, int edad1, int edad2, Sex sex);
			Diagnostico diagnostico2n = new Diagnostico(Integer.parseInt(""+diagnostico2.get("codigo")),
					(String) procedmiento.get("nombre"),
					Integer.parseInt(""+diagnostico2.get("edadMin")),
					Integer.parseInt(""+diagnostico2.get("edadMax")),
					Integer.parseInt(""+diagnostico2.get("edad1")),
					Integer.parseInt(""+diagnostico2.get("edad2")),
					getSex()
					);
			consulta.setDiagnostico2(diagnostico2n);
			//------------------------------------------Diagnostico 2----------------------------------------------
			}}catch(NullPointerException e){
				System.out.println("Error en linea 87");
			}
			
			
			//------------------------------------------Diagnostico 3----------------------------------------------		
			try{
			HashMap diagnostico3 =(HashMap)getView().getValue("diagnostico3");
			if(!diagnostico3.get("codigo").equals(null)){
			Sex sex3;
			//Diagnostico(int codigo, String nombre, int edadMin, int edadMax, int edad1, int edad2, Sex sex);
			Diagnostico diagnostico3n = new Diagnostico(Integer.parseInt(""+diagnostico3.get("codigo")),
					(String) procedmiento.get("nombre"),
					Integer.parseInt(""+diagnostico3.get("edadMin")),
					Integer.parseInt(""+diagnostico3.get("edadMax")),
					Integer.parseInt(""+diagnostico3.get("edad1")),
					Integer.parseInt(""+diagnostico3.get("edad2")),
					getSex()
					);
			consulta.setDiagnostico3(diagnostico3n);
			}
			}catch(NullPointerException e){
				System.out.println("Error en linea 108");
			}
			//------------------------------------------Diagnostico 3----------------------------------------------
			
			
			
			//------------------------------------------Diagnostico 4----------------------------------------------
			try{
			HashMap diagnostico4 =(HashMap)getView().getValue("diagnostico4");
			if(!diagnostico4.get("codigo").equals(null)){
			Sex sex4;
			//Diagnostico(int codigo, String nombre, int edadMin, int edadMax, int edad1, int edad2, Sex sex);
			Diagnostico diagnostico4n = new Diagnostico(Integer.parseInt(""+diagnostico4.get("codigo")),
					(String) procedmiento.get("nombre"),
					Integer.parseInt(""+diagnostico4.get("edadMin")),
					Integer.parseInt(""+diagnostico4.get("edadMax")),
					Integer.parseInt(""+diagnostico4.get("edad1")),
					Integer.parseInt(""+diagnostico4.get("edad2")),
					getSex()
					);
			consulta.setDiagnostico4(diagnostico4n);
			
			//------------------------------------------Diagnostico 4----------------------------------------------
			}
			}catch(NullPointerException e){
				System.out.println("Error en linea 131");
			}

			/*Prefactura prefactura = (Prefactura) XPersistence.getManager().createQuery(""
					+ "from Prefactura c where c.prid='"+this.idprefactura+"'").getSingleResult(); 
			
			consulta.setPrefactura(prefactura);	
			if(this.codigoPreFacturaDetalle.equals("")){
				Messages error = new Messages();
				error.add("No existe id de prefactura detalle");
				addErrors(error); // Añade un mensaje para mostrar al usuario
				return;
			}
			PrefacturaDetalle prefactura = new PrefacturaDetalle(this.codigoPreFacturaDetalle); 
			XPersistence.getManager().persist(prefactura);
			consulta.setPrefacturaDetalle(prefactura);	
			calcularEnviar();
			*/
			XPersistence.getManager().persist(consulta);
			addMessage("Guardado correctamente");                // 2
			getView().refresh(); //
			}
		}
	
	/*private void calcularEnviar() {
		// TODO Auto-generated method stub
		BigDecimal valorConsulta = new BigDecimal(""+getView().getValue("totalConsulta"));
		this.totalConsulta = ""+valorConsulta;
	}*/

	private boolean getPyp() {
		// TODO Auto-generated method stub
		if(getView().getValueString("pyp").equals("true")){
			return true;
		}
		return false;
	}
	
	private Sex getSex(){
		if(getView().getValueString("sexo").equals("HOMBRE")){
			return Sex.HOMBRE; //1
		}
		if(getView().getValueString("sexo").equals("MUJER")){
			return Sex.MUJER; //1
		}
		if(getView().getValueString("sexo").equals("TRANSEXUAL")){
			return Sex.TRANSEXUAL; //1
		}
		return null;
	}

	//public enum TipoDeDiagnostico {ImpresionDiagnostica,ConfirmandoNuevo, ConfirmandoRepetido}
	private TipoDeDiagnostico getTipoDeDiagnostico(){
		if(getView().getValueString("tipoDeDiagnostico").equals("ImpresionDiagnostica")){
			return TipoDeDiagnostico.ImpresionDiagnostica; //1
		}
		
		if(getView().getValueString("tipoDeDiagnostico").equals("ConfirmandoNuevo")){
			return TipoDeDiagnostico.ConfirmandoNuevo; //2
		}
		
		if(getView().getValueString("tipoDeDiagnostico").equals("ConfirmandoRepetido")){
			return TipoDeDiagnostico.ConfirmandoRepetido; //2
		}
		
		return null;
	}
	
	/*public enum CausaExterna {AccidenteDeTrabajo,
		AccidenteDeTrancito,
		AccidenteRabico,
		AccidenteOfilico,
		OtroTipoDeAccidente,
		EventoCatastrofico,
		LesionPorAgrecion,
		LesionAutoInfligida,
		SospechaDeMaltratoFisico,
		SospechaDeAbusoSexual,
		SospechaDeViolenciasexual,
		SospechaDeMaltratoEmocional,
		EnfermedadGeneral,
		EnfermedadProfecional,
		Otra}
	*/
	private CausaExterna getCausaExterna() {
		int fila60hoja1=1;
		// TODO Auto-generated method stub
		
		if(getView().getValueString("causaExterna").equals("AccidenteDeTrabajo")){
			return CausaExterna.AccidenteDeTrabajo; //1
		}
		
		if(getView().getValueString("causaExterna").equals("AccidenteDeTrancito")){
			return CausaExterna.AccidenteDeTrancito; //2
		}
		
		if(getView().getValueString("causaExterna").equals("AccidenteRabico")){
			return CausaExterna.AccidenteRabico; //3
		}
		
		if(getView().getValueString("causaExterna").equals("AccidenteOfilico")){
			return CausaExterna.AccidenteOfilico; //4
		}
		
		if(getView().getValueString("causaExterna").equals("OtroTipoDeAccidente")){
			return CausaExterna.OtroTipoDeAccidente; //5
		}
		
		if(getView().getValueString("causaExterna").equals("EventoCatastrofico")){
			return CausaExterna.EventoCatastrofico; //6
		}
		
		if(getView().getValueString("causaExterna").equals("LesionPorAgrecion")){
			return CausaExterna.LesionPorAgrecion; //7
		}
		
		if(getView().getValueString("causaExterna").equals("LesionAutoInfligida")){
			return CausaExterna.LesionAutoInfligida; //8
		}
		
		if(getView().getValueString("causaExterna").equals("SospechaDeMaltratoFisico")){
			return CausaExterna.SospechaDeMaltratoFisico; //9
		}
		
		if(getView().getValueString("causaExterna").equals("SospechaDeAbusoSexual")){
			return CausaExterna.SospechaDeAbusoSexual; //10
		}
		
		if(getView().getValueString("causaExterna").equals("SospechaDeViolenciasexual")){
			return CausaExterna.SospechaDeViolenciasexual; //11
		}
		
		if(getView().getValueString("causaExterna").equals("SospechaDeMaltratoEmocional")){
			return CausaExterna.SospechaDeMaltratoEmocional; //12
		}
		
		if(getView().getValueString("causaExterna").equals("EnfermedadGeneral")){
			return CausaExterna.EnfermedadGeneral; //13
		}
		
		if(getView().getValueString("causaExterna").equals("EnfermedadProfecional")){
			return CausaExterna.EnfermedadProfecional; //14
		}
		
		if(getView().getValueString("causaExterna").equals("Otra")){
			return CausaExterna.Otra; //15
		}
		return null;
	}

	/*public enum Finalidad {
	 *  Diagnostico,
	 *  Terapéutico,
	 *  ProtecciónEspecifica,
		DetecciónTempranaEnfermedadGeneral,
		DetecciónTempranaDeEnfermedadProfesional
		 }*/
	private Finalidad getFinalidad(){
		
		if(getView().getValueString("finalidad").equals("Diagnostico")){
			return Finalidad.Diagnostico; //1
		}
		
		if(getView().getValueString("finalidad").equals("Terapéutico")){
			return Finalidad.Terapéutico; //2
		}
		
		if(getView().getValueString("finalidad").equals("ProteccionEspecifica")){ //3
			return Finalidad.ProtecciónEspecifica;
		}
		
		if(getView().getValueString("finalidad").equals("DetecciónTempranaEnfermedadGeneral")){
			return Finalidad.DetecciónTempranaEnfermedadGeneral; //4
		}
		
		if(getView().getValueString("finalidad").equals("DetecciónTempranaDeEnfermedadProfesional")){
			return Finalidad.DetecciónTempranaDeEnfermedadProfesional; //5
		}
		
		
		return null;
	}

	public boolean isCloseDialogDisallowed() {
		return closeDialogDisallowed;
	}

	public void setCloseDialogDisallowed(boolean closeDialogDisallowed) {
		this.closeDialogDisallowed = closeDialogDisallowed;
	}
	
	

	/*public String getTotalConsulta() {
		return totalConsulta;
	}

	public void setTotalConsulta(String totalConsulta) {
		this.totalConsulta = totalConsulta;
	}*/	

}
