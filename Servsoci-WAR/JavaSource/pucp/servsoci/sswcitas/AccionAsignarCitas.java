package pucp.servsoci.sswcitas;

import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pucp.lib.PucpAccion;
import pucp.lib.componentes.PucpListaVector;
import pucp.servsoci.beans.CitasAlumnosBeanFunction;

/**
* PUCP Copyright � 2001 PUCP DIRINFO
*
* <p>Nombre de la Aplicacion: AccionAsignarCitas.java <p>
* <p>Descripcion: Aplicacion encargada de obtener los combos de ciclo-anio y tramite
*                 y mostrarlos en el respectivo jsp (AccionAsignarCitas.jsp) para proceder 
*                 con la asignacion de horario de citas <p>
* @author Juan Tomairo
* @version 1.0
* @throws Exception
* @since 2016-08-29
*
*/

public class AccionAsignarCitas extends PucpAccion{	
	
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
												
			pucpForward(request, response, "/pucp/servsoci/sswcitas/jsp/AccionAsignarCitas.jsp");			
			 
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