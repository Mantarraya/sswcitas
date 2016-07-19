package pucp.servsoci.sswcitas;

import java.io.InputStream;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pucp.servsoci.beans.CitasAlumnosBeanFunction;
import pucp.lib.PucpAccion;
import pucp.lib.componentes.PucpListaVector;
import pucp.lib.exception.PucpException;

import pucp.lib.util.PucpMultipartRequest;



public class AccionRegistrarCitas extends PucpAccion{
	
	public void ejecutar (ServletContext sc, HttpServletRequest request, HttpServletResponse response, PucpMultipartRequest multirequest)throws Exception {
		
		/* Conexion */
		super.ejecutar(sc, request, response);
		Connection connectionServSoci =this.getConnection("PREPROD","SERVSOCI","AUX_ILIO_");

		
		try {

			
			/* Mostrar Combo de ciclos de Servicio Social */
			PucpListaVector comboCiclo   = new PucpListaVector();

			CitasAlumnosBeanFunction BusquedaCiclos = new CitasAlumnosBeanFunction();
			BusquedaCiclos.setCon(connectionServSoci);

			comboCiclo = BusquedaCiclos.LlenaComboCiclos();
			comboCiclo.insertar("","Seleccione un ciclo",0); //insertamos una opción al inicio      
			request.setAttribute("comboCiclo", comboCiclo.toArrayString());//compartimos el arreglo con los datos para que los use el JSP
			
			/* Mostrar Combo de tramites */
			PucpListaVector comboTramite = new PucpListaVector();
			
			CitasAlumnosBeanFunction BusquedaTramites = new CitasAlumnosBeanFunction();
			BusquedaTramites.setCon(connectionServSoci);
			
			comboTramite = BusquedaCiclos.LlenaComboTramites();
			comboTramite.insertar("","Seleccione un tramite",0); //insertamos una opción al inicio      
			request.setAttribute("comboTramite", comboTramite.toArrayString());//compartimos el arreglo con los datos para que los use el JSP
	
			/* Adjuntar archivo excel */
			
			/* Verificacion de parametros */
			String cicloAno = multirequest.getParameter("comboCiclo").substring(0, 3);
			String ciclo = multirequest.getParameter("comboCiclo").substring(6, 6);
			String tramite = multirequest.getParameter("comboTramite");
			
			 /* Obtenemos datos del archivo */
			
			String nombreArchivo  = multirequest.getFileFullName("file");
			String extension = multirequest.getFileExtension("file");    
			InputStream contenido = multirequest.getFileContent("file");
			
			/* Verificamos la extension */
			if (extension == null || extension.equals("") || !(extension.equalsIgnoreCase("xls")) || !(extension.equalsIgnoreCase("xls") )){
				
				throw new PucpException("Ocurrió un error al cargar el archivo excel");	
				
            }
			else {
				
				
				CitasAlumnosBeanFunction CitasExcel = new CitasAlumnosBeanFunction();
				
				/* Almacenar citas en base de datos */
				boolean cargoCitasServSoci = CitasExcel.cargarCitas(contenido, cicloAno, ciclo, tramite);
				
				if (!cargoCitasServSoci){						
					throw new PucpException("Ocurrió un error al cargar el archivo excel");	        		           	
				}
										
			}
								
			pucpForward(request, response, "/pucp/servsoci/sswcitas/jsp/AccionRegistrarCitas.jsp");

		}catch (Exception exc) {
			
			if (connectionServSoci != null && !connectionServSoci.isClosed()) {
				try { connectionServSoci.rollback();
				} catch (Exception e) {}
			}
			
			throw exc;
			
		}
		finally {
			
			if (connectionServSoci!= null) {
				try {
					if(!connectionServSoci.isClosed()){  
						connectionServSoci.commit(); // Colocar commit
						connectionServSoci.close();
					}
				}
				catch (Exception exc) {
					throw exc;
				}
			}
			
		}
		
		
	}
	
	
}