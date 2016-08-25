package pucp.servsoci.sswcitas;

import java.sql.Connection;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pucp.lib.PucpAccion;
import pucp.lib.PucpAccionException;
import pucp.lib.PucpSession;
import pucp.lib.PucpUsuarioVariables;
import pucp.lib.exception.PucpException;
import pucp.servsoci.beans.CitasAlumnosBeanFunction;


public class AccionInsertarConsultaCitas extends PucpAccion{	
	
	public void ejecutar (ServletContext sc, HttpServletRequest request, HttpServletResponse response)	
	throws Exception{
		
		super.ejecutar(sc, request, response);		
		Connection connection = this.getConnection("DESA", "SERVSOCI", "AUX_ILIO_");
		
		PucpUsuarioVariables puv = PucpSession.getUsuarioVariables(sc,request, response);
		
		try {	
			
			String anio = request.getParameter("anio");
	    	String ciclo = request.getParameter("ciclo");
	    	String tramite = request.getParameter("tramite"); 
			
	    	request.setAttribute("anio",request.getParameter("anio"));
	    	request.setAttribute("ciclo",request.getParameter("ciclo"));
	    	request.setAttribute("tramite",request.getParameter("tramite"));	
	    	
	    	
	    	
	    	CitasAlumnosBeanFunction ConsultaCitas = new CitasAlumnosBeanFunction();
	    	ConsultaCitas.setCon(connection);

	    	
	    	/* Descripcion del tramite */
	    	String descripcion = ConsultaCitas.obtenerDescripcion(tramite);
    		request.setAttribute("descripcion", descripcion);
    		
    		
    		/* Tipo grupo del tramite */
    		String tipogrupo = ConsultaCitas.obtenerTipoGrupo(tramite);
    		request.setAttribute("tipogrupo", tipogrupo);    
    		
    		Vector vectorResultados = ConsultaCitas.consultarCitasAlumnos(anio, ciclo, tramite);
		    request.setAttribute("vectorResultados", vectorResultados);		    		   
    		
			pucpForward(request, response, "/pucp/servsoci/sswcitas/jsp/AccionInsertarConsultaCitas.jsp");			

		} catch (Exception exc) {
			if (connection != null && !connection.isClosed()) {
				try { connection.rollback();
				} catch (Exception e) {
	
				}
			}
			throw exc;
		} finally {
			if (connection!= null) {
				try {
					if(!connection.isClosed()) {  
						connection.commit();
						connection.close();
					}
				} catch (Exception exc) {
					throw exc;
				}
			}
		}
	
}
	
		
}