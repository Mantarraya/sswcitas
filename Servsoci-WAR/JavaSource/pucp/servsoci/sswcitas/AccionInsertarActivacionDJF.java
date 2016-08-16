package pucp.servsoci.sswcitas;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pucp.lib.PucpAccion;
import pucp.lib.PucpAccionException;
import pucp.lib.PucpSession;
import pucp.lib.PucpUsuarioVariables;
import pucp.lib.exception.PucpException;
import pucp.servsoci.beans.CitasAlumnosBeanFunction;


public class AccionInsertarActivacionDJF extends PucpAccion{	
	
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
	    	
	    	
	    	
	    	CitasAlumnosBeanFunction ActivacionDJF = new CitasAlumnosBeanFunction();
	    	ActivacionDJF.setCon(connection);

	    	
	    	/* Descripcion del tramite */
	    	String descripcion = ActivacionDJF.obtenerDescripcion(tramite);
    		request.setAttribute("descripcion", descripcion);
    		
    		
    		/* Tipo grupo del tramite */
    		String tipogrupo = ActivacionDJF.obtenerTipoGrupo(tramite);
    		request.setAttribute("tipogrupo", tipogrupo);
    		
    		
    		/* Procedemos a activar la declaracion jurada familiar */
    		    	
    		ActivacionDJF.insertarAlumnoDJF(anio, ciclo, tipogrupo);
    		
    		ActivacionDJF.insertarDJF(anio, ciclo, tramite, tipogrupo);
    		
    		ActivacionDJF.insertarAlumnoDJFxTramitexCiclo(anio, ciclo, tramite);
    		
    		ActivacionDJF.insertarEstudiosxAlumnoDJF(anio, ciclo, tramite);    		    		
    					
			pucpForward(request, response, "/pucp/servsoci/sswcitas/jsp/AccionInsertarActivacionDJF.jsp");			

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
