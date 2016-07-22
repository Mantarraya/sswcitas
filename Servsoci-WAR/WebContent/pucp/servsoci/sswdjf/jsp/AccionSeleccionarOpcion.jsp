<%@ page contentType="text/html;charset=ISO-8859-1"  %>
<%@ page errorPage="/pucp/lib/jsp/PucpErrorPage.jsp" %>
<%@ page import="pucp.lib.util.PucpLenguaje" %>
<%@ page import="pucp.lib.PucpAplicacion" %>
<%@ page import="pucp.lib.PucpConstant" %>
<%@ page import="pucp.lib.PucpSession" %>

<% 
  PucpSession.getVerificar(application, request, response, 1);
  PucpAplicacion.getVerificarServicio(application, request, response, 1, "sswdjf", PucpConstant.SER_INGRESAR);
%>

<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
<META NAME="GENERATOR" CONTENT="Oracle JDeveloper">

<%-- JPB MAR 2016 - Cambios Browser  --%>
<%-- Nueva cara del Campus Virtual   --%>
<link href="/pucp/lib/framework/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="/pucp/lib/jsp/pucp.bootstrap.compatibilidad.css" rel="stylesheet">
<LINK REL=STYLESHEET TYPE="text/css" HREF="/pucp/lib/jsp/pucp.css">


<TITLE>
</TITLE>
<% response.addHeader("Cache-Control","no-cache"); %>
<script type=text/javascript language="JavaScript1.2" src="jsp/sswdjf.js"> </script>
<script type=text/javascript language="JavaScript1.2" src="../../lib/jsp/pucp.js"> </script>

<%-- JPB MAR 2016 - Cambios Browser  --%>
<%-- Nueva cara del Campus Virtual   --%>
<script type="text/javascript" src="/pucp/lib/js/jquery/jquery-1.9.1.min.js"></script>
<script src="/pucp/lib/framework/bootstrap/3.3.5/js/bootstrap.min.js"></script>


</head> 

<BODY bgcolor="#ffffff" topmargin="0" marginwidth="0" marginheight="0" >
 
<jsp:useBean id="declaracionJuradaData" scope="request" class="pucp.servsoci.beans.DeclaracionJuradaBeanData" />
<jsp:useBean id="vectorCiclo" class="java.lang.Object" scope="request" /> 
<jsp:useBean id="esAlumno" class="java.lang.String" scope="request" /> 

<form action="<%= response.encodeURL("sswdjf") %>" method="post" name="formDeclaracionJurada">

<input type="hidden" name="accion" value="Ingresar"> 
<input type="hidden" name="codigo" value=<%=declaracionJuradaData.getCodigo()%>>
<input type="hidden" name="nombrecompleto" value=<%=declaracionJuradaData.getNombrecompleto()%>>
<input type="hidden" name="misdatos" value="1"> 
<input type="hidden" name="session" value="<%=PucpSession.getId(application,request,response)%>" >
<input type="hidden" name="alumno" value="<%=declaracionJuradaData.getCodigo()%>" >
<input type="hidden" name="cicloano" value="<%=declaracionJuradaData.getCicloano()%>"> 
<input type="hidden" name="ciclo" value="<%=declaracionJuradaData.getCiclo()%>"> 
<input type="hidden" name="tipociclo" value="<%=declaracionJuradaData.getTipociclo()%>"> 
<input type="hidden" name="editar" value="0">
<input type="hidden" name="estadopag" value="1">
<input type="hidden" name="tramite" value="<%=declaracionJuradaData.getTramite()%>">
<input type="hidden" name="nombretramite" value="<%= declaracionJuradaData.getNombretramite() %>">
<input type="hidden" name="cambioTramite" value=<%=request.getParameter("cambioTramite")%>">
<input type="hidden" name="indicamanualdjf" value="<%= request.getParameter("indicamanualdjf") %>">
<input type="hidden" name="naceptodjf" value="<%= request.getParameter("naceptodjf") %>">
<input type="hidden" name="esAlumno" value="<%= esAlumno%>">
<br>
<br>

