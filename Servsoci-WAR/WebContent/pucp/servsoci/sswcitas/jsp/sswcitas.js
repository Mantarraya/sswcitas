/* Registrar Citas*/

function boton_Registrar_Citas(){
	
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
	
	
	/* Descripcion */
	
	cadena=document.formcriterios.comboTramite.item(4).value;
	
	document.formcriterios.descripcion.value=cadena;	
	
	document.formcriterios.encoding = "multipart/form-data";
		
	/* Verificamos que se haya ingresado un archivo*/
	
	cadena = document.formcriterios.file.value;        
    cadena = cadena.substring(cadena.indexOf('.'), cadena.length);

    if (document.formcriterios.file.value == ""){
       alert("Adjunte un archivo excel con extension .xls para continuar con el proceso"); 
       return;
    }
        
    document.formcriterios.accion.value = "InsertarDatosCitas";
    document.formcriterios.submit();
	
}	


/* Activar DJF */

function boton_Activar_DJF(){
	
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
	
    document.formcriterios.accion.value = "InsertarActivacionDJF";
    document.formcriterios.submit();
	
}

/* Asignar citas */

function boton_Asignar_Citas(){
	
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
	
    document.formcriterios.accion.value = "InsertarAsignacionCitas";
    document.formcriterios.submit();
    
}

/* Consultar citas */

function boton_Consultar_Citas(){
	
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

    document.formcriterios.accion.value = "BuscarCitas";
    document.formcriterios.submit();
    
}

/* Boton Exportar */

function boton_Exportar_Citas(){

	document.formcriterios.accion.value = "ExportarCitas";
			
	document.formcriterios.submit();
	
}

}


