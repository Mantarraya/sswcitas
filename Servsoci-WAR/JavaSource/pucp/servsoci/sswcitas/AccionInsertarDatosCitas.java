package pucp.servsoci.sswcitas;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

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
	throws  Exception, SQLException  {
	
		super.ejecutar(sc, request, response);
	    Connection connectionServSoci = this.getConnection("DESA", "SERVSOCI", "AUX_ILIO_");
	    
	    try {	    		    
			
			String anio = multiRequest.getParameter("anio");
	    	String ciclo = multiRequest.getParameter("ciclo");
	    	String tramite = multiRequest.getParameter("tramite");   	
	    	
	    	request.setAttribute("anio",multiRequest.getParameter("anio"));
	    	request.setAttribute("ciclo",multiRequest.getParameter("ciclo"));
	    	request.setAttribute("tramite",multiRequest.getParameter("tramite"));

	    	String nombreArchivo  = multiRequest.getFileFullName("file");
			String extension = multiRequest.getFileExtension("file");
			InputStream contenido = multiRequest.getFileContent("file");
	    
	    	CitasAlumnosBeanFunction CitasExcel = new CitasAlumnosBeanFunction();
	    	CitasExcel.setCon(connectionServSoci);
	    	
	    	/*
	    	if (1==1){
	    		throw new PucpException("Anio = " + anio + " Ciclo = " + ciclo + " Tramite = " + tramite + 
	    				                " Nombre de archivo = " + nombreArchivo + " Extension = " + extension +
	    				                " Descripcion = " + descripcion);
	    	}
			*/
	    	
	    	int cargoCita = -1;
	    		    	    		    	
	    	if (extension.equals("xls")){
	    		
	    		
	    		/* Eliminar citas en la tabla temporal SERVSOCI.CITASXASIGNAR */
	    		
	    		CitasExcel.eliminarCitas(anio, ciclo, tramite);	    		
	    		
	    		/* Cargaremos las citas a la base de datos (SERVSOCICITASXASIGNAR) */	    		
	    		cargoCita = CitasExcel.cargarCitasArchXLS(contenido, multiRequest);	
	    		
	    		String descripcion = CitasExcel.obtenerDescripcion(tramite);
	    		request.setAttribute("descripcion", descripcion);
	    		
	    		String numCitas = Integer.toString(cargoCita);	    		
	    		request.setAttribute("numCitas", numCitas);
	    		
	    		if (cargoCita == -1){
	    			throw new PucpException("Ocurrio un error al cargar el archivo excel");
	    		}

	    		
	    	}	    
	    	else if (extension.equals("xlsx")){
	    		throw new PucpException("Se debe adjuntar un archivo solo con extension .xls, debera guardar nuevamente el archivo con el Tipo: Libro de Excel 97-2003");
	    	}
	    	else{
	    		throw new PucpException("Se debe adjuntar un archivo con extension .xls");
	    	}
	    	
	    	
	    /*	
			String nombreArchivo  = ((PucpMultipartRequest) request).getFileFullName("file");    
			String extension = ((PucpMultipartRequest) request).getFileExtension("file");        
			InputStream contenido = ((PucpMultipartRequest) request).getFileContent("file"); 
		 
			String nombreArchivo  = multirequest.getFileFullName("file");
			String extension = multirequest.getFileExtension("file");    
			InputStream contenido = multirequest.getFileContent("file");
			
			if ((extension == null) || (extension.equals("")) || (!extension.equalsIgnoreCase("xls")) || (!extension.equalsIgnoreCase("xls")))
		      {
		        throw new PucpException("Ocurri� un error al cargar el archivo excel");
		      }

		      CitasAlumnosBeanFunction CitasExcel = new CitasAlumnosBeanFunction();
  
		      boolean cargoCitasServSoci = CitasExcel.cargarCitas(contenido, anio, ciclo, tramite);
		      
		      if (!cargoCitasServSoci) {
		        throw new PucpException("Ocurri� un error al cargar el archivo excel");
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