<%--  Juan Tomairo - Julio 2016 --%>
<% 
String urlCitas = "/pucp/servsoci/sswcitas/sswcitas?accion=RegistrarCitas"; 
if(!esAlumno.equals("1")){ %>
<table align="right" border-width="0" width="50%" >
<tr>

   <td align="center" class = "pucpCeldaMenu"><a class="pucpRefMenu" href="<%=response.encodeURL(urlCitas)%>"   onMouseOver="self.status = ''; return true">Registrar citas</a></td>
   <td align="center" class = "pucpCeldaMenu"><a class="pucpRefMenu" href="javascript:actualizarManualDeInstrucciones()" onMouseOver="self.status = ''; return true">Actualizar manual de instrucciones</a></td>
   <td align="center" class = "pucpCeldaMenu"><a class="pucpRefMenu" href="javascript:actualizarManualDJFPorTipo()" onMouseOver="self.status = ''; return true">Actualizar formato de aceptacion de escala 5</a></td>
	

</tr>
</table> 
<br>
<%} %>
<table class="pucpTablaTitulo" width="100%">
<tr >
	<td ><font class="pucpTitulo">OFICINA DE SERVICIOS DE APOYO SOCIAL</font></td>
	<td align="right">
		<button type="button" onclick="javascript:MuestraPanelDJF()" style="color: #FFFFFF; TEXT-DECORATION: none" class="pucpBoton pucpBotonCorto">Regresar</button>
	</td>
</tr>
</table>

<DIV ALIGN="right">
<TABLE class="pucpTablaTitulo" width="100%">
  <tr>
    <TD ALIGN="left" class="pucpInfReg"><%= declaracionJuradaData.getNombrecompleto() %></TD>
  </tr>
</table>
</DIV>

<table class="pucpTablaSubTitulo" width="100%" >
<tr>
	<td><font class="pucpSubTitulo">Declaración Jurada Familiar - Pregrado&nbsp;</font></td>
</tr>
</table>
<br>
<table>
<tr>
	<td class="pucpEtiqEdicion" width="20%">Trámite:</td> 
 
	<td ><font class="pucpTitulo"><%= PucpLenguaje.toHTML(vectorCiclo,"desciclo","class='PucpCampo' onchange='ActualizaCicloSeleccionaOpcion();'",declaracionJuradaData.getDesciclo())%></font></td>

</tr>
</table>
<br>
<table align="center" width="30%">
<tr>
	<td width="20%" align="center"><img src="/pucp/lib/images/i_datos.gif"></a></td>
	<td width="80%" ><a href="javascript:MuestraPanelCrearDeclaracion();" class="pucpLink">1. Ingreso a la Declaración Jurada Familiar</a></td>
</tr>
<tr>
	<td width="20%" align="center"><img width="32" heigh="35" src="/pucp/lib/images/i_pdf.gif"></a></td>
	<td width="80%" ><a href="javascript:descargarManualDeInstrucciones();" class="pucpLink">2. Manual de Instrucciones de la DJF</a></td>
</tr>
<tr>
	<td width="20%" align="center"><img src="/pucp/lib/images/i_datos1.gif"></a></td>
	<td width="80%" ><a href="javascript:BuscarDocumentoDJF();" class="pucpLink">3. Documentos requeridos por la asistenta social</a></td>
</tr>
<tr>
	<td width="20%" align="center"><img src="/pucp/lib/images/i_preguntas.gif"></a></td>
	<td width="80%" ><a href="javascript:abrirPreguntasFrecuentes();" class="pucpLink">4. Preguntas frecuentes</a></td>	
</tr>
</table>
<br>
<br>
<table align="center">
<tr>
	<td><button type="button" onclick="javascript:MuestraPanelDJF()" style="color: #FFFFFF; TEXT-DECORATION: none" class="pucpBoton pucpBotonCorto">Regresar</button></td>
</tr>
</table>
<br>
<br>
</form>
<%-- Incluimos el pie que es un html estático --%>
<jsp:include page="/pucp/servsoci/sswdjf/jsp/pucppie.jsp" flush="true"/>
<%-- Fin del pie --%>
</BODY>
</HTML>
