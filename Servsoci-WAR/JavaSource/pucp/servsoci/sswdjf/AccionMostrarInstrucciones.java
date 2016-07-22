package pucp.servsoci.sswcitas;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pucp.lib.PucpAccion;


public class AccionMostrarInstrucciones extends PucpAccion{
	
	public void ejecutar (ServletContext sc, HttpServletRequest request, HttpServletResponse response){
		
		try {
			pucpForward(request, response, "/pucp/servsoci/cewpanel/jsp/AccionBusquedaEspeciDif.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
}