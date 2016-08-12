package pucp.servsoci.beans;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

// XLSX FILES
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pucp.lib.PucpBeanFunction;
import pucp.lib.componentes.PucpListaVector;
import pucp.lib.exception.PucpException;
import pucp.lib.util.PucpMultipartRequest;

public class CitasAlumnosBeanFunction extends PucpBeanFunction {
	
	public PucpListaVector LlenaComboCiclos() throws Exception {
		
		try{
			
			/* Obtenemos el combo de ciclos respecto a servicio social */
			
			PucpListaVector comboCiclo = new PucpListaVector();
			comboCiclo.setCon(this.getCon()); /* Conexion */			
			comboCiclo.poblar("SELECT DISTINCT A.CICLOANO||'-'||A.CICLO, A.CICLOANO||'-'||A.CICLO FROM SERVSOCI.CICLOSERVSOCI A ORDER BY 1 DESC");			
			return comboCiclo;
		}catch (Exception exc) {
			throw exc;
		}
		
	}
	


	public PucpListaVector LlenaComboTramites() throws Exception {
		
		try{
			
			/* Obtenemos el combo de tramites respecto a servicio social */
			
			PucpListaVector comboTramite = new PucpListaVector();
			comboTramite.setCon(this.getCon()); /* Conexion */
			comboTramite.poblar("SELECT DISTINCT A.TRAMITE, A.DESCRIPCION FROM SERVSOCI.TRAMITE A ORDER BY 2");			
			return comboTramite;
		}catch (Exception exc) {
			throw exc;
		}
		
	}
	
	
	/* Lectura de archivo excel con extension .xlsx */
	public boolean cargarCitasArchXLSX(InputStream contenido, PucpMultipartRequest multiRequest) throws Exception, SQLException {
		
		XSSFWorkbook  wbook = null;
        int fila = 0, columna = 0;
        boolean finTabla=false;
		boolean insertar=false;
        
        String indice = "";
        String dia = "";
        String hora = "";
        String codigo = "";
        String nombre = "";
        String lugar = "";                     
    
        
        try {        

			wbook = new XSSFWorkbook (contenido);
	        /* Obtenemos la primera hoja del archivo Excel */
			XSSFSheet  sheet = wbook.getSheetAt(0);	        
	        /* Obtenemos la cabecera ubicada en primera fila de la hoja obtenida */
	        XSSFRow row = sheet.getRow(0);
	        
	        /* Si el archivo excel no contiene datos */
	        if (row == null) return false; 
        
	        /* Numero de filas en la hoja */
	        int nTotalFilas = sheet.getPhysicalNumberOfRows();

	        
			   String sAnio = multiRequest.getParameter("anio");
			   String sCiclo = multiRequest.getParameter("ciclo");
			   String sTramite = multiRequest.getParameter("tramite");
	        
	        
	        
	        for (int r = 1; r < nTotalFilas; r++){	 
	        	
	        	//if (r > 1) throw new PucpException("r = " + r);
	        	
	        	/* Guardamos cada fila */
	        	row = sheet.getRow(r);
	        	
	        	/* Verificamos que no sea nula la fila */
	        	if (row == null) break;
	        		
	        	/* Obtenemos la primera celda de la fila */
	        	int nPrimeraCelda = row.getFirstCellNum();
	        	
	        	/* Obtenemos la ultima celda de la fila */
	        	int nUltimaCelda = row.getLastCellNum();
	        	
	        	/* Verificamos que la cantidad de columnas sea correcta */
	        	int nColumnas = nUltimaCelda-nPrimeraCelda;
	        	
	        	/* Recorremos cada celda */
	            XSSFCell cell;
	        	
	        	for (int i = nPrimeraCelda; i < nUltimaCelda; i++){	        			        	
	        		
	        		cell = row.getCell((short)i);	        
	        		
	        		fila = r;
	        		columna = i;

	        		if ((cell != null) && (i <= 5)){	        			
	        			
	        			switch(i){
	        				case 0: indice = obtenValorStringCeldaXSSF(cell); 
	        						break;
	        				case 1: dia = obtenValorStringCeldaDateXSSF(cell);
	        						break;
	        				case 2: hora = obtenValorStringCeldaXSSF(cell);
	        						break;
	        				case 3: codigo = obtenValorStringCeldaXSSF(cell);
	        						break;
	        				case 4: nombre = obtenValorStringCeldaXSSF(cell);
	        						break;
	        				case 5: lugar = obtenValorStringCeldaXSSF(cell);
	        						break;
	        				default: break;
	        			}
	        			
	        		}	        
	        		
	        		if (i==5){	        				        			
	        					        			
	        			hora = dia + " " + hora.substring(0, 5) + ":00";
	        			if (codigo.length() == 4)
	        				codigo = "0000" + codigo;
	        			
	        			insertar = this.insertarCita(sAnio, sCiclo, sTramite, dia, hora, codigo, nombre, lugar); 	
	        			
	        			break;
	        			
	        		}
	        		
		        		
	        	}	        	
	        	    
	            
	        }
	        
        } catch (Exception e) {

        	throw new PucpException(e.getMessage());
		} 
        
		return true;      
    }
	




