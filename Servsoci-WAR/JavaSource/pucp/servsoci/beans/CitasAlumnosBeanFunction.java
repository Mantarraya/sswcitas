package pucp.servsoci.beans;


import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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



	public boolean cargarCitas(InputStream contenido, String cicloAno, String ciclo, String tramite) throws PucpException, SQLException {
		
		HSSFWorkbook wbook = null;
        int fila = 0, columna = 0;
        boolean finTabla=false;
		
        String indice = "";
        String dia = "";
        String hora = "";
        String codigo = "";
        String nombre = "";
        String lugar = "";
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        /* Obtenemos la abreviacion del tramite */
        
        String tramiteAbrev = "";
	    String sSql = "select A.tramite from SERVSOCI.TRAMITE A where trim(A.descripcion) =  trim(tramite)" ;
	    pstmt = con.prepareStatement(sSql);
	    rset= pstmt.executeQuery();
        
        
        
        
        
        try {
        	
			wbook = new HSSFWorkbook(contenido);
		
	        /* Obtenemos la primera hoja del archivo Excel */
	        HSSFSheet sheet = wbook.getSheetAt(0); 
	        /* Obtenemos la cabecera ubicada en primera fila de la hoja obtenida */
	        HSSFRow row = sheet.getRow(0);
	        
	        /* Si el archivo excel no contiene datos */
	        if (row == null){
	        	return false; 
	        }
        
	        /* Numero de filas en la hoja */
	        int nTotalFilas = sheet.getPhysicalNumberOfRows();
        
	        for (int r = 1; r < nTotalFilas; r++){
	        	
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
	        		
	        		fila = r;
	        		columna = i;
	        		
	        		if (cell != null){
	        			
	        			switch(i){
	        				case 0: indice = obtenValorStringCelda(cell); 
	        						break;
	        				case 1: dia = obtenValorStringCelda(cell);
	        						break;
	        				case 2: hora = obtenValorStringCelda(cell);
	        						break;
	        				case 3: codigo = obtenValorStringCelda(cell);
	        						break;
	        				case 4: nombre = obtenValorStringCelda(cell);
	        						break;
	        				case 5: lugar = obtenValorStringCelda(cell);
	        						break;
	        				default: break;
	        			}
	        			
	        		}
	        		else{
	        			finTabla = true;
	        			break;
	        		}
	        			        		
	        	}
	        	
	        	if (finTabla) return true;
	        	else{
	        		
	        		/* Insertar Tabla Temporal Citas */	        		

	        		pstmt = null;
	        		rset = null;
	        		   
	        		String dml = "";
	        		   
	        		dml = "INSERT INTO SERVSOCI.CITASXASIGNAR" +
	        			  "(FECHA, HORA, SECUENCIA, CICLOANO, CICLO, TRAMITE, INDICAASIGNACION, CODIGOASISTENTA, NOMBREASISTENTA, LUGAR) " + 
	       			      " VALUES " +
	       			      "(?, ?, SEC_CITASXASIGNAR.NEXTVAL, cicloAno, ciclo, tramiteAbrev, '0', ?, ?, ?)";

	       			pstmt = con.prepareStatement(dml);
	       			
	       			pstmt.setString(1, dia);
	       			pstmt.setString(2, hora);
	       			pstmt.setString(3, codigo);
	       			pstmt.setString(4, nombre);
	       			pstmt.setString(5, lugar);

	                rset = pstmt.executeQuery();
	        			              
	        	}
	            
	            
	        }
	        
        } catch (Exception e) {
			throw new PucpException(e.getMessage());
		}
        
        
		return true;      
    }
	
	
	public String obtenValorStringCelda (HSSFCell cell) throws Exception
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