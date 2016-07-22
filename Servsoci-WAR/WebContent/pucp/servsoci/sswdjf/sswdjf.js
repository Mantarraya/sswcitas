<!-- JavaScript de la app. sswdjf -->
function alerta_no_tocar(forma)
{	
forma.focus();
}

function ImprimirDJF()
{
  document.formDeclaracionJurada.accion.value='ImprimirDJF';
  document.formDeclaracionJurada.submit();
}

function ImprimirDJFPosgrado()
{
  document.formDeclaracionJurada.accion.value='ImprimirDJFPosgrado';
  document.formDeclaracionJurada.submit();
}

function VerEstudiosAlumno()
{
  document.formDeclaracionJurada.accion.value='EstudiosAlumno';
  document.formDeclaracionJurada.estadopag.value='';
  document.formDeclaracionJurada.submit();
}
function VerEstudiosAlumno1()
{
  document.formDeclaracionJurada.accion.value='EstudiosAlumno';
  document.formDeclaracionJurada.submit();
}

function DatosGenerales()
{
  document.formDeclaracionJurada.accion.value='DatosGenerales';
  document.formDeclaracionJurada.submit();
}
function DatosPersonales()
{
  document.formDeclaracionJurada.accion.value='DatosPersonales';
  document.formDeclaracionJurada.submit();
}
function DatosFamiliares()
{
  document.formDeclaracionJurada.accion.value='DatosFamiliares';
  document.formDeclaracionJurada.submit();
}
function DatosGeneralesPosgrado()
{
  document.formDeclaracionJurada.accion.value='DatosGeneralesPosgrado';
  document.formDeclaracionJurada.submit();
}
function DatosPersonalesPosgrado()
{
  document.formDeclaracionJurada.accion.value='DatosPersonalesPosgrado';
  document.formDeclaracionJurada.submit();
}
function DatosFamiliaresPosgrado()
{
  document.formDeclaracionJurada.accion.value='DatosFamiliaresPosgrado';
  document.formDeclaracionJurada.submit();
}
function Salud()
{
  document.formDeclaracionJurada.accion.value='Salud';
  document.formDeclaracionJurada.submit();
}
function Vivienda()
{
  document.formDeclaracionJurada.accion.value='Vivienda';
  document.formDeclaracionJurada.submit();
}
function Ampliacion()
{
  document.formDeclaracionJurada.accion.value='Ampliacion';
  document.formDeclaracionJurada.submit();
}
function SituacionEconomica()
{
  document.formDeclaracionJurada.accion.value='SituacionEconomica';
  document.formDeclaracionJurada.submit();
}
function SituacionEconomicaPosgrado()
{
  document.formDeclaracionJurada.accion.value='SituacionEconomicaPosgrado';
  document.formDeclaracionJurada.submit();
}
function EditarDatosGenerales()
{
  document.formDatosGenerales.accion.value='EditarDatosGenerales';
  document.formDatosGenerales.submit();
}
function EditarDatosPersonales()
{
  document.formDatosPersonales.accion.value='EditarDatosPersonales';
  document.formDatosPersonales.submit();}

  function EditarDatosFamiliares()
{
  document.formDatosFamiliares.accion.value='EditarDatosFamiliares';
  document.formDatosFamiliares.submit();}

  function EditarDatosGeneralesPosgrado()
  {
    document.formDatosGenerales.accion.value='EditarDatosGeneralesPosgrado';
    document.formDatosGenerales.submit();
  }
  function EditarDatosPersonalesPosgrado()
  {
    document.formDatosPersonales.accion.value='EditarDatosPersonalesPosgrado';
    document.formDatosPersonales.submit();}

    function EditarDatosFamiliaresPosgrado()
  {
    document.formDatosFamiliares.accion.value='EditarDatosFamiliaresPosgrado';
    document.formDatosFamiliares.submit();}

  
  function EditarSalud()
{
  document.formSalud.accion.value='EditarSalud';
  document.formSalud.submit();}

  function EditarVivienda()
{
  document.formVivienda.accion.value='EditarVivienda';
  document.formVivienda.submit();}

  function EditarAmpliacion()
{
  document.formAmpliacion.accion.value='EditarAmpliacion';
  document.formAmpliacion.submit();}

  function EditarSituacionEconomica()
{
  document.formSituacionEconomica.accion.value='EditarSituacionEconomica';
  document.formSituacionEconomica.submit();}

  function EditarSituacionEconomicaPosgrado()
  {
    document.formSituacionEconomica.accion.value='EditarSituacionEconomicaPosgrado';
    document.formSituacionEconomica.submit();}

function EditarEstudiosAlumno()
{
  document.formEstudiosAlumno.accion.value='EditarEstudiosAlumno';
  document.formEstudiosAlumno.submit();
}

function GrabarDatosPersonales(Origen)  {
  document.formEditarDatosPersonales.accion.value='GrabarDatosPersonales';
  if ( Origen=='0') {
      document.formEditarDatosPersonales.origen.value='0';
  } else {
      document.formEditarDatosPersonales.origen.value='1';
  }
  document.formEditarDatosPersonales.submit();
}

function GrabarDatosGenerales(Origen)  {
  document.formEditarDatosGenerales.accion.value='GrabarDatosGenerales';
  if ( Origen=='0') {
      document.formEditarDatosGenerales.origen.value='0';
  } else {
      document.formEditarDatosGenerales.origen.value='1';
  }

  document.formEditarDatosGenerales.submit();
}

function GrabarDatosFamiliares(Origen)  {
  document.formEditarDatosFamiliares.accion.value='GrabarDatosFamiliares';
  if ( Origen=='0') {
      document.formEditarDatosFamiliares.origen.value='0';
  } else {
      document.formEditarDatosFamiliares.origen.value='1';
  }
  document.formEditarDatosFamiliares.submit();
}

function GrabarDatosPersonalesPosgrado(Origen)  {
	  document.formEditarDatosPersonales.accion.value='GrabarDatosPersonalesPosgrado';
	  if ( Origen=='0') {
	      document.formEditarDatosPersonales.origen.value='0';
	  } else {
	      document.formEditarDatosPersonales.origen.value='1';
	  }
	  document.formEditarDatosPersonales.submit();
	}

	function GrabarDatosGeneralesPosgrado(Origen)  {
	  document.formEditarDatosGenerales.accion.value='GrabarDatosGeneralesPosgrado';
	  if ( Origen=='0') {
	      document.formEditarDatosGenerales.origen.value='0';
	  } else {
	      document.formEditarDatosGenerales.origen.value='1';
	  }

	  document.formEditarDatosGenerales.submit();
	}

	function GrabarDatosFamiliaresPosgrado(Origen)  {
	  document.formEditarDatosFamiliares.accion.value='GrabarDatosFamiliaresPosgrado';
	  if ( Origen=='0') {
	      document.formEditarDatosFamiliares.origen.value='0';
	  } else {
	      document.formEditarDatosFamiliares.origen.value='1';
	  }
	  document.formEditarDatosFamiliares.submit();
	}


