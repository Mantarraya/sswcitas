package pucp.servsoci.sswcitas;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pucp.lib.PucpAccion;

import pucp.lib.componentes.PucpListaVector;
import pucp.lib.exception.PucpException;
import pucp.lib.util.PucpMultipartRequest;
import pucp.servsoci.beans.CitasAlumnosBeanFunction;

public class AccionInsertarDatosCitas extends PucpAccion{
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) 
	throws  PucpException, IOException, ServletException, Exception  {
	
		super.ejecutar(sc, request, response);
	    Connection connectionServSoci = this.getConnection("PREPROD", "SERVSOCI", "AUX_ILIO_");
	    
	    try {
		
	    	
	    	
	    	/* Insertar citas en la tabla SERVSOCI.CITASXASIGNAR */	    	
	    	
	    	
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

