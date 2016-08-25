package pucp.servsoci.sswcitas;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pucp.lib.PucpAccion;
import pucp.lib.PucpSession;
import pucp.lib.componentes.PucpListaVector;
import pucp.lib.exception.PucpException;
import pucp.servsoci.beans.CitasAlumnosBeanData;
import pucp.servsoci.beans.CitasAlumnosBeanFunction;

public class AccionConsultarCitas extends PucpAccion{	
	
	public void ejecutar (ServletContext sc, HttpServletRequest request, HttpServletResponse response)	
	throws Exception{
		
		super.ejecutar(sc, request, response);		
		Connection connection = this.getConnection("DESA", "SERVSOCI", "AUX_ILIO_");
		
		try {			
		    	
		    /* Combo Ciclos */ 	
		    PucpListaVector comboCiclo = new PucpListaVector();

		    CitasAlumnosBeanFunction BusquedaCiclos = new CitasAlumnosBeanFunction();
		    BusquedaCiclos.setCon(connection);

		    comboCiclo = BusquedaCiclos.LlenaComboCiclos();
		    comboCiclo.insertar("", "Seleccione un ciclo", 0);
		    request.setAttribute("comboCiclo", comboCiclo.toArrayString());
		      
		    /* Combo Tramites */		   
		    PucpListaVector comboTramite = new PucpListaVector();

		    CitasAlumnosBeanFunction BusquedaTramites = new CitasAlumnosBeanFunction();
		    BusquedaTramites.setCon(connection);
		     
		    comboTramite = BusquedaTramites.LlenaComboTramites();
		    comboTramite.insertar("", "Seleccione un tramite", 0);
		    request.setAttribute("comboTramite", comboTramite.toArrayString());  
		    				
			pucpForward(request, response, "/pucp/servsoci/sswcitas/jsp/AccionConsultarCitas.jsp");			
			
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