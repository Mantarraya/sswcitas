package pucp.servsoci.sswcitas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pucp.lib.PucpHttpServlet;


/**
 * Servlet implementation class SswCitas
 */
public final class Sswcitas extends PucpHttpServlet
{
	  protected void initAcciones()
	  {
	    /* Juan Tomairo - Julio 2016 */
	        
	    this.acciones.put("RegistrarCitas", new AccionRegistrarCitas());
	        
	  }  
	}