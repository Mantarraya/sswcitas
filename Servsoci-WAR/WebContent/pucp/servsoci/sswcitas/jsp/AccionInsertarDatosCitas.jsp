<%-- 
/**
 * PUCP Copyright (c) 2001 PUCP DIRINFO
 * @author Juan Tomairo
 * Este archivo JSP contiene los criterios de la consulta para el registro de citas 
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


<% response.setHeader("Cache-Control", ""); %>
<link REL ="stylesheet" TYPE="text/css" HREF="/pucp/lib/jsp/pucp.css">
<link REL ="stylesheet" TYPE="text/css" HREF="/pucp/ambientes/jsp/ambientes.css" >  

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

<body onload="">   
<jsp:useBean id="comboCiclo" scope="request" class="java.lang.Object" />
<jsp:useBean id="comboTramite" scope="request" class="java.lang.Object" />

<form  name="formcriterios" action="sswcitas" method="post">
<input type="hidden" name="accion" value="InsertarDatosCitas"> 
<input type="hidden" name="anio" value="<%=request.getParameter("anio") %>"> 
<input type="hidden" name="ciclo" value="<%=request.getParameter("ciclo") %>">
<input type="hidden" name="tramite" value="<%=request.getParameter("tramite") %>">



<%	
String nAnio = request.getParameter("anio");
String sCiclo = request.getParameter("ciclo");
String nTramite = request.getParameter("tramite");

 %>



<table width="98%">
  <tr>
	    <td>

  <font class="pucpEtiq"><strong>InsertarDatosCitas <%=nAnio %> - <%=sCiclo %> - <%=nTramite %></strong><br>
  La información ofrecida puede ser utilizada para comunicaciones individuales y con fines académicos. 
  La Pontificia Universidad Católica del Perú NO AUTORIZA su uso para confeccionar bases de datos o generar envíos masivos (SPAM).
  </font>
    </td>
  </tr>
</table>    
</form>

<br><br>



<jsp:include page="/pucp/lib/jsp/pucppie.jsp" flush="true"/>
    
</BODY>

</HTML>


