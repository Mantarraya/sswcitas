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
	    this.acciones.put("InsertarDatosCitas", new AccionInsertarDatosCitas());
	    this.acciones.put("MostrarInstrucciones", new AccionMostrarInstrucciones());
	    this.acciones.put("ActivarDJF", new AccionActivarDJF());
	    this.acciones.put("InsertarActivacionDJF", new AccionInsertarActivacionDJF());
	    this.acciones.put("AsignarCitas", new AccionAsignarCitas());
	    this.acciones.put("InsertarAsignacionCitas", new AccionInsertarAsignacionCitas());
	    this.acciones.put("ConsultarCitas", new AccionConsultarCitas());
	    this.acciones.put("InsertarConsultaCitas", new AccionInsertarConsultaCitas());

	  }  
}