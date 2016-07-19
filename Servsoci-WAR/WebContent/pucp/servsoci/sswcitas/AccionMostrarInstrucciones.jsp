<%@ page contentType="text/html;charset=ISO-8859-1"  %>
<%@ page errorPage="/pucp/lib/jsp/PucpErrorPage.jsp" %>
<%@ page import="pucp.lib.PucpAplicacion" %>
<%@ page import="pucp.lib.PucpConstant" %>
<%@ page import="pucp.lib.PucpSession" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>


<% 
  PucpSession.getVerificar(application, request, response, 1);
  PucpAplicacion.getVerificarServicio(application, request, response, 1, "sswdjf", PucpConstant.SER_INGRESAR);
%>


<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1" import="java.sql.*, java.text.*;" errorPage="" >
<META NAME="GENERATOR" CONTENT="Oracle JDeveloper">

<%-- Juan Tomairo - Julio 2016 - Mostrar Instrucciones  --%>

<link href="/pucp/lib/framework/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="/pucp/lib/jsp/pucp.bootstrap.compatibilidad.css" rel="stylesheet">
<LINK REL ="stylesheet" TYPE="text/css" HREF="../../lib/jsp/pucp.css">
<TITLE>
</TITLE>

<% response.addHeader("Cache-Control","no-cache"); %>
<script type=text/javascript language="JavaScript1.2" src="jsp/sswdjf.js"> </script>
<script type=text/javascript language="JavaScript1.2" src="../../lib/jsp/pucp.js"> </script>

<script languaje="javascript">

function fechaCadena(fecha)
{
var options = {weekday: "long", year: "numeric", month: "long", day: "numeric"};
return(fecha.toLocaleDateString("es-PE", options));
}

function habilitaDeshabilita(form)
{
    if (form.boletin.checked == true){
    form.indicamanualdjf.value = "1";
    }
    if (form.boletin.checked == false){
    form.indicamanualdjf.value = "0";
    }
}

function Presionado(){
	document.formDeclaracionJurada.accion.value="Ingresar";
	var valor=document.formDeclaracionJurada.indicamanualdjf.value;
	if ((valor==null) || (valor!="1")) {
		alert('Debe confirmar la lectura para seguir')
		return;
	}
	document.formDeclaracionJurada.submit();
}


function mypopup(tramite){  

	mywindow = window.open("jsp/InstruccionesCitas.pdf", "mywindow", "location=1,status=1,scrollbars=1,  width=100,height=100");  

    mywindow.moveTo(0, 0);  
 }

</script>


<%-- Juan Tomairo - Julio 2016 - Nueva cara Campus Virtual  --%>

<script type="text/javascript" src="/pucp/lib/js/jquery/jquery-1.9.1.min.js"></script>
<script src="/pucp/lib/framework/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</HEAD>

<BODY bgcolor="#ffffff" topmargin="0" marginwidth="0" marginheight="0" >
<jsp:useBean id="declaracionJuradaData" scope="request" class="pucp.servsoci.beans.DeclaracionJuradaBeanData" />
<jsp:useBean id="esPosgrado" scope="request" type="java.lang.String"/>

<form action="<%= response.encodeURL("sswdjf") %>" method="post" name="formDeclaracionJurada">
<input type="hidden" name="accion" value="Ingresar"> 
<input type="hidden" name="cita">
<br>
<br>
<input type="hidden" name="misdatos" value="1"> 
<input type="hidden" name="session" value="<%=PucpSession.getId(application,request,response)%>" >
<input type="hidden" name="codigo" value="<%=declaracionJuradaData.getCodigo()%>" >
<input type="hidden" name="cicloano" value="<%=declaracionJuradaData.getCicloano()%>"> 
<input type="hidden" name="ciclo" value="<%=declaracionJuradaData.getCiclo()%>"> 
<input type="hidden" name="tipociclo" value="<%=declaracionJuradaData.getTipociclo()%>"> 
<input type="hidden" name="nombrecompleto" value="<%=declaracionJuradaData.getNombrecompleto()%>"> 
<input type="hidden" name="indconsultaalumno" value="<%=declaracionJuradaData.getIndconsultaalumno()%>"> 
<input type="hidden" name="editar" value="0">
<input type="hidden" name="estadopag" value="1">
<input type="hidden" name="tramite" value="<%=declaracionJuradaData.getTramite()%>">
<input type="hidden" name="nombretramite" value="<%= declaracionJuradaData.getNombretramite() %>">
<input type="hidden" name="indicamanualdjf" value="<%= request.getParameter("indicamanualdjf") %>">
<input type="hidden" name="naceptodjf" value="<%= request.getParameter("naceptodjf") %>">


