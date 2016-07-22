package pucp.servsoci.sswdjf;

import java.util.HashMap;
import pucp.lib.PucpHttpServlet;

public final class Sswdjf extends PucpHttpServlet
{
  protected void initAcciones()
  {
    this.acciones.put("Ingresar", new AccionIngresar());

    this.acciones.put("DatosPersonales", new AccionDatosPersonales());
    this.acciones.put("DatosPersonalesPosgrado", new AccionDatosPersonalesPosgrado());
    this.acciones.put("EditarDatosPersonales", new AccionEditarDatosPersonales());
    this.acciones.put("EditarDatosPersonalesPosgrado", new AccionEditarDatosPersonalesPosgrado());
    this.acciones.put("GrabarDatosPersonales", new AccionGrabarDatosPersonales());
    this.acciones.put("GrabarDatosPersonalesPosgrado", new AccionGrabarDatosPersonalesPosgrado());

    this.acciones.put("DatosGenerales", new AccionDatosGenerales());
    this.acciones.put("DatosGeneralesPosgrado", new AccionDatosGeneralesPosgrado());
    this.acciones.put("EditarDatosGenerales", new AccionEditarDatosGenerales());
    this.acciones.put("EditarDatosGeneralesPosgrado", new AccionEditarDatosGeneralesPosgrado());
    this.acciones.put("GrabarDatosGenerales", new AccionGrabarDatosGenerales());
    this.acciones.put("GrabarDatosGeneralesPosgrado", new AccionGrabarDatosGeneralesPosgrado());

    this.acciones.put("DatosFamiliares", new AccionDatosFamiliares());
    this.acciones.put("DatosFamiliaresPosgrado", new AccionDatosFamiliaresPosgrado());
    this.acciones.put("EditarDatosFamiliares", new AccionEditarDatosFamiliares());
    this.acciones.put("EditarDatosFamiliaresPosgrado", new AccionEditarDatosFamiliaresPosgrado());
    this.acciones.put("GrabarDatosFamiliares", new AccionGrabarDatosFamiliares());
    this.acciones.put("GrabarDatosFamiliaresPosgrado", new AccionGrabarDatosFamiliaresPosgrado());

    this.acciones.put("Salud", new AccionSalud());
    this.acciones.put("EditarSalud", new AccionEditarSalud());
    this.acciones.put("GrabarSalud", new AccionGrabarSalud());

    this.acciones.put("Vivienda", new AccionVivienda());
    this.acciones.put("EditarVivienda", new AccionEditarVivienda());
    this.acciones.put("GrabarVivienda", new AccionGrabarVivienda());

    this.acciones.put("Ampliacion", new AccionAmpliacion());
    this.acciones.put("EditarAmpliacion", new AccionEditarAmpliacion());
    this.acciones.put("GrabarAmpliacion", new AccionGrabarAmpliacion());

    this.acciones.put("SituacionEconomica", new AccionSituacionEconomica());
    this.acciones.put("SituacionEconomicaPosgrado", new AccionSituacionEconomicaPosgrado());
    this.acciones.put("EditarSituacionEconomica", new AccionEditarSituacionEconomica());
    this.acciones.put("EditarSituacionEconomicaPosgrado", new AccionEditarSituacionEconomicaPosgrado());
    this.acciones.put("GrabarSituacionEconomica", new AccionGrabarSituacionEconomica());
    this.acciones.put("GrabarSituacionEconomicaPosgrado", new AccionGrabarSituacionEconomicaPosgrado());
    this.acciones.put("RefrescarSituacionEconomica", new AccionRefrescarSituacionEconomica());
    this.acciones.put("RefrescarSituacionEconomicaPosgrado", new AccionRefrescarSituacionEconomicaPosgrado());

    this.acciones.put("GrabarDJF", new AccionGrabarDJF());
    this.acciones.put("GrabarDJFPosgrado", new AccionGrabarDJFPosgrado());

    this.acciones.put("EstudiosAlumno", new AccionEstudiosAlumno());
    this.acciones.put("EditarEstudiosAlumno", new AccionEditarEstudiosAlumno());
    this.acciones.put("GrabarEstudiosAlumno", new AccionGrabarEstudiosAlumno());
    this.acciones.put("BorrarEstudiosAlumno", new AccionBorrarEstudiosAlumno());
    this.acciones.put("VerResultados", new AccionVerResultados());

    this.acciones.put("ImprimirDJF", new AccionImprimirDJF());
    this.acciones.put("ImprimirDJFPosgrado", new AccionImprimirDJFPosgrado());
    
    this.acciones.put("BuscarDocumentoDJF", new AccionBuscarDocumentoDJF());
    this.acciones.put("CrearDocumentoDJF", new AccionCrearDocumentoDJF());
    this.acciones.put("GrabarDocumentoDJF", new AccionGrabarDocumentoDJF());
     
    this.acciones.put("ConsultarRegistroCorreo", new AccionConsultarRegistroCorreo());    
    
    this.acciones.put("SeleccionarOpcion", new AccionSeleccionarOpcion());  
    this.acciones.put("ActualizarManualDeInstrucciones",new AccionActualizarManualDeInstrucciones());
    this.acciones.put("GrabarManualDeInstrucciones",new AccionGrabarManualDeInstrucciones());
    this.acciones.put("DescargarManualDeInstrucciones",new AccionDescargarManualDeInstrucciones());
        
    /* Juan Tomairo - Julio 2016 */
        
    this.acciones.put("RegistrarCitas", new AccionRegistrarCitas());
        
  }  
}