function GrabarSalud(Origen)  {
  document.formEditarSalud.accion.value='GrabarSalud';
  if ( Origen=='0') {
      document.formEditarSalud.origen.value='0';
  } else {
      document.formEditarSalud.origen.value='1';
  }
  document.formEditarSalud.submit();
}

function GrabarVivienda(Origen)  {
  document.formEditarVivienda.accion.value='GrabarVivienda';
  if ( Origen=='0') {
      document.formEditarVivienda.origen.value='0';
  } else {
      document.formEditarVivienda.origen.value='1';
  }
  document.formEditarVivienda.submit();
}

function GrabarAmpliacion(Origen)  {
  document.formEditarAmpliacion.accion.value='GrabarAmpliacion';
  if ( Origen=='0') {
      document.formEditarAmpliacion.origen.value='0';
  } else {
      document.formEditarAmpliacion.origen.value='1';
  }
  document.formEditarAmpliacion.submit();
}

function GrabarSituacionEconomica(Origen)  {
  document.formEditarSituacionEconomica.accion.value='GrabarSituacionEconomica';
  if ( Origen=='0') {
      document.formEditarSituacionEconomica.origen.value='0';
  } else {
      document.formEditarSituacionEconomica.origen.value='1';
  }
  document.formEditarSituacionEconomica.submit();
}

function GrabarSituacionEconomicaPosgrado(Origen)  {
	  document.formEditarSituacionEconomica.accion.value='GrabarSituacionEconomicaPosgrado';
	  if ( Origen=='0') {
	      document.formEditarSituacionEconomica.origen.value='0';
	  } else {
	      document.formEditarSituacionEconomica.origen.value='1';
	  }
	  document.formEditarSituacionEconomica.submit();
	}

function ActualizaPais()
{
var  form = document.formEditarDatosPersonales;
     form.accion.value='EditarDatosPersonales';
     form.submit();
}
function ActualizaDepart()
{
var   form=document.formEditarDatosPersonales;
      form.resiprovincia.value='';
      form.residistrito.value='';
      form.accion.value='EditarDatosPersonales';
      form.submit();
}
function ActualizaProvi()
{
var   form=document.formEditarDatosPersonales;
      form.residistrito.value='';
      form.accion.value='EditarDatosPersonales';
      form.submit();
}
function ActualizaOrigenPais()
{
var  form = document.formEditarDatosPersonales;
     form.accion.value='EditarDatosPersonales';
     form.submit();
}
function ActualizaOrigenDepart()
{
var   form=document.formEditarDatosPersonales;
      form.resiorigenprovincia.value='';
      form.resiorigendistrito.value='';
      form.accion.value='EditarDatosPersonales';
      form.submit();
}
function ActualizaOrigenProvi()
{
var   form=document.formEditarDatosPersonales;
      form.resiorigendistrito.value='';
      form.accion.value='EditarDatosPersonales';
      form.submit();
}
function ActualizaPaisDatFamP()
{
var  form = document.formEditarDatosFamiliares;
     form.accion.value='EditarDatosFamiliares';
     form.submit();
}
function ActualizaDepartDatFamP()
{
var   form=document.formEditarDatosFamiliares;
      form.presiprovincia.value='';
      form.presidistrito.value='';
      form.accion.value='EditarDatosFamiliares';
      form.submit();
}
function ActualizaProviDatFamP()
{
var   form=document.formEditarDatosFamiliares;
      form.presidistrito.value='';
      form.accion.value='EditarDatosFamiliares';
      form.submit();
}

function ActualizaPaisDatFamM()
{
var  form = document.formEditarDatosFamiliares;
     form.accion.value='EditarDatosFamiliares';
     form.submit();
}
function ActualizaDepartDatFamM()
{
var   form=document.formEditarDatosFamiliares;
      form.mresiprovincia.value='';
      form.mresidistrito.value='';
      form.accion.value='EditarDatosFamiliares';
      form.submit();
}
function ActualizaProviDatFamM()
{
var   form=document.formEditarDatosFamiliares;
      form.mresidistrito.value='';
      form.accion.value='EditarDatosFamiliares';
      form.submit();
}

function ActualizaPaisPosgrado()
{
var  form = document.formEditarDatosPersonales;
     form.accion.value='EditarDatosPersonalesPosgrado';
     form.submit();
}
function ActualizaDepartPosgrado()
{
var   form=document.formEditarDatosPersonales;
      form.resiprovincia.value='';
      form.residistrito.value='';
      form.accion.value='EditarDatosPersonalesPosgrado';
      form.submit();
}
function ActualizaProviPosgrado()
{
var   form=document.formEditarDatosPersonales;
      form.residistrito.value='';
      form.accion.value='EditarDatosPersonalesPosgrado';
      form.submit();
}
function ActualizaOrigenPaisPosgrado()
{
var  form = document.formEditarDatosPersonales;
     form.accion.value='EditarDatosPersonalesPosgrado';
     form.submit();
}
function ActualizaOrigenDepartPosgrado()
{
var   form=document.formEditarDatosPersonales;
      form.resiorigenprovincia.value='';
      form.resiorigendistrito.value='';
      form.accion.value='EditarDatosPersonalesPosgrado';
      form.submit();
}
function ActualizaOrigenProviPosgrado()
{
var   form=document.formEditarDatosPersonales;
      form.resiorigendistrito.value='';
      form.accion.value='EditarDatosPersonalesPosgrado';
      form.submit();
}
function ActualizaPaisDatFamPPosgrado()
{
var  form = document.formEditarDatosFamiliares;
     form.accion.value='EditarDatosFamiliaresPosgrado';
     form.submit();
}
function ActualizaDepartDatFamPPosgrado()
{
var   form=document.formEditarDatosFamiliares;
      form.presiprovincia.value='';
      form.presidistrito.value='';
      form.accion.value='EditarDatosFamiliaresPosgrado';
      form.submit();
}
function ActualizaProviDatFamPPosgrado()
{
var   form=document.formEditarDatosFamiliares;
      form.presidistrito.value='';
      form.accion.value='EditarDatosFamiliaresPosgrado';
      form.submit();
}

function ActualizaPaisDatFamMPosgrado()
{
var  form = document.formEditarDatosFamiliares;
     form.accion.value='EditarDatosFamiliaresPosgrado';
     form.submit();
}
function ActualizaDepartDatFamMPosgrado()
{
var   form=document.formEditarDatosFamiliares;
      form.mresiprovincia.value='';
      form.mresidistrito.value='';
      form.accion.value='EditarDatosFamiliaresPosgrado';
      form.submit();
}
function ActualizaProviDatFamMPosgrado()
{
var   form=document.formEditarDatosFamiliares;
      form.mresidistrito.value='';
      form.accion.value='EditarDatosFamiliaresPosgrado';
      form.submit();
}



function VerDatosPersonales()
{
  document.formEditarDatosPersonales.accion.value='DatosPersonales';
  document.formEditarDatosPersonales.submit();
}

