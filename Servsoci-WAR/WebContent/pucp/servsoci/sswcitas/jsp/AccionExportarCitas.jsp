<?xml version="1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">



<%@ page contentType="application/vnd.ms-excel" %>
<%@ page errorPage="/pucp/lib/jsp/PucpErrorPage.jsp" %>
<%@ page import="pucp.lib.util.PucpLenguaje" %>
<%@ page import="pucp.lib.PucpAplicacion" %>
<%@ page import="pucp.lib.PucpConstant" %>
<%@ page import="pucp.lib.PucpSession" %>
<%@ page import= java.io.InputStream %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="pucp.lib.exception.PucpException" %>
<%@ page import="pucp.lib.util.PucpLenguaje" %>
<%@ page import="pucp.lib.PucpUsuarioVariables" %>
<%@ page import="java.util.Vector" %>
<%@ page import="pucp.servsoci.beans.CitasAlumnosBeanFunction" %>
<%@ page import="pucp.oca.util.Constantes" %>
<%@ page import="pucp.servsoci.beans.CitasAlumnosBeanData"%>
<%@ page import="pucp.servsoci.beans.ConsultaCitasBeanData"%>

<html xmlns:v="urn:schemas-microsoft-com:vml"
xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/1999/xhtml">

<html>
<head>

<% 
  // Control para guardar el resultado en el cache del browser:    
  response.setHeader("Cache-Control", "");
  response.setHeader("Content-Disposition", "attachment;filename=HorarioDeCitas.xls"  );    
%>

<meta http-equiv="Content-Type" content="application/vnd.ms-excel; charset=ISO-8859-1">
<meta name="GENERATOR" content="Oracle JDeveloper">

<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta name="ProgId" content="Excel.Sheet">
<meta name="Generator" content="Microsoft Excel 9">
<link rel="File-List" href="./general_archivos/filelist.xml">
<link rel="Edit-Time-Data" href="./general_archivos/editdata.mso">
<link rel="OLE-Object-Data" href="./general_archivos/oledata.mso">


<style>
<!--table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:"\,";}
@page
	{margin:0in 0in 0in 0in;
	mso-header-margin:0in;
	mso-footer-margin:0in;}
tr
	{mso-height-source:auto;}
col
	{mso-width-source:auto;}
br
	{mso-data-placement:same-cell;}
.style0
	{mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	white-space:nowrap;
	mso-rotate:0;
	mso-background-source:auto;
	mso-pattern:auto;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:Arial;
	mso-generic-font-family:auto;
	mso-font-charset:0;
	border:none;
	mso-protection:locked visible;
	mso-style-name:Normal;
	mso-style-id:0;}
