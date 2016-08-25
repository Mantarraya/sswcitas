<%-- 
/**
 * PUCP Copyright (c) 2001 PUCP DIRINFO
 * @author Juan Tomairo
 * Este archivo JSP muestra las citas asignadas de los alumnos
  --%>

<%@ page contentType="text/html;charset=ISO-8859-1"  %>
<%@ page import="pucp.lib.PucpAplicacion" %>
<%@ page import="pucp.lib.PucpAplicacionVariables" %>
<%@ page import="pucp.lib.PucpSession" %>
<%@ page import="pucp.lib.PucpConstant" %>
<%@ page import="pucp.lib.PucpAplicacion" %> 
<%@ page import="pucp.lib.PucpAplicacionVariables" %>
<%@ page import="java.util.Vector" %>
<%@ page import="pucp.servsoci.beans.CitasAlumnosBeanFunction" %>
<%@ page import="pucp.oca.util.Constantes" %>
<%@ page import="pucp.servsoci.beans.CitasAlumnosBeanData"%>
<%@ page import="pucp.servsoci.beans.ConsultaCitasBeanData"%>


<% response.setHeader("Cache-Control", ""); %>
<link REL ="stylesheet" TYPE="text/css" HREF="/pucp/lib/jsp/pucp.css">
<link REL ="stylesheet" TYPE="text/css" HREF="/pucp/ambientes/jsp/ambientes.css" >  


<jsp:useBean id="comboCiclo" scope="request" class="java.lang.Object" />
<jsp:useBean id="comboTramite" scope="request" class="java.lang.Object" />
<jsp:useBean id="anio" scope="request" class="java.lang.String" />
<jsp:useBean id="ciclo" scope="request" class="java.lang.String" />
<jsp:useBean id="tramite" scope="request" class="java.lang.String" />
<jsp:useBean id="descripcion" scope="request" class="java.lang.String" />
<jsp:useBean id="vectorResultados" scope="request" class="java.util.Vector" />

<HTML>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
<META NAME="GENERATOR" CONTENT="Oracle JDeveloper">

<link href="/pucp/lib/framework/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="/pucp/lib/jsp/pucp.bootstrap.compatibilidad.css" rel="stylesheet">
<LINK REL ="stylesheet" TYPE="text/css" HREF="../../lib/jsp/pucp.css">
<TITLE>
</TITLE>
<% response.addHeader("Cache-Control","no-cache"); %>
<script type=text/javascript language="JavaScript1.2" src="jsp/sswcitas.js"> </script>
<script type=text/javascript language="JavaScript1.2" src="../../lib/jsp/pucp.js"> </script>

<script type="text/javascript" src="/pucp/lib/js/jquery/jquery-1.9.1.min.js"></script>
<script src="/pucp/lib/framework/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript" language="JavaScript1.2" src="/pucp/general/gewpealu/jsp/enter.js"> </script>
<script type="text/javascript" language="JavaScript1.2" src="/pucp/servsoci/sswcitas/jsp/sswcitas.js"> </script>
<script type="text/javascript" language="JavaScript1.2" src="/pucp/lib/jsp/pucp.js"> </script>
<SCRIPT type="text/javascript" language="JavaScript1.2">
function VerificaCriterios()
{
    var form = document.formcriterios;
    return true;   
}
   
function contieneApostrofes(dato)
{
  if (verificaApostrofe(dato))
    alert("La búsqueda no debe tener comillas simples o dobles.");
}
   
function verificaApostrofe(dato)
{
  val = dato.value;
  var err = 0;
  var cadena = "";
    for(i=0;i<val.length;i++)
    {
      if ((val.charAt(i)== "'") || (val.charAt(i)== "´") || (val.charAt(i)== "\""))
        {
          cadena = val.substr(0, i);
      cadena = cadena + val.substr(i+1);
      i--;
      val = cadena;
          err++;
        }
     }
   if (err > 0)
   {
    dato.value = val;
    return true;
   }
  return false;
}
</SCRIPT>



</head> 

<BODY bgcolor="#ffffff" topmargin="0" marginwidth="0" marginheight="0">



<form method="post" name="formcriterios" id="formcriterios" action="sswcitas" enctype="multipart/form-data"  >

<input type="hidden" name="accion" value="InsertarActivacionDJF"> 
<input type="hidden" name="anio" value="<%=anio%>">
<input type="hidden" name="ciclo" value="<%=ciclo%>">
<input type="hidden" name="tramite" value="<%=tramite%>">
<input type="hidden" name="descripcion"value="<%=descripcion%>">
  
</form>

</table>


<!-- Activar DJF -->

<% String urlCitas = "/pucp/servsoci/sswcitas/sswcitas?accion=ActivarDJF";  %>

<table align="right" border-width="0" width="20%" >
<tr>
   <td align="center" class = "pucpCeldaMenu"><a class="pucpRefMenu" href="<%=response.encodeURL(urlCitas)%>" onMouseOver="self.status = ''; return true">Activar declaración jurada familiar</a></td>   
</tr>
</table> 


<!--  Boton Finalizar -->

<table border="0" width="100%">
<tr><td width="100%" colspan="3" align="right">

<a href=  "/pucp/servsoci/sswcitas/sswcitas?accion=MostrarInstrucciones" >
<img src="/pucp/lib/images/b_finalizar.gif" class="pucpBoton" alt="">
</a>

</table>


<%-- Registrar citas a los nuevos alumnos ingresantes --%>

<table align="right" border-width="0" width="20%" class = "pucpTablaTitulo">
<tr><td>
<font class="pucpTitulo" >
    Consulta de citas asignadas de los alumnos
<td></td>
</tr>
</table>
<br>
<br>










<%  int nVectorResultadosSize = vectorResultados.size(); 
    if (  nVectorResultadosSize==0 ) {
%>

<table class = "pucpTablaSubTitulo"  width="100%">
<tr><td><font class = "pucpSubTitulo">No se encontraron valores para los criterios seleccionados</font></td> </tr>
</table>


<% } else { %>

<table class = "pucpTablaSubTitulo"  width="100%">
<tr><td><font class = "pucpSubTitulo">Resultados de la búsqueda (<%=nVectorResultadosSize%> ocurrencias) </font></td> </tr>
</table>



	  <table border="0" width="100%">
		 <tr>
    <td><font class="pucpNro">No.</font></td>		 
	<td class="pucpCeldaTitulo">Código del alumno</td>
	<td class="pucpCeldaTitulo">Apellido paterno</td>
	<td class="pucpCeldaTitulo">Apellido materno</td>
	<td class="pucpCeldaTitulo">Nombres</td>
	<td class="pucpCeldaTitulo">Hora</td>
	<td class="pucpCeldaTitulo">Fecha</td>	
	<td class="pucpCeldaTitulo">Lugar</td>
	<td class="pucpCeldaTitulo">Código de la sistenta</td>
	<td class="pucpCeldaTitulo">Nombre de la asistenta</td>
	  </tr>
	  
		<%  	
			String color = "class=pucpCeldaGris";
		    String colorlink = "class=pucpLinkCeldaGris";
		    String urlPanel = "", urlEvaluacion="";
			int i = 0;
			 color = "class=pucpCeldaGris";
		     colorlink = "class=pucpLinkCeldaGris";
			if ( nVectorResultadosSize>0 ){
			
				while ( i < nVectorResultadosSize){ 
								
				ConsultaCitasBeanData BusquedaData = (ConsultaCitasBeanData)vectorResultados.elementAt(i); 

		        if(color.equals("class=pucpCeldaGris")) {
		          color = "class=pucpCelda";
		          colorlink = "class=pucpLinkCelda";     }     
		        else {
		          color = "class=pucpCeldaGris";
		          colorlink = "class=pucpLinkCeldaGris"; }
 				  urlPanel = "/pucp/servsoci/sswcitas/sswcitas?accion=InsertarConsultaCitas="+BusquedaData.getCodigoAlumno()+"&acceso=1";
				  urlEvaluacion = "/pucp/servsoci/sswcitas/sswcitas?accion=InsertarConsultaCitas&alumno="+BusquedaData.getCodigoAlumno()+"&anio="+anio+"&ciclo="+ciclo;
				%>
				<tr>
				  <td class="pucpCelda" width="2%"><font class="pucpNro"><%= (i+1) %></font></td>	
			      <td align="left" <%=color%>><%=BusquedaData.getCodigoAlumno() %></td>
				  <td align="left" <%=color%>><%=BusquedaData.getApPaterno() %></td>
				  <td align="left" <%=color%>><%=BusquedaData.getApMaterno() %></td>
				  <td align="left" <%=color%>><%=BusquedaData.getNombres() %></td>
				  <td align="left" <%=color%>><%=BusquedaData.getHoraCita() %></td>
				  <td align="left" <%=color%>><%=BusquedaData.getFechaCita() %></td>
				  <td align="left" <%=color%>><%=BusquedaData.getLugarCita() %></td>
				  <td align="left" <%=color%>><%=BusquedaData.getCodigoAsistenta() %></td>
					
				</tr>
		<%		
			i++;
				}	
			}   %>
	  </table>

<br>

<% }  %>
























 <br>


<!--  Boton Finalizar -->
<table border="0" width="100%">
<tr><td width="100%" colspan="3" align="center">

<a href=  "/pucp/servsoci/sswcitas/sswcitas?accion=MostrarInstrucciones" >
<img src="/pucp/lib/images/b_finalizar.gif" class="pucpBoton" alt="">
</a>


</table>


<br>
<br>
<br>

<table width="98%">
  <tr>
      <td>

  <font class="pucpEtiq"><strong>Importante</strong><br>
  La información ofrecida puede ser utilizada para comunicaciones individuales y con fines académicos. 
  La Pontificia Universidad Católica del Perú NO AUTORIZA su uso para confeccionar bases de datos o generar envíos masivos (SPAM).
  </font>
    </td>
  </tr>
</table> 





<jsp:include page="/pucp/lib/jsp/pucppie.jsp" flush="true"/>
    
</BODY>

</HTML>