function VerDatosGenerales()
{
  document.formEditarDatosGenerales.accion.value='DatosGenerales';
  document.formEditarDatosGenerales.submit();
}

 function VerDatosFamiliares()
{
  document.formEditarDatosFamiliares.accion.value='DatosFamiliares';
  document.formEditarDatosFamiliares.submit();
}
 
 function VerDatosPersonalesPosgrado()
 {
   document.formEditarDatosPersonales.accion.value='DatosPersonalesPosgrado';
   document.formEditarDatosPersonales.submit();
 }

 function VerDatosGeneralesPosgrado()
 {
   document.formEditarDatosGenerales.accion.value='DatosGeneralesPosgrado';
   document.formEditarDatosGenerales.submit();
 }

  function VerDatosFamiliaresPosgrado()
 {
   document.formEditarDatosFamiliares.accion.value='DatosFamiliaresPosgrado';
   document.formEditarDatosFamiliares.submit();
 }
 
function VerSalud()
{
  document.formEditarSalud.accion.value='Salud';
  document.formEditarSalud.submit();
}

function VerVivienda()
{
  document.formEditarVivienda.accion.value='Vivienda';
  document.formEditarVivienda.submit();
}

function VerAmpliacion()
{
  document.formEditarAmpliacion.accion.value='Ampliacion';
  document.formEditarAmpliacion.submit();
}

function VerSituacionEconomica()
{
  document.formEditarSituacionEconomica.accion.value='SituacionEconomica';
  document.formEditarSituacionEconomica.submit();
}

function VerSituacionEconomicaPosgrado()
{
  document.formEditarSituacionEconomica.accion.value='SituacionEconomicaPosgrado';
  document.formEditarSituacionEconomica.submit();
}

function MuestraPanelDatGen()  {
  document.formDatosGenerales.accion.value='Ingresar';
  document.formDatosGenerales.submit();
}    

function MuestraPanelDatPer()  {
  document.formDatosPersonales.accion.value='Ingresar';
  document.formDatosPersonales.submit();
}     

function MuestraPanelDatFam()  {
  document.formDatosFamiliares.accion.value='Ingresar';
  document.formDatosFamiliares.submit();
}

function MuestraPanelSalud()  {
  document.formSalud.accion.value='Ingresar';
  document.formSalud.submit();
}

function MuestraPanelVivienda()  {
  document.formVivienda.accion.value='Ingresar';
  document.formVivienda.submit();
}

function MuestraPanelAmpliacion()  {
  document.formAmpliacion.accion.value='Ingresar';
  document.formAmpliacion.submit();
}

function MuestraPanelSituacionEconomica()  {
  document.formSituacionEconomica.accion.value='Ingresar';
  document.formSituacionEconomica.submit();
}

function MuestraPanelCrearDeclaracion()  {
	  document.formDeclaracionJurada.accion.value='Ingresar';
	  document.formDeclaracionJurada.submit();
}

function MuestraPanelRegistroEnvioCorreo(){
	document.formConsultarRegistroEnvio.accion.value='BuscarDocumentoDJF';
	document.formConsultarRegistroEnvio.submit();
}

function ValidacionDatosCorrectosSalud()
{
/**** Validación de la descripción ****/
 //Validas el tamaño de la revisión
 if (ValidarTamanioCampo(document.formEditarSalud.revision,800) == false){
  alert('Ud. ha ingresado ' + document.formEditarSalud.revision.value.length + ' caracteres en el cuadro de texto observaciones de las asistentas sociales, este cuadro de texto solo admite como máximo 800 caracteres.\n');
  document.formEditarSalud.revision.focus();
  return false;
 }

 //Validamos el tamaño del problema
 if (ValidarTamanioCampo(document.formEditarSalud.problema,300) == false){
  alert('Ud. ha ingresado ' + document.formEditarSalud.problema.value.length + ' caracteres en el cuadro de texto problema de salud, este cuadro de texto solo admite como máximo 300 caracteres.\n');
  document.formEditarSalud.problema.focus();
  return false;
 }

  //Validamos el costo
// if(document.formEditarSalud.costo.value.length!=0 && ValidarNumeroMayorCero(document.formEditarSalud.costo) == false )
//{ 
//  alert('El dato ingresado en el costo del tratamiento mensual no es válido, éste debe ser de tipo numérico mayor que cero.\n');
//  document.formEditarSalud.costo.focus();  
//  return false;        
// }
 
 //Validamos el tamaño de las observaciones
 if (ValidarTamanioCampo(document.formEditarSalud.observaciones,300) == false){
  alert('Ud. ha ingresado ' + document.formEditarSalud.observaciones.value.length + ' caracteres en el cuadro de texto observaciones, este cuadro de texto solo admite como máximo 300 caracteres.\n');
  document.formEditarSalud.observaciones.focus();
  return false;
 }

 // Si no hay ningún error en los datos devolvemos true
 return true;
}

function ValidacionDatosCorrectosVivienda()
{
 //Validamos el tamaño de la revisión
 if (ValidarTamanioCampo(document.formEditarVivienda.revision,800) == false){
  alert('Ud. ha ingresado ' + document.formEditarVivienda.revision.value.length + ' caracteres en el cuadro de texto observaciones de las asistentas sociales, este cuadro de texto solo admite como máximo 800 caracteres.\n');
  document.formEditarVivienda.revision.focus();
  return false;
 }
 
 //Validamos el tamaño de la forma de financiación
 if (ValidarTamanioCampo(document.formEditarVivienda.formafinanciacion,300) == false){
  alert('Ud. ha ingresado ' + document.formEditarVivienda.formafinanciacion.value.length + ' caracteres en el cuadro de texto forma de financiación, este cuadro de texto solo admite como máximo 300 caracteres.\n');
  document.formEditarVivienda.formafinanciacion.focus();
  return false;
 }
 
 //Validamos el año de construcción
 if(document.formEditarVivienda.anio.value.length!=0 && ValidarNumeroMayorCero(document.formEditarVivienda.anio) == false )
{ 
  alert('El dato ingresado en el año de adquisición no es válido, éste debe ser de tipo numérico mayor que cero.\n');
  document.formEditarVivienda.anio.focus();  
  return false;        
 }
 if(document.formEditarVivienda.anio.value.length!=0 && document.formEditarVivienda.anio.value.length!=4) {
   alert('El dato ingresado en el año de adquisición no es válido, éste debe tener una longitud de 4 caracteres.\n');
    document.formEditarVivienda.anio.focus();  
    return false;        
  }
 
 //Validamos el número de pisos
 if(document.formEditarVivienda.nropisos.value.length!=0) {
  if (ValidarNumeroMayorCero(document.formEditarVivienda.nropisos) == false )
  { 
    alert('El dato ingresado en el número de pisos no es válido, éste debe ser de tipo numérico mayor que cero.\n');
    document.formEditarVivienda.nropisos.focus();  
    return false;        
  }
 }
 //Validamos el número de habitaciones
 if(document.formEditarVivienda.nrohabitaciones.value.length!=0 && ValidarNumeroMayorCero(document.formEditarVivienda.nrohabitaciones) == false )
{ 
  alert('El dato ingresado en el número de habitaciones no es válido, éste debe ser de tipo numérico mayor que cero.\n');
  document.formEditarVivienda.nrohabitaciones.focus();  
  return false;        
 }
 //Validamos el tamaño del problema relacionado con la vivienda
 if (ValidarTamanioCampo(document.formEditarVivienda.problema,300) == false){
  alert('Ud. ha ingresado ' + document.formEditarVivienda.problema.value.length + ' caracteres en el cuadro de texto problema relacionado con la vivienda, este cuadro de texto solo admite como máximo 300 caracteres.\n');
  document.formEditarVivienda.problema.focus();
  return false;
 }

 // Si no hay ningún error en los datos devolvemos true
 return true;
}

