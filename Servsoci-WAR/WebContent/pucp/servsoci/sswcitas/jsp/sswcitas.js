function boton_aceptar_aluPucp(){
	
	/* Combo Ciclo */
	var cadena=document.formcriterios.comboCiclo.options[document.formcriterios.comboCiclo.selectedIndex].value;
	document.formcriterios.anio.value=cadena.substr(0,4);
	document.formcriterios.ciclo.value=cadena.substr(5,1);
	
	if (cadena=='' ) {
		alert('Seleccione un ciclo de los mostrados para continuar con el proceso');
		return;		  
	}
	
	/* Combo Tramite */
	
	cadena=document.formcriterios.comboTramite.options[document.formcriterios.comboTramite.selectedIndex].value;
	document.formcriterios.tramite.value=cadena;		
	
	if (cadena=='' ) {
		alert('Seleccione un tramite de los mostrados para continuar con el proceso');
		return;		  
	}
	
	
	document.formcriterios.encoding = "multipart/form-data";
	
	
	/* Verificamos que sea un archivo excel con extension .xls */
	
	cadena = document.formcriterios.file.value;        
    cadena = cadena.substring(cadena.indexOf('.'), cadena.length);

    if (document.formcriterios.file.value == "" || cadena != '.xls'){
       alert("Adjunte un archivo excel con extension .xls"); 
       return;
    }
    
    
    
    document.formcriterios.accion.value = "InsertarDatosCitas";

    
    document.formcriterios.submit();

	
}	