td
	{mso-style-parent:style0;
	padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:10.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:Arial;
	mso-generic-font-family:auto;
	mso-font-charset:0;
	mso-number-format:General;
	text-align:general;
	vertical-align:bottom;
	border:1px solid black;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl28
	{mso-style-parent:style0;
	font-weight:700;
	font-family:Helvetica, sans-serif;
	mso-font-charset:0;
	text-align:left;
	background:white;
	mso-pattern:auto none;}
.xl31
	{mso-style-parent:style0;
	font-size:8.0pt;
	font-weight:700;
	font-family:Helvetica, sans-serif;
	mso-font-charset:0;
	text-align:left;
	background:white;
	mso-pattern:auto none;
	white-space:normal;}
.xl34
	{mso-style-parent:style0;
	font-size:8.0pt;
	font-family:Helvetica, sans-serif;
	mso-font-charset:0;
	text-align:left;
	border-top:none;
	border-right:.5pt solid silver;
	border-bottom:.5pt solid silver;
	border-left:.5pt solid silver;
	background-color:blue;
	mso-pattern:auto none;
	white-space:normal;}
.xl36
	{mso-style-parent:style0;
	font-size:8.0pt;
	font-family:Helvetica, sans-serif;
	mso-font-charset:0;
	mso-number-format:"\@";
	text-align:center;
	border-top:none;
	border-right:.5pt solid silver;
	border-bottom:.5pt solid silver;
	border-left:none;
	background:white;
	mso-pattern:auto none;
	white-space:normal;}
.xl37
	{mso-style-parent:style0;
	font-size:8.0pt;
	font-family:Helvetica, sans-serif;
	mso-font-charset:0;
	mso-number-format:Fixed;
	text-align:right;
	border-top:none;
	border-right:.5pt solid silver;
	border-bottom:.5pt solid silver;
	border-left:none;
	background:white;
	mso-pattern:auto none;
	white-space:normal;}
.xl38
	{mso-style-parent:style0;
	font-size:8.0pt;
	font-family:Helvetica, sans-serif;
	mso-font-charset:0;
	mso-number-format:0;
	text-align:right;
	border-top:none;
	border-right:.5pt solid silver;
	border-bottom:.5pt solid silver;
	border-left:none;
	background:white;
	mso-pattern:auto none;
	white-space:normal;}
.xl39
	{mso-style-parent:style0;
	font-size:8.0pt;
	font-family:Helvetica, sans-serif;
	mso-font-charset:0;
	mso-number-format:Percent;
	text-align:right;
	border-top:none;
	border-right:.5pt solid silver;
	border-bottom:.5pt solid silver;
	border-left:none;
	background:white;
	mso-pattern:auto none;
	white-space:normal;}
.xl47
	{mso-style-parent:style0;
	font-size:8.0pt;
	font-weight:700;
	font-family:Helvetica, sans-serif;
	mso-font-charset:0;
	text-align:center;
	border-top:.5pt solid silver;
	border-right:.5pt solid silver;
	border-bottom:.5pt solid silver;
	border-left:.5pt solid silver;
	white-space:normal;}
.xl48
	{mso-style-parent:style0;
	font-size:8.0pt;
	font-weight:700;
	font-family:Arial, sans-serif;
	mso-font-charset:0;
	text-align:left;
	border-top:.5pt solid silver;
	border-right:none;
	border-bottom:.5pt solid silver;
	border-left:.5pt solid silver;
	white-space:normal;}
.xl51
	{mso-style-parent:style0;
	font-size:8.0pt;
	font-weight:700;
	font-family:Arial, sans-serif;
	mso-font-charset:0;
	mso-number-format:Fixed;
	text-align:right;
	border-top:.5pt solid silver;
	border-right:.5pt solid silver;
	border-bottom:.5pt solid silver;
	border-left:.5pt solid silver;
	white-space:normal;}
-->
</style>

<!--[if gte mso 9]><xml>
 <o:DocumentProperties>
  <o:LastAuthor></o:LastAuthor>
  <o:Created></o:Created>
  <o:LastSaved></o:LastSaved>
  <o:Version></o:Version>
 </o:DocumentProperties>
 <o:OfficeDocumentSettings>
  <o:DownloadComponents/>
  <o:LocationOfComponents HRef="file:///F:/software/Microsoft/Office%25202000%2520Espanol/cd1/msowc.cab"/>
 </o:OfficeDocumentSettings>
</xml><![endif]-->

<!--[if gte mso 9]><xml>
 <x:ExcelWorkbook>
  <x:ExcelWorksheets>
   <x:ExcelWorksheet>
    <x:Name>Citas.xls</x:Name>
    <x:WorksheetOptions>
     <x:DefaultRowHeight>270</x:DefaultRowHeight>
     <x:DefaultColWidth>10</x:DefaultColWidth>
     <x:Selected/>
     <x:DoNotDisplayGridlines/>
     <x:ProtectContents>False</x:ProtectContents>
     <x:ProtectObjects>False</x:ProtectObjects>
     <x:ProtectScenarios>False</x:ProtectScenarios>
    </x:WorksheetOptions>
   </x:ExcelWorksheet>
  </x:ExcelWorksheets>
  <x:WindowHeight>9150</x:WindowHeight>
  <x:WindowWidth>15360</x:WindowWidth>
  <x:WindowTopX>0</x:WindowTopX>
  <x:WindowTopY>1365</x:WindowTopY>
  <x:ProtectStructure>False</x:ProtectStructure>
  <x:ProtectWindows>False</x:ProtectWindows>
 </x:ExcelWorkbook>
</xml><![endif]-->
</link></link></link></meta></meta></meta></head>

<% if (PucpSession.getVerificar(application, request, response, 0)) { %>
<%-- No esta en sesion --%>
<%} else { %>
<%} %>

<script type="text/javascript" language="JavaScript1.1" src="/pucp/servsoci/sswcitas/jsp/sswcitas.js"> </script>
<title>

</title>
</LINK></html></META></HEAD>


<body bgcolor="#ffffff" topmargin="0" marginwidth="0" marginheight="0">

<jsp:useBean id="vectorResultados" scope="request" class="java.util.Vector" />

<table border="0" width="100%">
  <tr>
  <td class=x131 colspan="3">Horario de citas de alumnos</td>
  </tr>
  <tr></tr>
 
</table>

	  <table border="0" width="200%">
		 <tr>
    <td width="2%" class="x134"><font class="pucpNro">No.</font></td>		 
	<td width="5%" class="pucpCeldaTitulo">Código PUCP</td>
	<td width="20%" class="pucpCeldaTitulo">Apellido paterno </td>
	<td width="2%" class="pucpCeldaTitulo">Apellido materno</td>
	<td width="10%" class="pucpCeldaTitulo">Nombres</td>
	<td width="5%" class="pucpCeldaTitulo">Hora</td>
	<td width="5%" class="pucpCeldaTitulo">Fecha</td>	
	<td  width="5%" class="pucpCeldaTitulo">Lugar</td>
	<td  width="5%" class="pucpCeldaTitulo">Código de la sistenta</td>
	<td  width="5%" class="pucpCeldaTitulo">Nombre de la asistenta</td>	  </tr>
	  
		<%  
			String color = "class=pucpCeldaGris";
		    String colorlink = "class=pucpLinkCeldaGris";
		    String urlPanel = "";
		    int nVectorResultadosSize=vectorResultados.size();
			int i = 0;
			 color = "background-color=white";
		     colorlink = "class=pucpLinkCeldaGris";
			if ( nVectorResultadosSize>0 ){
			
				while ( i < nVectorResultadosSize){ 
				
				ConsultaCitasBeanData BusquedaData = (ConsultaCitasBeanData)vectorResultados.elementAt(i);
		        if(color.equals("background-color=white")) {
		          color = "background-color=black";
		          colorlink = "class=pucpLinkCelda";     }     
		        else {
		          color = "background-color=white";
		          colorlink = "class=pucpLinkCeldaGris"; }
 				  urlPanel = "/pucp/servsoci/sswcitas/sswcitas?accion=InsertarConsultaCitas="+BusquedaData.getCodigoAlumno()+"&acceso=1";

				%>

								<tr>
				  <td class="pucpCelda" width="2%"><font class="pucpNro"><%= (i+1) %></font></td>	
			      <td width="5%" align="left" <%=color%>><%=BusquedaData.getCodigoAlumno() %></td>
				  <td width="5%" align="left" <%=color%>><%=BusquedaData.getApPaterno() %></td>
				  <td width="5%" align="left" <%=color%>><%=BusquedaData.getApMaterno() %></td>
				  <td width="5%" align="left" <%=color%>><%=BusquedaData.getNombres() %></td>

				  <% 
				  String horaCita = BusquedaData.getHoraCita();
				  if (horaCita == null) horaCita = "";
				  else horaCita = ". " + horaCita;
				   %>

				   <% 
				  String fechaCita = BusquedaData.getFechaCita();
				  if (fechaCita == null) fechaCita = "";
				  else fechaCita = ". " + fechaCita;				  
				   %>

				   <% 
				  String lugarCita = BusquedaData.getLugarCita();
				  if (lugarCita == null) lugarCita = "";
				   %>


				  <% 
				  String codigoAsistenta = BusquedaData.getCodigoAsistenta();
				  if (codigoAsistenta == null) codigoAsistenta = "";
				   %>


				    <% 

				  String nombreAsistenta = BusquedaData.getNombreAsistenta();
				  if (nombreAsistenta.trim() == null) nombreAsistenta = "";

				   %>

				  <td width="5%" align="left" <%=color%>><%=horaCita%></td>
				  <td width="5%" align="left" <%=color%>><%=fechaCita %></td>
				  <td width="5%" align="left" <%=color%>><%=lugarCita %></td>
				  <td width="5%" align="left" <%=color%>><%=codigoAsistenta %></td>
				  <td width="5%" align="left" <%=color%>><%=nombreAsistenta %></td>

					
				</tr>


		<%		
			i++;
				}	
			}   %>
	  </table>

</form>

</body>
</HTML></html></html>