function ValidacionDatosCorrectosAmpliacion()
{
 //Validamos el tamaño de la revisión
 if (ValidarTamanioCampo(document.formEditarAmpliacion.revision,800) == false){
  alert('Ud. ha ingresado ' + document.formEditarAmpliacion.revision.value.length + ' caracteres en el cuadro de texto observaciones de las asistentas sociales, este cuadro de texto solo admite como máximo 800 caracteres.\n');
  document.formEditarAmpliacion.revision.focus();
  return false;
 }
  //Validamos el tamaño de la ampliación de la información
 if (ValidarTamanioCampo(document.formEditarAmpliacion.ampliacion,800) == false){
  alert('Ud. ha ingresado ' + document.formEditarAmpliacion.ampliacion.value.length + ' caracteres en el cuadro de texto ampliación de la información, este cuadro de texto solo admite como máximo 800 caracteres.\n');
  document.formEditarAmpliacion.ampliacion.focus();
  return false;
 }

 // Si no hay ningún error en los datos devolvemos true
 return true;
}

//Validación del número máximo de caracteres para un cuadro de texto
function ValidarTamanioCampo(objeto, /*name o id del control*/ 
    numMaxCaracteres /*Número Maximo de Caracteres que debe tener el campo de texto*/)
{
  if(objeto.value.length > numMaxCaracteres)
    return false;
  else
    return true;
}

//Validación de un número entero
function ValidarNumeroEntero(objeto /*name o id del objeto*/)
{
  var val;
  if (objeto.value){ 
    if (isNaN(objeto.value)) {
      return false;
    }
    val = new Number(objeto.value);
    if (objeto.value.indexOf('.')>=0) {
      return false;
    }
  }
  return true;
}

function asignar(fselec,fvalor,fcodigo)
   { var indice,texto,valor;
	   indice=fselec.selectedIndex;
	   texto=fselec.options[indice].text;
	   valor=fselec.options[indice].value;
	   fvalor.value=texto;
	   fcodigo.value=valor;
   }
   
function ChequeaPOcupacionPrincipal(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkpocupacionprincipal[indice].checked == true){
    doc.pindocupacionprincipal[indice].value='1';
  }else{
    doc.pindocupacionprincipal[indice].value='0';
  }
}

function ChequeaPTrabajoActual(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkptrabajoactual[indice].checked == true){
    doc.pindtrabajoactual[indice].value='1';
  }else{
    doc.pindtrabajoactual[indice].value='0';
  }
}
function ChequeaMOcupacionPrincipal(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkmocupacionprincipal[indice].checked == true){
    doc.mindocupacionprincipal[indice].value='1';
  }else{
    doc.mindocupacionprincipal[indice].value='0';
  }
}

function ChequeaMTrabajoActual(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkmtrabajoactual[indice].checked == true){
    doc.mindtrabajoactual[indice].value='1';
  }else{
    doc.mindtrabajoactual[indice].value='0';
  }
}

function ChequeaTieneSucursal(indice){
  var doc=document.formEditarSituacionEconomica;
  if (doc.chkptienesucursales[indice].checked == true){
    doc.activempindtienesucursales[indice].value='1';
  }else{
    doc.activempindtienesucursales[indice].value='0';
  }
}
function ChequeaVivecon(indice){
  var doc=document.formEditarDatosPersonales;
  if (doc.chkvivecon[indice].checked == true){
    doc.indvivecon[indice].value='1';
  }else{
    doc.indvivecon[indice].value='0';
  }
}

function ChequeaPosgrado(indice){
	  var doc=document.formEditarDatosPersonales;
	  if (indice=='1'){
		  //se revisa el radio button
//		  alert("indice = " + indice);
//		  alert("ANTES: chkOcupPrin1 = " + doc.chkOcupPrin1.checked + "; chkOcupPrin2 = " + doc.chkOcupPrin2.checked + "; indOcupPrin1 = " + doc.indOcupPrin1.value + "; indOcupPrin2 = " + doc.indOcupPrin2.value);
		  if (doc.chkOcupPrin1.checked == true){
			  doc.chkOcupPrin2.checked = false;
			  doc.indOcupPrin1.value = '1';
			  doc.indOcupPrin2.value = '0';
			  
		  }
		  //se revisa el check box
		  if (doc.chkTrabActual1.checked == true){
			  doc.indTrabActual1.value = '1';
		  } else {
			  doc.indTrabActual1.value = '0';
		  }
		  
//		  alert("DESPUES: chkOcupPrin1 = " + doc.chkOcupPrin1.checked + "; chkOcupPrin2 = " + doc.chkOcupPrin2.checked + "; indOcupPrin1 = " + doc.indOcupPrin1.value + "; indOcupPrin2 = " + doc.indOcupPrin2.value);
		  
		  //
	  } else {
//		  alert("indice=" + indice);
//		  alert("ANTES: chkOcupPrin1 = " + doc.chkOcupPrin1.checked + "; chkOcupPrin2 = " + doc.chkOcupPrin2.checked + "; indOcupPrin1 = " + doc.indOcupPrin1.value + "; indOcupPrin2 = " + doc.indOcupPrin2.value);
		  if (doc.chkOcupPrin2.checked == true){
			  doc.chkOcupPrin1.checked = false;
			  doc.indOcupPrin2.value = '1';
			  doc.indOcupPrin1.value = '0';
			  
		  }
		  //se revisa el check box
		  if (doc.chkTrabActual2.checked == true){
			  doc.indTrabActual2.value = '1';
		  } else {
			  doc.indTrabActual2.value = '0';
		  }
//		  alert("ANTES: chkOcupPrin1 = " + doc.chkOcupPrin1.checked + "; chkOcupPrin2 = " + doc.chkOcupPrin2.checked + "; indOcupPrin1 = " + doc.indOcupPrin1.value + "; indOcupPrin2 = " + doc.indOcupPrin2.value);
	  }
}


function ChequeaPTAeliminar(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkptaeliminar[indice].checked == true){
    doc.pindtaeliminar[indice].value='1';
  }else{
    doc.pindtaeliminar[indice].value='0';
  }
}

function ChequeaMTAeliminar(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkmtaeliminar[indice].checked == true){
    doc.mindtaeliminar[indice].value='1';
  }else{
    doc.mindtaeliminar[indice].value='0';
  }
}

