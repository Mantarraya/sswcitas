function boton_aceptar_aluPucp(){
	
	document.formcriterios.accion.value = "InsertarDatosCitas";
	
	var cadena=document.formcriterios.comboCiclo.options[document.formcriterios.comboCiclo.selectedIndex].value;
	document.formcriterios.anio.value=cadena.substr(0,4);
	document.formcriterios.ciclo.value=cadena.substr(5,1);
	
	cadena=document.formcriterios.comboTramite.options[document.formcriterios.comboTramite.selectedIndex].value;
	document.formcriterios.tramite.value=cadena;		
	
	document.formcriterios.encoding = "multipart/form-data";
	
	document.formcriterios.submit();
	
	//alert(document.formcriterios.file.value); 
	
	/*
	
    if (document.formcriterios.file.value == ""){
       alert("Debe seleccionar el archivo a cargar"); 
       document.formcriterios.file.select();
    }

    alert(document.formcriterios.file.select());
    
    */

	
}	