	public int cargarCitasArchXLS(InputStream contenido, PucpMultipartRequest multiRequest) throws Exception, SQLException {
		
		HSSFWorkbook wbook = null;
        int fila = 0, columna = 0;
        boolean finTabla=false;
		boolean insertar=false;
        
        String indice = "";
        String dia = "";
        String hora = "";
        String codigo = "";
        String nombre = "";
        String lugar = "";            
        
        int r;
    
        
        try {        

			wbook = new HSSFWorkbook(contenido);
	        /* Obtenemos la primera hoja del archivo Excel */
	        HSSFSheet sheet = wbook.getSheetAt(0);	        
	        /* Obtenemos la cabecera ubicada en primera fila de la hoja obtenida */
	        HSSFRow row = sheet.getRow(0);
	        HSSFRow row1 = sheet.getRow(1);
	        HSSFRow row2 = sheet.getRow(2);	        
	        /* Si el archivo excel no contiene datos 
	        if (row == null) return false; 
	        */
        
	        /* Numero de filas en la hoja */
	        int nTotalFilas = sheet.getPhysicalNumberOfRows();	        	       
	        
			String sAnio = multiRequest.getParameter("anio");
			String sCiclo = multiRequest.getParameter("ciclo");
			String sTramite = multiRequest.getParameter("tramite");						
	        
	        for (r = 3; r < nTotalFilas+2; r++){	 
	        	
	        	//if (r > 1) throw new PucpException("r = " + r);
	        	
	        	/* Guardamos cada fila */
	        	row = sheet.getRow(r);
	        	
	        	/* Verificamos que no sea nula la fila */
	        	if (row == null) break;
	        		
	        	/* Obtenemos la primera celda de la fila */
	        	int nPrimeraCelda = row.getFirstCellNum();
	        	
	        	/* Obtenemos la ultima celda de la fila */
	        	int nUltimaCelda = row.getLastCellNum();
	        	
	        	/* Verificamos que la cantidad de columnas sea correcta */
	        	int nColumnas = nUltimaCelda-nPrimeraCelda;
	        	
	        	/* Recorremos cada celda */
	            HSSFCell cell;
	        	
	        	for (int i = nPrimeraCelda; i < nUltimaCelda; i++){	        			        	
	        		
	        		cell = row.getCell((short)i);	        
	        		
	        		/*
	        		if (r > 12)
		        		throw new PucpException("Row = " + r + " - " + row + " cell = " + cell);
	        		*/
	        		fila = r;
	        		columna = i;

	        		if ((cell != null) && (i <= 5)){	        			
	        			
	        			switch(i){
	        				case 0: indice = obtenValorStringCeldaHSSF(cell); 
	        						break;
	        				case 1: dia = obtenValorStringCeldaDateHSSF(cell);
	        						break;
	        				case 2: hora = obtenValorStringCeldaHSSF(cell);
	        						break;
	        				case 3: codigo = obtenValorStringCeldaHSSF(cell);
	        						break;
	        				case 4: nombre = obtenValorStringCeldaHSSF(cell);
	        						break;
	        				case 5: lugar = obtenValorStringCeldaHSSF(cell);
	        						break;
	        				default: break;
	        			}	        				        			
	        			
	        		}
	        		
	        		if (indice == null)
	        			break;
	        		
	        		if (i==5){	        				        			
	        					        			
	        			hora = dia + " " + hora.substring(0, 5) + ":00";
	        			if (codigo.length() == 4)
	        				codigo = "0000" + codigo;
	        			
	        			/*if (r == 3)
	        			throw new PucpException("i = " + i +
	        					" Indice = " + indice + 
								" Dia = " + dia + 
								" Hora = " + hora +
								" Codigo = " + codigo + 
								" Nombre = " + nombre + 
								" Lugar = " + lugar);
	        		
	        			*/
	        			
	        			insertar = this.insertarCita(sAnio, sCiclo, sTramite, dia, hora, codigo, nombre, lugar); 	        			        		
	        			
	        			break;
	        			
	        		}	        		
	        		
		        		
	        	}	        	
	        	
	        	if (indice == null)
	        		break;
	        	    
	            
	        }
	        
        } catch (Exception e) {

        	throw new PucpException(e.getMessage());
		} 
        
		return (r-3);      
    }	

	
	