function ChequeaPMCeliminar(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkpmceliminar[indice].checked == true){
    doc.pindmceliminar[indice].value='1';
  }else{
    doc.pindmceliminar[indice].value='0';
  }
}

function ChequeaMMCeliminar(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkmmceliminar[indice].checked == true){
    doc.mindmceliminar[indice].value='1';
  }else{
    doc.mindmceliminar[indice].value='0';
  }
}

function ChequeaOFeliminar(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkofeliminar[indice].checked == true){
    doc.ofindeliminar[indice].value='1';
  }else{
    doc.ofindeliminar[indice].value='0';
  }
}

function ChequeaHDeliminar(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkhdeliminar[indice].checked == true){
    doc.hdindeliminar[indice].value='1';
  }else{
    doc.hdindeliminar[indice].value='0';
  }
}

 function Chequeahdindestudiapucp(indice){
  var doc=document.formEditarDatosFamiliares;
  if (doc.chkhdindestudiapucp[indice].checked == true){
    doc.hdindestudiapucp[indice].value='1';
  }else{
    doc.hdindestudiapucp[indice].value='0';
  }

 }
 
function ValidacionDatosCorrectosSituacionEconomica()
{
 if  (ValidarMontos())
 {
 //Validamos el tamaño de la revisión
 if (ValidarTamanioCampo(document.formEditarSituacionEconomica.revision,800) == false){
  alert('Ud. ha ingresado ' + document.formEditarSituacionEconomica.revision.value.length + ' caracteres en el cuadro de texto observaciones de las asistentas sociales, este cuadro de texto solo admite como máximo 800 caracteres.\n');
  document.formEditarSituacionEconomica.revision.focus();
  return false;
 }
/**** Validación de observaciones de Ingresos Familiares ****/
 //Validamos el tamaño del problema
 if (ValidarTamanioCampo(document.formEditarSituacionEconomica.ifobservaciones,600) == false){
  alert('Ud. ha ingresado ' + document.formEditarSituacionEconomica.ifobservaciones.value.length + ' caracteres en el cuadro de texto Observaciones de Ingresos Familiares, este cuadro de texto solo admite como máximo 600 caracteres.\n');
  document.formEditarSituacionEconomica.ifobservaciones.focus();
  return false;
 }
/**** Validación de observaciones de Egresos Familiares ****/
 //Validamos el tamaño del problema
 if (ValidarTamanioCampo(document.formEditarSituacionEconomica.efobservaciones,600) == false){
  alert('Ud. ha ingresado ' + document.formEditarSituacionEconomica.efobservaciones.value.length + ' caracteres en el cuadro de texto Observaciones de Egresos Familiares, este cuadro de texto solo admite como máximo 600 caracteres.\n');
  document.formEditarSituacionEconomica.efobservaciones.focus();
  return false;
 }
/**** Validación de trabajo artesanal o técnico dependiente ****/
 //Validamos el tamaño del problema
 if (ValidarTamanioCampo(document.formEditarSituacionEconomica.tabreveexplicacion,300) == false){
  alert('Ud. ha ingresado ' + document.formEditarSituacionEconomica.tabreveexplicacion.value.length + ' caracteres en el cuadro de texto Observaciones de Trabajo Artesanal o Técnico Dependiente, este cuadro de texto solo admite como máximo 300 caracteres.\n');
  document.formEditarSituacionEconomica.tabreveexplicacion.focus();
  return false;
 }
 // Si no hay ningún error en los datos devolvemos true
 return true;
 }
 else
 {
  return false;
 }
}

function ChequeaActivEmpeliminar(indice){
  var doc=document.formEditarSituacionEconomica;
  if (doc.chkactivempeliminar[indice].checked == true){
    doc.activempeliminar[indice].value='1';
  }else{
    doc.activempeliminar[indice].value='0';
  }
}

function ChequeaInmuebleeliminar(indice){
  var doc=document.formEditarSituacionEconomica;
  if (doc.chkinmuebleeliminar[indice].checked == true){
    doc.inmuebleeliminar[indice].value='1';
  }else{
    doc.inmuebleeliminar[indice].value='0';
  }
}

function ChequeaVehiculoeliminar(indice){
  var doc=document.formEditarSituacionEconomica;
  if (doc.chkvehiculoeliminar[indice].checked == true){
    doc.vehiculoeliminar[indice].value='1';
  }else{
    doc.vehiculoeliminar[indice].value='0';
  }
}

function ChequeaDepositoeliminar(indice){
  var doc=document.formEditarSituacionEconomica;
  if (doc.chkdepositoeliminar[indice].checked == true){
    doc.depositoeliminar[indice].value='1';
  }else{
    doc.depositoeliminar[indice].value='0';
  }
}

function ChequeaAccioneliminar(indice){
  var doc=document.formEditarSituacionEconomica;
  if (doc.chkaccioneliminar[indice].checked == true){
    doc.accioneliminar[indice].value='1';
  }else{
    doc.accioneliminar[indice].value='0';
  }
}

function ChequeaViajeeliminar(indice){
  var doc=document.formEditarSituacionEconomica;
  if (doc.chkviajeeliminar[indice].checked == true){
    doc.viajeeliminar[indice].value='1';
  }else{
    doc.viajeeliminar[indice].value='0';
  }
}


function ValidacionDatosCorrectosDatosGenerales()
{
/**** Validación de la descripción ****/
 //Validamos el tamaño de la revisión
 if (ValidarTamanioCampo(document.formEditarDatosGenerales.revision,800) == false){
  alert('Ud. ha ingresado ' + document.formEditarDatosGenerales.revision.value.length + ' caracteres en el cuadro de texto observaciones de las asistentas sociales, este cuadro de texto solo admite como máximo 800 caracteres.\n');
  document.formEditarDatosGenerales.revision.focus();
  return false;
 }
 //Validamos el tamaño del problema
 if (ValidarTamanioCampo(document.formEditarDatosGenerales.desactivilaboralremu,300) == false){
  alert('Ud. ha ingresado ' + document.formEditarDatosGenerales.desactivilaboralremu.value.length + ' caracteres en el cuadro de texto descripción de la actividad actual, este cuadro de texto solo admite como máximo 300 caracteres.\n');
  document.formEditarDatosGenerales.desactivilaboralremu.focus();
  return false;
 }
 if(document.formEditarDatosGenerales.ultanioestudiootrauni.value.length!=0 && ValidarNumeroMayorCero(document.formEditarDatosGenerales.ultanioestudiootrauni) == false ) {
    alert('El dato ingresado en Último año de estudio no es válido, éste debe ser de tipo numérico mayor que cero.\n');
    document.formEditarDatosGenerales.ultanioestudiootrauni.focus();  
    return false; 
 }
	 return true;

}

