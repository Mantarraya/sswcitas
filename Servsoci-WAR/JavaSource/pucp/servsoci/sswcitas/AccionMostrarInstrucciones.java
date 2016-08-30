package pucp.servsoci.sswcitas;

import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pucp.lib.PucpAccion;

/**
* PUCP Copyright © 2001 PUCP DIRINFO
*
* <p>Nombre de la Aplicacion: AccionMostrarInstrucciones.java <p>
* <p>Descripcion: Aplicacion encargada de mostrar las acciones principales para el proceso de asignacion
*                 de citas y activacion de la declaracion jurada familiar, todo visualizado en su respectivo
*                 jsp (AccionMostrarInstrucciones.jsp) <p>    
*
* @author Juan Tomairo
* @version 1.0
* @throws Exception
* @since 2016-08-29
*
*/


public class AccionMostrarInstrucciones extends PucpAccion{	
	
	public void ejecutar (ServletContext sc, HttpServletRequest request, HttpServletResponse response)	
	throws Exception{
		
		super.ejecutar(sc, request, response);		
		Connection connection = this.getConnection("DESA", "SERVSOCI", "AUX_ILIO_");
		
		try {
			
			pucpForward(request, response, "/pucp/servsoci/sswcitas/jsp/AccionMostrarInstrucciones.jsp");			
			
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