	private boolean insertarCita(String sAnio, String sCiclo, String sTramite, String dia,
			String hora, String codigo, String nombre, String lugar) throws Exception, SQLException  {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		   
		   String dml = "";
		   
		   /*
		   if (1 == 1)
   			throw new PucpException("Anio = " + sAnio +
   						" Ciclo = " + sCiclo +
   						" sTramite = " + sTramite +
						" Dia = " + dia + 
						" Hora = " + hora +
						" Codigo = " + codigo + 
						" Nombre = " + nombre + 
						" Lugar = " + lugar);
		*/
		
		try{
			
    		rset = null;
       		  
    		dml = "INSERT INTO SERVSOCI.CITASXASIGNAR " +
    			" ( FECHA, HORA, " +
    			"   SECUENCIA, CICLOANO, CICLO, TRAMITE, " +
    			"   INDICAASIGNACION, CODIGOASISTENTA, NOMBREASISTENTA, LUGAR )" +
    			" VALUES " +
    			" ( TO_DATE(?, 'yyyy/MM/dd'), TO_DATE(?, 'yyyy/MM/dd hh24:mi:ss')," +
    			"   SERVSOCI.SEC_CITASXASIGNAR.nextval, ?, ?, ?, " +
    			"   '0', ?, ?, ?)";

    		//dml = "INSERT INTO SERVSOCI.CITASXASIGNAR VALUES (SYSDATE, SYSDATE, SERVSOCI.SEC_CITASXASIGNAR.nextval, ?, ?, ?,  '20162016', 'Asistente', 'Lugar', '1')";
    		
    		
    		pstmt = super.con.prepareStatement(dml);
    		
    		pstmt.setString(1, dia);			
			pstmt.setString(2, hora);			
    		pstmt.setString(3, sAnio);			
			pstmt.setString(4, sCiclo);			
			pstmt.setString(5, sTramite);
    		pstmt.setString(6, codigo);			
			pstmt.setString(7, nombre);			
			pstmt.setString(8, lugar);			

			
	
    		pstmt.executeUpdate();
			
			return true;
			   			
		} catch (Exception e) {
			super.con.rollback();
			throw e;
		} finally {
			if (rset!= null) rset.close();
			if (pstmt!= null) pstmt.close();				 	
		}
		
	}
	/*
	private boolean insertarCita(String cicloAno, String ciclo, String tramite, String dia,
			String hora, String codigo, String nombre, String lugar) throws Exception, SQLException  {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		   
		   String dml = "";
		
		try{
			
    		rset = null;
    		       		  
    		dml = "INSERT INTO SERVSOCI.CITASXASIGNAR VALUES (TO_DATE(dia, 'dd/mm/yyyy'), TO_DATE(hora, 'dd/mm/yyyy hh24:mi:ss'), SERVSOCI.SEC_CITASXASIGNAR.nextval, cicloAno, ciclo, tramite,  codigo, nombre, lugar, '1')";
    		
    		pstmt = super.con.prepareStatement(dml);
	
    		pstmt.executeUpdate();
			
			return true;
			   			
		} catch (Exception e) {
			super.con.rollback();
			throw e;
		} finally {
			if (rset!= null) rset.close();
			if (pstmt!= null) pstmt.close();				 	
		}
		
	}
	*/
	