function ValidacionDatosCorrectosDatosGeneralesPosgrado()
{
/**** Validación de la descripción ****/
 //Validamos el tamaño de la revisión
 if (ValidarTamanioCampo(document.formEditarDatosGenerales.revision,800) == false){
  alert('Ud. ha ingresado ' + document.formEditarDatosGenerales.revision.value.length + ' caracteres en el cuadro de texto observaciones de las asistentas sociales, este cuadro de texto solo admite como máximo 800 caracteres.\n');
  document.formEditarDatosGenerales.revision.focus();
  return false;
 }
 //Validamos el tamaño del problema
 if (ValidarTamanioCampo(document.formEditarDatosGenerales.desactivilaboralremu,300) == false){
  alert('Ud. ha ingresado ' + document.formEditarDatosGenerales.desactivilaboralremu.value.length + ' caracteres en el cuadro de texto descripción de la actividad actual, este cuadro de texto solo admite como máximo 300 caracteres.\n');
  document.formEditarDatosGenerales.desactivilaboralremu.focus();
  return false;
 }
 if(document.formEditarDatosGenerales.ultanioestudiootrauni.value.length!=0 && ValidarNumeroMayorCero(document.formEditarDatosGenerales.ultanioestudiootrauni) == false ) {
    alert('El dato ingresado en Último año de estudio no es válido, éste debe ser de tipo numérico mayor que cero.\n');
    document.formEditarDatosGenerales.ultanioestudiootrauni.focus();  
    return false; 
 }

 // Si no hay ningún error en los datos devolvemos true
 
 //se avisa que no se podrá modificar luego la dependencia economica.
 if ((document.formEditarDatosGenerales.depen.value == "9") || (document.formEditarDatosGenerales.depen.value == "10") || (document.formEditarDatosGenerales.depen.value == "11")){
	 return true;	 
 } else {
	 if (confirm("El registro de la dependencia económica no podrá modificarse una vez ud. guarde la información. ¿Desde continuar?")){
		 return true;
	 } else {
		 return false;
	 }
 }
}

function ValidacionDatosCorrectosDatosFamiliares()
{
/**** Validación de la descripción ****/
 //Validamos el tamaño de la revisión
 if (ValidarTamanioCampo(document.formEditarDatosFamiliares.revision,800) == false){
  alert('Ud. ha ingresado ' + document.formEditarDatosFamiliares.revision.value.length + ' caracteres en el cuadro de texto observaciones de las asistentas sociales, este cuadro de texto solo admite como máximo 800 caracteres.\n');
  document.formEditarDatosFamiliares.revision.focus();
  return false;
 }
 // Si no hay ningún error en los datos devolvemos true
 return true;
}

function ValidacionDatosCorrectosDatosPersonales()
{
/**** Validación de la descripción ****/
 //Validamos el tamaño de la revisión
 if (ValidarTamanioCampo(document.formEditarDatosPersonales.revision,800) == false){
  alert('Ud. ha ingresado ' + document.formEditarDatosPersonales.revision.value.length + ' caracteres en el cuadro de texto observaciones de las asistentas sociales, este cuadro de texto solo admite como máximo 800 caracteres.\n');
  document.formEditarDatosPersonales.revision.focus();
  return false;
 }
 // Si no hay ningún error en los datos devolvemos true
 return true;
}

function ValidacionDatosEstudiosAlumno()
{
 // Si no hay ningún error en los datos devolvemos true
 return true;
}

function IngresarDJF()
{ codigo=document.formpanel.alumnopucp.value;
  session=document.formpanel.session.value;
  //window.location="/pucp/servsoci/sswdjf/sswdjf;jsessionid="+session+"?accion=Ingresar&codigo="+codigo;
  window.location="/pucp/servsoci/sswdjf/sswdjf;jsessionid="+session+"?accion=SeleccionarOpcion&codigo="+codigo;
  return;
}

function GrabarDJF()
{
  if (confirm("¿Está seguro que desea finalizar el llenado de su Declaración Jurada Familiar?")) {
    document.formDeclaracionJurada.accion.value='GrabarDJF';
    document.formDeclaracionJurada.submit();
  }
}

function GrabarDJFPosgrado()
{
  if (confirm("¿Está seguro que desea finalizar el llenado de su Declaración Jurada Familiar?")) {
    document.formDeclaracionJurada.accion.value='GrabarDJFPosgrado';
    document.formDeclaracionJurada.submit();
  }
}

function BusquedaAcademia(){
      var prop = "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=550,height=380";
      session=document.formEditarDatosGenerales.session.value;
      codigo=document.formEditarDatosGenerales.codigo.value;
      cicloano=document.formEditarDatosGenerales.cicloano.value;
      ciclo=document.formEditarDatosGenerales.ciclo.value;
      tipociclo=document.formEditarDatosGenerales.tipociclo.value;
      nombrecompleto=document.formEditarDatosGenerales.nombrecompleto.value;
      indconsultaalumno=document.formEditarDatosGenerales.indconsultaalumno.value;
      var url= "/pucp/servsoci/sswdjf/sswdjf;jsessionid="+session+"?accion=BusquedaAcademia&codigo="+
      codigo+"&cicloano="+cicloano+"&ciclo="+ciclo+"&tipociclo="+tipociclo+"&nombrecompleto="+
      nombrecompleto+"&indconsultaalumno="+indconsultaalumno;
      ventana = window.open(url,"BuscarAcademia",prop);
}
      
function BuscarAcademia(){
    var prop = "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=550,height=380";
    session=document.form.session.value;
    nombre=document.form.spNombre.value;
    codigo=document.form.codigo.value;
    cicloano=document.form.cicloano.value;
    ciclo=document.form.ciclo.value;
    tipociclo=document.form.tipociclo.value;
    nombrecompleto=document.form.nombrecompleto.value;
    indconsultaalumno=document.form.indconsultaalumno.value;    
    var url= "/pucp/servsoci/sswdjf/sswdjf;jsessionid="+session+"?accion=BuscarAcademia&nombre="+nombre+"&codigo="+
      codigo+"&cicloano="+cicloano+"&ciclo="+ciclo+"&tipociclo="+tipociclo+"&nombrecompleto="+
      nombrecompleto+"&indconsultaalumno="+indconsultaalumno;
    ventana = window.open(url,"BuscarAcademia",prop);
}

function Cerrar() {
    window.close();
}

function Regresar() {
    document.form.accion.value="BusquedaAcademia";     
    document.form.submit();
}

function RegresarColegio() {
    document.form.accion.value="BusquedaColegio";     
    document.form.submit();
}



function SeleccionaAcademia()
    {
      var doc = document.form;
      var dest = window.opener.document.formEditarDatosGenerales;
      var indice=0;
      var hayacademia=false;
      var strAcademia="";
      var strAcademiaSeleccionada="";    
      var strDescAcademiaSeleccionada=""; 
 
      if (doc.spSeleccion==null)
      {
        alert("No existen academias para el criterio ingresado.");
      }
      else
      { 
         //en el caso que solo exista una fila
         strAcademia = doc.spSeleccion.value;
         if (strAcademia !=null)//solo existe una fila
         {
           if (doc.spSeleccion.checked)
           {
             hayacademia=true;
             strAcademiaSeleccionada=strAcademia;
             strDescAcademiaSeleccionada=doc.spDescAcademia.value;
           }
           else
           {
             hayacademia=false;          
           }
         }
         else
         {
           for (i=0;i<doc.spSeleccion.length;i++)
           {
             if (doc.spSeleccion[i].checked) 
             {
               indice=i;
              hayacademia=true;
              strAcademiaSeleccionada=doc.spCodigo[indice].value;
              strDescAcademiaSeleccionada=doc.spDescAcademia[indice].value;
            }
          }
        }
        if (hayacademia==false)
        {
          alert("Seleccione una academia");
        }
          dest.academia.value = strAcademiaSeleccionada;
          dest.desacademia.value = strDescAcademiaSeleccionada;
          RefrescarPadre();
          window.opener.focus();
          window.close();
        
      }
  }


