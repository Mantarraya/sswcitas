<%-- 
/**
 * PUCP Copyright (c) 2001 PUCP DIRINFO
 * @author Juan Tomairo
 * Este archivo JSP contiene los criterios de la consulta para el registro de citas 
  --%>
<%@ page contentType="text/html;charset=ISO-8859-1"  %>
<%@ page errorPage="/pucp/lib/jsp/PucpErrorPage.jsp" %>
<%@ page import="pucp.lib.PucpSession" %>
<%@ page import="pucp.lib.util.PucpLenguaje" %>


<HTML>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
<META NAME="GENERATOR" CONTENT="Oracle JDeveloper">

<%-- JPB MAR 2016 - Cambios Browser  --%>
<%-- Nueva cara del Campus Virtual   --%>
<link href="/pucp/lib/framework/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="/pucp/lib/jsp/pucp.bootstrap.compatibilidad.css" rel="stylesheet">
<LINK REL ="stylesheet" TYPE="text/css" HREF="../../lib/jsp/pucp.css">
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
<BODY bgcolor="#ffffff" topmargin="0" marginwidth="0" marginheight="0">
<jsp:useBean id="comboCiclo" scope="request" class="java.lang.Object" />

<br>
<table class = "pucpTablaTitulo">
<tr><td>
<font class="pucpTitulo" >
     Registar citas a los nuevos alumnos ingresantes:
</font></td>
<td></td>
</tr>
</table>
<br>

<table class = "pucpTablaSubTitulo"  width="100%">
<tr><td><font class = "pucpSubTitulo">Criterios:</font></td> </tr>
</table>

<form  name="formcriterios" action="cewpanel" method="post">
<input type="hidden" name="accion" value="RegistrarCitas"> 
<input type="hidden" name="anio" > 
<input type="hidden" name="ciclo" >
<input type="hidden" name="tramite" >


<%-- Seleccionar Ciclo (anio - numero ciclo)   --%>

<table width="100%">
    <tr>
      <td width="25%" class="pucpEtiqOblig" width="20%">Ciclo</td>
      <%
      String Seleccionado="";
      int CicloOk=0;
      String pAnio=request.getParameter("anio");
      String pCiclo=request.getParameter("ciclo");
      //si la pagina se esta recargando, se hace que el combo especialidad conserve su seleccion
      if ( (pAnio!=null) && (!pAnio.equals("")) && (pCiclo!=null) && (!pCiclo.equals("")) ){
         CicloOk = 1;
         pAnio=pAnio.trim();
         pCiclo = pCiclo.trim();
	     Seleccionado=pAnio+"-"+pCiclo;
       }
      %>
      <td width="50%" class="pucpCampo" width="70%"><%= PucpLenguaje.toHTML(comboCiclo,"comboCiclo","class='PucpCampo'",Seleccionado)%>&nbsp;</td>
    </tr>


</table>
<br>

<%-- Seleccionar Tramite --%>

<table width="100%">
    <tr>
      <td width="25%" class="pucpEtiqOblig" width="20%">Tramite</td>      
      <td width="50%" class="pucpCampo" width="70%"><%= PucpLenguaje.toHTML(comboCiclo,"comboCiclo","class='PucpCampo'",Seleccionado)%>&nbsp;</td>
    </tr>

</table>
<br>

<%-- Adjuntar Excel - Examinar --%>

<table>
      <tr>
      <td><font class="pucpEtiqOblig">Archivo:</font></td>
    	<td><input type="file" name="file" size="60">
		</td>
	 </tr>		
</table> 







<table border="0" width="100%">
<tr><td width="100%" colspan="3" align="center">

<a href=  "javascript:registrar_citas();">
<img src="/pucp/lib/images/b_buscar.gif" class="pucpBoton" alt="">
</a>
<a href= "javascript:history.back();" >
<img src="/pucp/lib/images/b_regresar.gif" class="pucpBoton" alt="">
</a>

</td></tr>
</table>
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
</form>

<br><br>

<jsp:include page="/pucp/lib/jsp/pucppie.jsp" flush="true"/>
    
</BODY>

</HTML>
