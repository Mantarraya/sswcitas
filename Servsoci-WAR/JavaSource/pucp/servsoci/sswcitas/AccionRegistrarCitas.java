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
      
      
      /*
      
      String cicloAno = request.getParameter("comboCiclo").substring(0, 3);
      String ciclo = request.getParameter("comboCiclo").substring(5, 5);
      String tramite = request.getParameter("comboTramite");
      
      
      
      String nombreArchivo = ((PucpMultipartRequest) request).getFileFullName("file");
      String extension = ((PucpMultipartRequest) request).getFileExtension("file");
      InputStream contenido = ((PucpMultipartRequest) request).getFileContent("file");

      if ((extension == null) || (extension.equals("")) || (!extension.equalsIgnoreCase("xls")) || (!extension.equalsIgnoreCase("xls")))
      {
        throw new PucpException("Ocurrió un error al cargar el archivo excel");
      }

      CitasAlumnosBeanFunction CitasExcel = new CitasAlumnosBeanFunction();

      boolean cargoCitasServSoci = CitasExcel.cargarCitas(contenido, cicloAno, ciclo, tramite);

      if (!cargoCitasServSoci) {
        throw new PucpException("Ocurrió un error al cargar el archivo excel");
      }
      
      */

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