function ActualizaSecuencia(indice)
{
  var doc = document.formEditarDatosFamiliares;
  doc.hdsecuencia[indice].value="";
  return;
}


function SeleccionaColegio()
    {
      var doc = document.form;
      var dest = window.opener.document.formEditarDatosGenerales;
      var indice=0;
      var haycolegio=false;
      var strColegio="";
      var strColegioSeleccionada="";    
      var strDescColegioSeleccionada=""; 
 
      if (doc.spSeleccion==null)
      {
        alert("No existen colegios para el criterio ingresado.");
      }
      else
      { 
        //en el caso que solo exista una fila
         strColegio = doc.spSeleccion.value;
         if (strColegio !=null)//solo existe una fila
         {
           if (doc.spSeleccion.checked)
           {
             haycolegio=true;
             strColegioSeleccionada=strColegio;
             strDescColegioSeleccionada=doc.spDescColegio.value;
           }
           else
           {
             haycolegio=false;          
           }
         }
         else
         {
           for (i=0;i<doc.spSeleccion.length;i++)
           {
             if (doc.spSeleccion[i].checked) 
             {
               indice=i;
              haycolegio=true;
              strColegioSeleccionada=doc.spCodigo[indice].value;
              strDescColegioSeleccionada=doc.spDescColegio[indice].value;
            }
          }
        }
        if (haycolegio==false)
        {
          alert("Seleccione una colegio");
        }
        if (dest.codinstitucioncolegio.value!=null)
        {
            dest.codinstitucioncolegio.value=strColegioSeleccionada;
            dest.descriinstitucioncolegio.value=strDescColegioSeleccionada;
        }
        else
        {
            dest.codinstitucioncolegio[dest.origenBusquedaColegio.value].value=strColegioSeleccionada;
            dest.descriinstitucioncolegio[dest.origenBusquedaColegio.value].value=strDescColegioSeleccionada;
        }
        RefrescarPadre();
        window.opener.focus();
        window.close();
      }

  }
  
  function RefrescarPadre()
  {
      window.opener.document.formEditarDatosGenerales.accion.value="EditarDatosGenerales";     
      window.opener.document.formEditarDatosGenerales.submit();
  }
 
  function RefrescarPadrePosgrado()
  {
      window.opener.document.formEditarDatosGenerales.accion.value="EditarDatosGeneralesPosgrado";     
      window.opener.document.formEditarDatosGenerales.submit();
  }
  
function BusquedaColegio(origen){
      
      var prop = "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=550,height=380";
      session=document.formEditarDatosGenerales.session.value;
      codigo=document.formEditarDatosGenerales.codigo.value;
      cicloano=document.formEditarDatosGenerales.cicloano.value;
      ciclo=document.formEditarDatosGenerales.ciclo.value;
      tipociclo=document.formEditarDatosGenerales.tipociclo.value;
      nombrecompleto=document.formEditarDatosGenerales.nombrecompleto.value;
      indconsultaalumno=document.formEditarDatosGenerales.indconsultaalumno.value;
      document.formEditarDatosGenerales.origenBusquedaColegio.value = origen;
      var url= "/pucp/servsoci/sswdjf/sswdjf;jsessionid="+session+"?accion=BusquedaColegio&codigo="+
      codigo+"&cicloano="+cicloano+"&ciclo="+ciclo+"&tipociclo="+tipociclo+"&nombrecompleto="+
      nombrecompleto+"&indconsultaalumno="+indconsultaalumno;
      ventana = window.open(url,"BuscarColegio",prop);
      
}

function BuscarColegio(origen){
    
    var prop = "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=550,height=380";
    session=document.form.session.value;
    nombre=document.form.spNombre.value;
    codigo=document.form.codigo.value;
    cicloano=document.form.cicloano.value;
    ciclo=document.form.ciclo.value;
    tipociclo=document.form.tipociclo.value;
    nombrecompleto=document.form.nombrecompleto.value;
    indconsultaalumno=document.form.indconsultaalumno.value;    
    var url= "/pucp/servsoci/sswdjf/sswdjf;jsessionid="+session+"?accion=BuscarColegio&nombre="+nombre+"&codigo="+
      codigo+"&cicloano="+cicloano+"&ciclo="+ciclo+"&tipociclo="+tipociclo+"&nombrecompleto="+
      nombrecompleto+"&indconsultaalumno="+indconsultaalumno;
    ventana = window.open(url,"BuscarColegio",prop);
}

 function Sumar()
{ 
 if  (ValidarMontos())
 {
  document.formEditarSituacionEconomica.accion.value='RefrescarSituacionEconomica';
  document.formEditarSituacionEconomica.submit();
 }
}
 
 function SumarPosgrado()
 { 
  if  (ValidarMontos())
  {
   document.formEditarSituacionEconomica.accion.value='RefrescarSituacionEconomicaPosgrado';
   document.formEditarSituacionEconomica.submit();
  }
 }

function AInstituciones(nfila){
  document.formEditarDatosGenerales.fila.value = nfila;
  var accionoriginal = document.formEditarDatosGenerales.accionoriginal.value;
  var session = document.formEditarDatosGenerales.session.value;
  var prop = "toolbar=no,location=no,status=yes,menubar=no,scrollbars=yes,resizable=no,width=700,height=420,top=0,left=0";
  var url="/pucp/datpers/dpwcurri/dpwcurri;jsessionid=" + session + "?accion=BusquedaCriteriosInstitucion&accionoriginal="+accionoriginal;
  ventana = window.open(url,"",prop);
}

//Validación de que un número sea mayor que cero
function ValidarNumeroMayorCero(objeto /*name o id del objeto*/)
{
  var numero;
  numero = new Number(objeto.value);
  if (numero > 0)
      return true;
  else
   return false;
}

function MuestraPanelDJF()  {
   var codigo = document.formDeclaracionJurada.codigo.value;
   var session = document.formDeclaracionJurada.session.value;
   var misdatos = document.formDeclaracionJurada.misdatos.value;   
   document.formDeclaracionJurada.accion.value='ElegirPanel';
   window.location="/pucp/general/gewpealu/gewpealu;jsessionid=" + session + "?accion=ElegirPanel&codigo="+codigo+"&misdatos="+misdatos;
   }  
   
