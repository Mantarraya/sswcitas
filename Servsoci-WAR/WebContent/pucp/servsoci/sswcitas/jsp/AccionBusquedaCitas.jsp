<%-- 
/**
 * PUCP Copyright (c) 2001 PUCP DIRINFO
 * @author Juan Tomairo
 * Este archivo JSP contiene los criterios para la consulta de asignacion de citas
  --%>
<%@ page contentType="text/html;charset=ISO-8859-1"  %>
<%@ page errorPage="/pucp/lib/jsp/PucpErrorPage.jsp" %>
<%@ page import="pucp.lib.util.PucpLenguaje" %>
<%@ page import="pucp.lib.PucpAplicacion" %>
<%@ page import="pucp.lib.PucpConstant" %>
<%@ page import="pucp.lib.PucpSession" %>

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

</head> 
<BODY bgcolor="#ffffff" topmargin="0" marginwidth="0" marginheight="0">

<jsp:useBean id="comboCiclo" scope="request" class="java.lang.Object" />
<jsp:useBean id="comboTramite" scope="request" class="java.lang.Object" />




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

<form  name="formcriterios" action="sswcitas" method="post">
<input type="hidden" name="accion" value="BuscarCitas"> 
<input type="hidden" name="anio" > 
<input type="hidden" name="ciclo" >
<input type="hidden" name="tramite" >
<input type="hidden" name="descripcion" >


<% String urlCitas = "/pucp/servsoci/sswcitas/sswcitas?accion=BusquedaCitas";  %>

<table align="right" border-width="0" width="20%" >
<tr>
   <td align="center" class = "pucpCeldaMenu"><a class="pucpRefMenu" href="<%=response.encodeURL(urlCitas)%>" onMouseOver="self.status = ''; return true">Consultar citas</a></td>   
</tr>
</table> 

<%-- Boton Regresar --%>

<table border="0" width="100%">
<tr><td width="100%" colspan="3" align="right">
<a href=  "/pucp/servsoci/sswcitas/sswcitas?accion=MostrarInstrucciones" >
<img src="/pucp/lib/images/b_regresar.gif" class="pucpBoton" alt="">
</a>

</td></tr>
</table>

<table class = "pucpTablaTitulo">
<tr><td>
<font class="pucpTitulo" >
     Consultar citas asignadas
</font></td>
<td></td>
</tr>
</table>
<br>



<table class = "pucpTablaSubTitulo" width="100%">
<tr><td><font class = "pucpSubTitulo" > Criterios </font></td> </tr>
</table>

<table width="100%">

<tr>
    <td>   Seleccione un ciclo y un trámite para proceder con la consulta de citas </td>    
  </tr>

</table>



<br>


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
        

<%-- Seleccionar Tramite --%>



	<tr>
      <td width="25%" class="pucpEtiqOblig" width="20%">Tramite</td>
      <%
      Seleccionado="";
      int TipoTramite = 0;
      String pDescripcion = request.getParameter("descripcion");
      //si la pagina se esta recargando, se hace que el combo especialidad conserve su seleccion
      if ( (pDescripcion!=null) && (!pDescripcion.equals("")) ){
         TipoTramite = 1;
         pDescripcion=pDescripcion.trim();
	     Seleccionado=pDescripcion;
       }
      %>
      <td width="50%" class="pucpCampo" width="70%"><%= PucpLenguaje.toHTML(comboTramite,"comboTramite","class='PucpCampo'",Seleccionado)%>&nbsp;</td>
    </tr>        
	 	
</table> 



<br>



<table border="0" width="100%">
<tr><td width="100%" colspan="3" align="center">

<a href=  "javascript:boton_Consultar_Citas();" >
<img src="/pucp/lib/images/b_consultar.gif" class="pucpBoton" alt="">
</a>
<a href=  "/pucp/servsoci/sswcitas/sswcitas?accion=MostrarInstrucciones" >
<img src="/pucp/lib/images/b_regresar.gif" class="pucpBoton" alt="">
</a>

</td></tr>
</table>
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
</form>



<jsp:include page="/pucp/lib/jsp/pucppie.jsp" flush="true"/>
    
</BODY>

</HTML>