	/* Obtener valores strings a partir de celdas de un archivo xls */
	public String obtenValorStringCeldaHSSF (HSSFCell cell) throws Exception
	{
		String valor = null;
		try
		{
			switch(cell.getCellType())
			{	case HSSFCell.CELL_TYPE_BLANK:
					valor = null;
					break;
				case HSSFCell.CELL_TYPE_STRING:
					valor = cell.getRichStringCellValue().getString();
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					valor = String.valueOf((long)cell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					valor = Boolean.toString(cell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					valor = Integer.toString((int)cell.getNumericCellValue());
					break;				
				default:
					valor = "ERROR";		// Error de Valor en el Campo
					break;
			}
			return valor;
		}
		catch (Exception exc) {
		    if (con != null && !con.isClosed()) {
		       try { con.rollback();
		       } catch (Exception e) {
		      }
		    }
		throw exc;	
		}
	}	
	
	/* Obtener valores strings a partir de celdas de un archivo xlsx */
	public String obtenValorStringCeldaXSSF (XSSFCell cell) throws Exception
	{
		String valor = null;
		try
		{
			switch(cell.getCellType())
			{	case HSSFCell.CELL_TYPE_BLANK:
					valor = null;
					break;
				case HSSFCell.CELL_TYPE_STRING:
					valor = cell.getRichStringCellValue().getString();
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					valor = String.valueOf((long)cell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					valor = Boolean.toString(cell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					valor = Integer.toString((int)cell.getNumericCellValue());
					break;				
				default:
					valor = "ERROR";		// Error de Valor en el Campo
					break;
			}
			return valor;
		}
		catch (Exception exc) {
		    if (con != null && !con.isClosed()) {
		       try { con.rollback();
		       } catch (Exception e) {
		      }
		    }
		throw exc;	
		}
	}	
	
	public String obtenValorStringCeldaDateXSSF(XSSFCell cell) throws Exception
	{

		try
		{

			
			 String DATE_FORMAT_NOW = "yyyy/MM/dd";
			 Date date = new Date();
			 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			 
			
			date = (cell.getDateCellValue());
			String stringDate = sdf.format(date );

			return stringDate;
		}
		catch (Exception exc) {
		    if (con != null && !con.isClosed()) {
		       try { con.rollback();
		       } catch (Exception e) {
		      }
		    }
		throw exc;	
		}
	}
	
	public String obtenValorStringCeldaDateHSSF(HSSFCell cell) throws Exception
	{

		try
		{

			
			 String DATE_FORMAT_NOW = "yyyy/MM/dd";
			 Date date = new Date();
			 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			 
			
			date = (cell.getDateCellValue());
			String stringDate = sdf.format(date );

			return stringDate;
		}
		catch (Exception exc) {
		    if (con != null && !con.isClosed()) {
		       try { con.rollback();
		       } catch (Exception e) {
		      }
		    }
		throw exc;	
		}
	}
	
	
	
	
	
	
	public boolean foobar(PucpMultipartRequest multiRequest) throws Exception, SQLException {


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		   
		   String dml = "";
				   
		   String sAnio = multiRequest.getParameter("anio");
		   String sCiclo = multiRequest.getParameter("ciclo");
		   String sTramite = multiRequest.getParameter("tramite");
		
		try{
			
    		rset = null;
    		       		  
    		dml = "INSERT INTO SERVSOCI.CITASXASIGNAR VALUES (SYSDATE, SYSDATE, SERVSOCI.SEC_CITASXASIGNAR.nextval, ?, ?, ?,  '20162016', 'nombreA', 'nombreS', '1')";
    		
    		pstmt = super.con.prepareStatement(dml);
   			
    		
    		
			pstmt.setString(1, sAnio);			
			pstmt.setString(2, sCiclo);			
			pstmt.setString(3, sTramite);
    		pstmt.executeUpdate();
			
			return true;
			   			
		} catch (Exception e) {
			super.con.rollback();
			throw e;
		} finally {
			if (rset!= null) rset.close();
			if (pstmt!= null) pstmt.close();				 	
		}

		
	}
	
	
	
	
	
	/* 04/08/2016 */
	
	public CitasAlumnosBeanData obtenerArchivo(PucpMultipartRequest multiRequest)
		throws Exception {
		
		CitasAlumnosBeanData archivoData = null;
		
		try{
			
			InputStream contenidoArch = null;										
			String extensionArch="";
			long tamanioArch = 0;
			
			contenidoArch = multiRequest.getFileContent("archivo");
			extensionArch = multiRequest.getFileExtension("archivo");
			tamanioArch = multiRequest.getFileLength("archivo");		
			
			
		}
		catch (Exception exc) {
			con.rollback();
			throw exc;
		} 
		return archivoData;
		
	}
	


}