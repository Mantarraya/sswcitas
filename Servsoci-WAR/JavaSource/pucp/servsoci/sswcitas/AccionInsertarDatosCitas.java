package pucp.servsoci.sswcitas;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pucp.lib.PucpAccion;

import pucp.lib.exception.PucpException;
import pucp.lib.util.PucpMultipartRequest;
import pucp.servsoci.beans.CitasAlumnosBeanData;
import pucp.servsoci.beans.CitasAlumnosBeanFunction;

public class AccionInsertarDatosCitas extends PucpAccion{
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response, PucpMultipartRequest multiRequest) 
	throws  Exception  {
	
		super.ejecutar(sc, request, response);
	    Connection connectionServSoci = this.getConnection("DESA", "SERVSOCI", "AUX_ILIO_");
	    
	    try {	    		    
	    	
	    	CitasAlumnosBeanFunction archivoExcel= new CitasAlumnosBeanFunction();
			archivoExcel.setCon(connectionServSoci);
			
			CitasAlumnosBeanData archivo = archivoExcel.obtenerArchivo(multiRequest);
			
			String anio = multiRequest.getParameter("anio");
	    	String ciclo = multiRequest.getParameter("ciclo");
	    	String tramite = multiRequest.getParameter("tramite");
	    	
	    	request.setAttribute("anio",multiRequest.getParameter("anio"));
	    	request.setAttribute("ciclo",multiRequest.getParameter("ciclo"));
	    	request.setAttribute("tramite",multiRequest.getParameter("tramite"));
	    
	    	//String nombreArchivo  = request.getFileFullName("file");
			//String extension = ((PucpMultipartRequest) request).getFileExtension("file");
			//InputStream contenido = ((PucpMultipartRequest) request).getFileContent("file");
	    
	    	CitasAlumnosBeanFunction CitasExcel = new CitasAlumnosBeanFunction();
	    	CitasExcel.setCon(connectionServSoci);
	    	
	    	
	    	/*
	    	if (1==1){
	    		throw new PucpException("Anio = " + anio + " Ciclo = " + ciclo + " Tramite = " + tramite + 
	    				                "Nombre de archivo = ");
	    	}
	    	*/
	    	
	    	
	    	boolean cargoCita;
	    	cargoCita = CitasExcel.foobar(multiRequest); 
	    	
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

