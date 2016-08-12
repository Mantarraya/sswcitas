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



<jsp:useBean id="comboCiclo" scope="request" class="java.lang.Object" />
<jsp:useBean id="comboTramite" scope="request" class="java.lang.Object" />
<jsp:useBean id="anio" scope="request" class="java.lang.String" />
<jsp:useBean id="ciclo" scope="request" class="java.lang.String" />
<jsp:useBean id="tramite" scope="request" class="java.lang.String" />

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

<input type="hidden" name="accion" value="InsertarDatosCitas"> 
<input type="hidden" name="anio" value="<%=anio%>">
<input type="hidden" name="ciclo" value="<%=ciclo%>">
<input type="hidden" name="tramite" value="<%=tramite%>">






   
</form>




</td></tr>
</table>


<br>
<br>



<%-- Panel de asignacion de citas --%>
<% 
String urlCitas = "/pucp/servsoci/sswcitas/sswcitas?accion=RegistrarCitas"; 
%>
<table align="right" border-width="0" width="50%" >
<tr>

   <td align="center" class = "pucpCeldaMenu"><a class="pucpRefMenu" href="<%=response.encodeURL(urlCitas)%>" 
       onMouseOver="self.status = ''; return true">Registrar citas</a></td>

   <td align="center" class = "pucpCeldaMenu"><a class="pucpRefMenu" href="<%=response.encodeURL(urlCitas)%>" 
       onMouseOver="self.status = ''; return true">Activar declaración jurada familiar</a></td>

   <td align="center" class = "pucpCeldaMenu"><a class="pucpRefMenu" href="<%=response.encodeURL(urlCitas)%>" 
       onMouseOver="self.status = ''; return true">Asignar citas</a></td> 

   <td align="center" class = "pucpCeldaMenu"><a class="pucpRefMenu" href="<%=response.encodeURL(urlCitas)%>" 
       onMouseOver="self.status = ''; return true">Exportar citas</a></td>             

</tr>
</table> 
<br>

<!--  Boton Regresar -->
<table border="0" width="100%">
<tr><td width="100%" colspan="3" align="right">
<a href= "javascript:history.back();" >
<img src="/pucp/lib/images/b_regresar.gif" class="pucpBoton" alt="">
</a>

<table width="98%">


<%-- Registrar citas a los nuevos alumnos ingresantes --%>

<table align="right" border-width="0" width="20%" class = "pucpTablaTitulo">
<tr><td>
<font class="pucpTitulo" >
     OFICINA DE SERVICIO DE APOYO SOCIAL
</font></td>
<td></td>
</tr>
</table>

<DIV ALIGN="right">
<TABLE class="pucpTablaTitulo" width="100%">
  <tr>
    <TD ALIGN="left" class="pucpInfReg">Panel de asignación de citas</TD>
  </tr>
</table>
</DIV>

<table class = "pucpTablaSubTitulo" width="100%">
<tr><td><font class = "pucpSubTitulo" > Indicaciones </font></td> </tr>
</table>

<br>

<table align="center" width="30%">
<tr>

	<td width="80%" >1. Registrar citas a los nuevos alumnos ingresantes</td>
</tr>
<tr>
	
	<td width="80%" >2. Activar declaracion jurada familiar</td>
</tr>
<tr>
	
	<td width="80%" >3. Asignar citas</td>
</tr>
<tr>
	
	<td width="80%" >4. Exportar citas</td>	
</tr>
</table>


 <br>


<!--  Boton Regresar -->
<table border="0" width="100%">
<tr><td width="100%" colspan="3" align="center">


<a href=  "/pucp/servsoci/sswcitas/sswcitas?accion=RegistrarCitas" >
<img src="/pucp/lib/images/b_continuar.gif" class="pucpBoton" alt="">
</a>
<a href= "javascript:history.back();" >
<img src="/pucp/lib/images/b_regresar.gif" class="pucpBoton" alt="">
</a>

</td></tr>
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