<table class="pucpTablaTitulo" width="100%">
<tr >
<td >
<font class="pucpTitulo">OFICINA DE SERVICIOS DE APOYO SOCIAL</font>
</td>
<td align="right">
<button type="button" onclick="javascript:MuestraPanelSeleccionarOpcion()" style="color: #FFFFFF; TEXT-DECORATION: none" class="pucpBoton pucpBotonCorto">Regresar</button>
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

<table class="pucpTablaSubTitulo" width="100%">
<tr >
<td ><font class="pucpSubTitulo">Declaración Jurada Familiar&nbsp;</font></td>
</tr>
</table>
<br>



<%-- Juan Tomairo - Julio 2016 - INSTRUCCIONES --%>

  <TABLE width="70%" border=0 align="center" cellpadding=3 cellspacing=3>
  <tr>
     <td class="pucpValor"><font size="3">
      <b>&#149;&nbsp; Antes de adjuntar el archivo excel le recomendamos leer con detenimiento las INSTRUCCIONES DE USO y llenado del mismo. En caso de que tenga alguna consulta adicional que no pueda solucionar mediante la lectura de este manual le sugerimos enviar su consulta al siguiente correo: decjurada@pucp.edu.pe.</b>
      <br>
      <br><b>&#149;&nbsp; Le recordamos que la Declaracion Jurada Familiar recoge informaci&oacute;n b&aacute;sica para su clasificaci&oacute;n en un grado de la Escala de Becas y Pensiones Diferenciadas por lo cual debe asegurarse de registrar todos los datos relativos a su situacion socioeconomica, la cual seria; refrendada con la documentaci&oacute;n respectiva.</b>
      <br>

  </TD></TR>
    </TABLE>
    
  <br>


<br>    
  <TABLE width="70%" border=0 align="center" cellpadding=3 cellspacing=3>
  <tr><td>
	 <strong>Instrucciones del proceso de llenado de citas </strong>
	<!-- <p>Para descargar el Manual, haga click <a href="javascript:mypopup('<%=declaracionJuradaData.getTramite().trim()%>');">Aqui<br><img src="jsp/imagen_adobe.gif" border="0"></a> --> 
	   	 <p>Para descargar el Manual, haga click <a href="javascript:descargarManualDeInstrucciones();">Aqui<br><img src="jsp/imagen_adobe.gif" border="0"></a> 
	   <br>
	  <br><b><input type="checkbox" name="boletin" value="OFF" unchecked onclick="habilitaDeshabilita(this.form)" >Acepto haber leído y entendido el manual de instrucciones de la DJF </b>
  </TD></TR>
    </TABLE>


<br>
<br>
<p align=center class="pucpLinkMenu"><button type="button" onclick="javascript:Presionado();" class="pucpBoton pucpBotonCorto">Continuar</button>&nbsp;<a href="javascript:MuestraPanelSeleccionarOpcion()" ><IMG src="/pucp/lib/images/b_cancelar.gif" class= "pucpBoton"></a></p>



</form>
<%-- Incluimos el pie que es un html estático --%>
<jsp:include page="/pucp/servsoci/sswdjf/jsp/pucppie.jsp" flush="true"/>
<%-- Fin del pie --%>
</BODY>
</HTML>

