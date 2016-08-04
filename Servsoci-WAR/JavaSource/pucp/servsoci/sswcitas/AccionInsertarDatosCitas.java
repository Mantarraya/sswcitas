package pucp.servsoci.sswcitas;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ws.sdo.mediator.jdbc.queryengine.sqlquerytree.WhereClause;
import com.tivoli.pd.jasn1.boolean32;

import pucp.lib.PucpAccion;
import pucp.lib.PucpSession;
import pucp.lib.PucpUsuarioVariables;

import pucp.lib.componentes.PucpListaVector;
import pucp.lib.exception.PucpException;
import pucp.lib.util.PucpMultipartRequest;
import pucp.servsoci.beans.CitasAlumnosBeanFunction;

public class AccionInsertarDatosCitas extends PucpAccion{
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) 
	throws  PucpException, IOException, ServletException, Exception  {
	
		super.ejecutar(sc, request, response);
	    Connection connectionServSoci = this.getConnection("DESA", "SERVSOCI", "AUX_ILIO_");
	    
	    
	    
	    try {	    	
	    	
	    	
	    	String anio = request.getParameter("anio");
	    	String ciclo = request.getParameter("ciclo");
	    	String tramite = request.getParameter("tramite");
	    	
	    	CitasAlumnosBeanFunction CitasExcel = new CitasAlumnosBeanFunction();
	    	CitasExcel.setCon(connectionServSoci);
	    	
	    	/*
	    	if (1==1){
	    		throw new PucpException("Anio = " + anio + " Ciclo = " + ciclo + " Tramite = " + tramite);
	    	}
	    	*/
	    	
	    	
	    	boolean cargoCita;
	    	cargoCita = CitasExcel.foobar(request); 
	    		
	    		
	    	
	    /*	
			String nombreArchivo  = ((PucpMultipartRequest) request).getFileFullName("file");    
			String extension = ((PucpMultipartRequest) request).getFileExtension("file");        
			InputStream contenido = ((PucpMultipartRequest) request).getFileContent("file"); 
		 
			String nombreArchivo  = multirequest.getFileFullName("file");
			String extension = multirequest.getFileExtension("file");    
			InputStream contenido = multirequest.getFileContent("file");
			
			if ((extension == null) || (extension.equals("")) || (!extension.equalsIgnoreCase("xls")) || (!extension.equalsIgnoreCase("xls")))
		      {
		        throw new PucpException("Ocurrió un error al cargar el archivo excel");
		      }

		      CitasAlumnosBeanFunction CitasExcel = new CitasAlumnosBeanFunction();

		      
		      
		      
		      
		      
		      
		      boolean cargoCitasServSoci = CitasExcel.cargarCitas(contenido, anio, ciclo, tramite);
		      
		      if (!cargoCitasServSoci) {
		        throw new PucpException("Ocurrió un error al cargar el archivo excel");
		      }
	    	
   				
		      */
	    	
	    	
	    	
	    	
	    	
	        pucpForward(request, response, "/pucp/servsoci/sswcitas/jsp/AccionInsertarDatosCitas.jsp");
	        
	    	
		} 
	    catch (Exception exc)
	    {
	      if ((connectionServSoci != null) && (!connectionServSoci.isClosed())) try {
	          connectionServSoci.rollback();
	        }
	        catch (Exception localException1)
	        {
	        } throw exc;
	    }
	    finally
	    {
	      if (connectionServSoci != null)
	        try {
	          if (!connectionServSoci.isClosed()) {
	            connectionServSoci.commit();
	            connectionServSoci.close();
	          }
	        }
	        catch (Exception exc) {
	          throw exc;
	        }
	    }		
		
		
		
	}
	
	
}