function EdicionEstudio(secuencia)
{
  session=document.formEstudiosAlumno.session.value;  
  var alumno = document.formEstudiosAlumno.codigo.value;  
  var cicloano = document.formEstudiosAlumno.cicloano.value;
  var ciclo = document.formEstudiosAlumno.ciclo.value;
  var tipociclo = document.formEstudiosAlumno.tipociclo.value;
  var nombrecompleto = document.formEstudiosAlumno.nombrecompleto.value;
  var estadopag = 2;

  window.location="/pucp/servsoci/sswdjf/sswdjf;jsessionid="+session+"?accion=EditarEstudiosAlumno&codigo=" + 
  alumno + "&cicloano=" + cicloano+"&ciclo="+ciclo+"&tipociclo="+tipociclo+
  "&nombrecompleto="+nombrecompleto+"&secuencia="+secuencia+"&estadopag="+estadopag;
  return;  
}

function ActualizaCiclo()
{
var form =document.formDeclaracionJurada;
    form.accion.value='Ingresar';
    form.submit();
}

function ActualizaCicloSeleccionaOpcion()
{
var form =document.formDeclaracionJurada;
    form.accion.value='SeleccionarOpcion';
    form.cambioTramite.value='1';
    form.submit();
}


function BuscarDocumentoDJF()
{
  document.formDeclaracionJurada.accion.value='BuscarDocumentoDJF';
  document.formDeclaracionJurada.submit();
}


function crearListaDocumentoDJF()
{
	if (confirm('¿Esta seguro(a) de desea grabar el contenido?')) {
   document.formDeclaracionJurada.accion.value='GrabarDocumentoDJF';
   var NumFilas  = document.formDeclaracionJurada.NumFilas.value;

	/*
   for(i=0 ; i<NumFilas-1; i++) {
	  if (ValidarTamanioCampo(document.formEditarSalud.revision,800) == false){
		  alert('\n');
		  return false;
		}
	}*/	
   
   for(i=0 ; i<NumFilas; i++) {

   
      if (document.formDeclaracionJurada.seleccionados[i].checked) 
          document.formDeclaracionJurada.indicaConsiderado[i].value = '1';
        else 
          document.formDeclaracionJurada.indicaConsiderado[i].value = '0';
	}
	
  document.formDeclaracionJurada.observacionAlumno.value = document.formDeclaracionJurada.observaAlumno.value;
  document.formDeclaracionJurada.observacionAsistenta.value = document.formDeclaracionJurada.observaAsistenta.value;
	
  document.formDeclaracionJurada.indicaCheckObservacion.value='0'
	
  document.formDeclaracionJurada.submit();
	}
}

function grabarDocumentoDJF()
{
	if (confirm('¿Esta seguro(a) de desea grabar el contenido?')) {
   document.formDeclaracionJurada.accion.value='GrabarDocumentoDJF';
   var NumFilas  = document.formDeclaracionJurada.NumFilas.value;

   // Chequeo observacion alumno
   var sObservaAlu = document.formDeclaracionJurada.observaAlumno.value;
   
   if  ( sObservaAlu.length > 1000 ) {
	   alert('Se han colocado mas de mil caracteres en las observaciones del alumno. Modifique para continuar con el proceso ');
	   return;
   }
   
	/*
   for(i=0 ; i<NumFilas-1; i++) {
	  if (ValidarTamanioCampo(document.formEditarSalud.revision,800) == false){
		  alert('\n');
		  return false;
		}
	}*/	
   
   for(i=0 ; i<NumFilas; i++) {

   
      if (document.formDeclaracionJurada.seleccionados[i].checked) 
          document.formDeclaracionJurada.indicaConsiderado[i].value = '1';
        else 
          document.formDeclaracionJurada.indicaConsiderado[i].value = '0';


      if (document.formDeclaracionJurada.entregados[i].checked) 
          document.formDeclaracionJurada.indicaEntregado[i].value = '1';
        else 
          document.formDeclaracionJurada.indicaEntregado[i].value = '0';
       }

  document.formDeclaracionJurada.observacionAlumno.value = document.formDeclaracionJurada.observaAlumno.value;
  document.formDeclaracionJurada.observacionAsistenta.value = document.formDeclaracionJurada.observaAsistenta.value;
 
  if (document.formDeclaracionJurada.sIndicaCheckObserva.checked  ) {
	  document.formDeclaracionJurada.indicaCheckObservacion.value='1'
  }
  else {
	  document.formDeclaracionJurada.indicaCheckObservacion.value='0'
  }
  
  
  document.formDeclaracionJurada.submit();
	}
}


function enviarCorreo()
{
	if (confirm('¿Esta seguro(a) de enviar el correo a las cuentas del alumno?')) {
		  document.formDeclaracionJurada.accion.value='BuscarDocumentoDJF';
		  document.formDeclaracionJurada.enviarCorreo.value='1';
		  document.formDeclaracionJurada.submit();
		 }
}

function abrirPreguntasFrecuentes()
{
  var propiedades = "width=1000,height=800,menubar=no,status=no,resizable=no,toolbar=no,scrollbars=no,left=338,top=230";
  window.open("http://agora.pucp.edu.pe/tutorial/campusvirtual/respuesta.php?id=192", "", propiedades);  
  window.open("","", propiedades).focus();
}

function consultarEnvioCorreo()
{
	  document.formDeclaracionJurada.accion.value='ConsultarRegistroCorreo';
	  document.formDeclaracionJurada.submit();
}


function MuestraPanelSeleccionarOpcion(){
	document.formDeclaracionJurada.accion.value="SeleccionarOpcion";
	document.formDeclaracionJurada.submit();
}

function actualizarManualDeInstrucciones(){
	document.formDeclaracionJurada.accion.value="ActualizarManualDeInstrucciones";
	document.formDeclaracionJurada.submit();	
}
function validarManual(){
	var valido=true;
	var mensaje="";
	var fullPath = document.getElementById('archivo').value;
	if (fullPath) {
		var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
		var filename = fullPath.substring(startIndex);
		if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
			filename = filename.substring(1);
		}
		
		var extension=filename.substring(filename.indexOf('.'),filename.length);
		if(extension!='.pdf'){
			mensaje+="El archivo seleccionado debe ser pdf.";
				valido=false;
		}
		
	}else{
		mensaje+="No se ha seleccionado un archivo.";
		valido=false;
	}
	if(mensaje!=""){
		alert(mensaje);
	}
	return valido;
	
}

function ActualizarManual(){
	if(validarManual()){
		document.formDeclaracionJurada.accion.value="GrabarManualDeInstrucciones";
		document.formDeclaracionJurada.encoding = "multipart/form-data";
		document.formDeclaracionJurada.submit();	
	}
} 

function descargarManualDeInstrucciones(){
	document.formDeclaracionJurada.accion.value="DescargarManualDeInstrucciones";
	document.formDeclaracionJurada.submit();	
}


/* Juan Tomairo - Julio 2016 */

function registrarCitas(){
	document.formDeclaracionJurada.accion.value="RegistrarCitas";
	document.formDeclaracionJurada.submit(); 
}
