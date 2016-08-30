package pucp.servsoci.sswcitas;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pucp.lib.PucpAccion;
import pucp.lib.PucpSession;

import pucp.lib.componentes.PucpListaVector;
import pucp.lib.exception.PucpException;
import pucp.lib.util.PucpMultipartRequest;
import pucp.servsoci.beans.CitasAlumnosBeanFunction;

/**
* PUCP Copyright © 2001 PUCP DIRINFO
*
* <p>Nombre de la Aplicacion: AccionRegistrarCitas.java <p>
* <p>Descripcion: Aplicacion encargada de obtener los combos de ciclo-anio y tramite
*                 y mostrarlos en el respectivo jsp (AccionRegistrarCitas.jsp) para proceder 
*                 con el registro del horario de citas desde un archivo excel con extension xls. <p>
* @author Juan Tomairo
* @version 1.0
* @throws Exception
* @since 2016-08-29
*
*/

public class AccionRegistrarCitas extends PucpAccion
{
  public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response)
  throws  PucpException, IOException, ServletException, Exception  {
	  
    super.ejecutar(sc, request, response);
    Connection connectionServSoci = this.getConnection("DESA", "SERVSOCI", "AUX_ILIO_");
    try                                                  
    {
    	
      PucpSession.getVerificar(sc, request, response, 1);
    	
      /* Combo Ciclos */ 	
      PucpListaVector comboCiclo = new PucpListaVector();

      CitasAlumnosBeanFunction BusquedaCiclos = new CitasAlumnosBeanFunction();
      BusquedaCiclos.setCon(connectionServSoci);

      comboCiclo = BusquedaCiclos.LlenaComboCiclos();
      comboCiclo.insertar("", "Seleccione un ciclo", 0);
      request.setAttribute("comboCiclo", comboCiclo.toArrayString());

      
      /* Combo Tramites */
      
      PucpListaVector comboTramite = new PucpListaVector();

      CitasAlumnosBeanFunction BusquedaTramites = new CitasAlumnosBeanFunction();
      BusquedaTramites.setCon(connectionServSoci);
     
      comboTramite = BusquedaTramites.LlenaComboTramites();
      comboTramite.insertar("", "Seleccione un tramite", 0);
      request.setAttribute("comboTramite", comboTramite.toArrayString());                 

      pucpForward(request, response, "/pucp/servsoci/sswcitas/jsp/AccionRegistrarCitas.jsp");      
      
      
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