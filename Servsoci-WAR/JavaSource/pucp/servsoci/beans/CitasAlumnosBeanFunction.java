package pucp.servsoci.beans;
// Bean Function de citas

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

/* XLS FILES */
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
			comboTramite.poblar("SELECT DISTINCT A.TRAMITE, A.DESCRIPCION FROM SERVSOCI.TRAMITE A WHERE A.INDICTIPTRAM = '1' ORDER BY 2");			
			return comboTramite;
		}catch (Exception exc) {
			throw exc;
		}
		
	}	
	
	/* Leer archivo excel con extension xls */

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


	/* 11/08/2016 */

	public boolean activarDJF(HttpServletRequest request) throws Exception {		
		
		try{
			
			String sAnio = request.getParameter("anio");
			String sCiclo = request.getParameter("ciclo");
			String sTramite = request.getParameter("tramite");  
			
			/* Obtenemos el tipo grupo apartir del tramite */
			
			String tipoGrupo = obtenerTipoGrupo(sTramite);
			
			return true;
			   			
		} catch (Exception e) {
			throw e;
		}
	}



	public String obtenerTipoGrupo(String tramite) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		   
		String tipogrupo = "";
		String dml = "";

		
		try{
			
    		rset = null;
       		  
    		dml = "SELECT A.TIPOGRUPO FROM SERVSOCI.TRAMPROVXTIPOGRUPO A " +
    			  "WHERE A.TRAMITE = ?";   		
    		pstmt = con.prepareStatement(dml);
    		pstmt.setString(1, tramite);
    	    rset=pstmt.executeQuery();

    		

    	    if (!rset.next() ){
    	        throw new PucpException("Tramite no encontrado del tipo de ingreso seleccionado") ;
    	    }
    	    else{
    	    	tipogrupo = rset.getString(1);
    	    }      		
    		
    		
			return tipogrupo;
			   			
		} catch (Exception e) {
			super.con.rollback();
			throw e;
		} finally {
			if (rset!= null) rset.close();
			if (pstmt!= null) pstmt.close();				 	
		}
		
	}



	public String obtenerDescripcion(String tramite) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		   
		String descripcion = "";
		String dml = "";

		
		try{
			
    		rset = null;    		    		
       		  
    		dml = "SELECT A.DESCRIPCION FROM SERVSOCI.TRAMITE A " +
    			  "WHERE A.TRAMITE = ?";   		
    		pstmt = con.prepareStatement(dml);
    		pstmt.setString(1, tramite);
    	    rset=pstmt.executeQuery();
    		
    					
    		

    	    if (!rset.next() ){
    	        throw new PucpException("Error en la lectura de la descripcion de tramite: " + tramite) ;
    	    }
    	    else{
    	    	descripcion = rset.getString(1);
    	    }       		
    		
    		
			return descripcion;
			   			
		} catch (Exception e) {
			super.con.rollback();
			throw e;
		} finally {
			if (rset!= null) rset.close();
			if (pstmt!= null) pstmt.close();				 	
		}
	}



	public void eliminarCitas(String anio, String ciclo, String tramite) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		   
		String dml = "";

		
		try{
			
    		rset = null;        		
    		       		  
    		dml = "DELETE FROM SERVSOCI.CITASXASIGNAR A " +
    			  "WHERE A.CICLOANO = ? AND A.CICLO = ? AND A.TRAMITE = ?";   		
    		pstmt = this.con.prepareStatement(dml);
			pstmt.setString(1,anio);   
			pstmt.setString(2,ciclo);
			pstmt.setString(3,tramite);
			pstmt.executeUpdate();


			   			
		} catch (Exception e) {
			super.con.rollback();
			throw e;
		} finally {
			if (rset!= null) rset.close();
			if (pstmt!= null) pstmt.close();				 	
		}
	}



	public void insertarAlumnoDJF(String anio, String ciclo, String tipogrupo) throws PucpException {
		
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		
		try{
			
			
			String dml = " INSERT INTO SERVSOCI.ALUMNODJF (ALUMNO) " +
						 " SELECT A.ALUMNO " +
						 " FROM OCR.INGRESOXALUMNO A, OCR.ALUMNOXCICLO_P B " + 
			             " WHERE A.CICLOANO = ? AND A.CICLO = ('0'||?) AND A.TIPOCICLO = '00' AND A.TIPOGRUPO IN (?) " +
			             " AND B.ALUMNO=A.ALUMNO AND B.CICLOANO=A.CICLOANO " + 
			             " AND B.CICLO=A.CICLO AND B.TIPOCICLO=A.TIPOCICLO " +
			             " AND A.ALUMNO NOT IN (SELECT ALUMNO FROM SERVSOCI.ALUMNODJF) ";						
			
			pstmt = con.prepareStatement(dml);
			
			pstmt.setInt(1, Integer.parseInt(anio));
			pstmt.setString(2, ciclo);
			pstmt.setString(3, tipogrupo);
			
			pstmt.executeUpdate();
						
		}catch(Exception e){
			throw new PucpException(" Error al grabar alumnos en la declaración jurada familiar: "+ e.getMessage());
		}finally{
			try {if(rset!=null) rset.close();} catch(Exception er){}
			try {if(pstmt!=null) pstmt.close();} catch(Exception er){}
		}
		
		
	}



	public void insertarDJF(String anio, String ciclo, String tramite,
			String tipogrupo) throws PucpException {
		
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		
		try{
			
			String dml = " INSERT INTO SERVSOCI.DECLARACIONJURADAFAMILIAR (ALUMNO,CICLOANO,CICLO,TIPOCICLO,TRAMITE,FECHAAPERTURA,INDICAACTIVO) " +
						 " SELECT A.ALUMNO,A.CICLOANO,'1','0','TB',SYSDATE,'1' " +
						 " FROM OCR.INGRESOXALUMNO A, OCR.ALUMNOXCICLO_P B " +
						 " WHERE A.CICLOANO = ? AND A.CICLO = ('0'||?) AND A.TIPOCICLO = '00' " +
						 " AND A.TIPOGRUPO IN (?) AND B.ALUMNO=A.ALUMNO " +
						 " AND B.CICLOANO=A.CICLOANO  AND B.CICLO=A.CICLO AND B.TIPOCICLO=A.TIPOCICLO " +
						 " AND A.ALUMNO NOT IN (SELECT ALUMNO FROM SERVSOCI.DECLARACIONJURADAFAMILIAR WHERE CICLOANO = ? AND CICLO = ? AND TRAMITE = ?) ";
			
			pstmt = con.prepareStatement(dml);
			
			pstmt.setInt(1, Integer.parseInt(anio));
			pstmt.setString(2, ciclo);
			pstmt.setString(3, tipogrupo);
			pstmt.setInt(4, Integer.parseInt(anio));
			pstmt.setString(5, ciclo);
			pstmt.setString(6, tramite);
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			throw new PucpException(" Error al grabar en la declaración jurada familiar: "+ e.getMessage());
		}finally{
			try {if(rset!=null) rset.close();} catch(Exception er){}
			try {if(pstmt!=null) pstmt.close();} catch(Exception er){}
		}
		
		
	}



	public void insertarAlumnoDJFxTramitexCiclo(String anio, String ciclo,
			String tramite) throws PucpException {
		
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		
		try{
			
			String dml = " INSERT INTO SERVSOCI.ALUMNODJFXTRAMITEXCICLO " + 
						 " (ALUMNO, TRAMITE, CICLOANO, TIPOCICLO, CICLO,  FECHAINICIOPUBLICACION, FECHAFINPUBLICACION) " + 
			             " SELECT ALUMNO, TRAMITE, CICLOANO, TIPOCICLO, CICLO,  SYSDATE FECHAINICIOPUBLICACION, SYSDATE +30 FECHAFINPUBLICACION " +
			             " FROM SERVSOCI.DECLARACIONJURADAFAMILIAR " +
			             " WHERE TRAMITE = ? AND CICLOANO = ? AND CICLO = ? AND TIPOCICLO = '0' " +
			             " AND ALUMNO NOT IN (SELECT ALUMNO FROM SERVSOCI.ALUMNODJFXTRAMITEXCICLO " +
			             " WHERE TRAMITE = ? AND CICLOANO = ? AND CICLO = ? AND TIPOCICLO = '0') ";
			
			
			
			pstmt = con.prepareStatement(dml);
			

			pstmt.setString(1, tramite);
			pstmt.setInt(2, Integer.parseInt(anio));
			pstmt.setString(3, ciclo);
			pstmt.setString(4, tramite);
			pstmt.setInt(5, Integer.parseInt(anio));
			pstmt.setString(6, ciclo);
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			throw new PucpException(" Error al grabar en la declaración jurada familiar: "+ e.getMessage());
		}finally{
			try {if(rset!=null) rset.close();} catch(Exception er){}
			try {if(pstmt!=null) pstmt.close();} catch(Exception er){}
		}		
		
		
		
		
	}



	public void insertarEstudiosxAlumnoDJF(String anio, String ciclo,
			String tramite) throws PucpException {
		
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		
		try{
			
			String dml = " INSERT INTO SERVSOCI.ESTESCODPERDJF " +
			             " SELECT A.CODIGO,A.ANOING,A.IDENCOLEGIO,B.TIPOCOLEGIO,A.COLMODAL,A.COLEGIO,A.ANOFIN,A.INDPRISEC, " +
			             " A.ULTIMOANO,A.DESCRICOLEGIO,E.DESCRIPCION, " +
			             " F.DESCRIPCION,G.DESCRIPCION,C.RESIPAIS,NULL " + 
			             " FROM GENERAL.ESTESCODPER A, GENERAL.COLEGIO B, " +
			             " GENERAL.PERSONA C, GENERAL.PAIS D, GENERAL.DEPARTPAIS E, GENERAL.PROVIPAIS F, " +
			             " GENERAL.UBIGEO G, SERVSOCI.DECLARACIONJURADAFAMILIAR H " +
			             " WHERE B.COLEGIO=A.COLEGIO AND C.CODIGO=A.COLEGIO " + 
			             " AND D.PAIS=C.RESIPAIS AND E.DEPARTPAIS=C.RESIDEPART AND F.DEPARTPAIS=C.RESIDEPART AND " +
			             " F.PROVIPAIS=C.RESIPROVI AND G.DEPARTPAIS=C.RESIDEPART AND G.PROVIPAIS=C.RESIPROVI " +
			             " AND G.DISTRITO=C.RESIDISTRITO AND H.TRAMITE = ? AND H.ALUMNO=A.CODIGO " +
			             " AND H.CICLOANO = ? AND H.CICLO = ? AND A.CODIGO NOT IN (SELECT ALUMNO FROM SERVSOCI.ESTESCODPERDJF) ";
						
			pstmt = con.prepareStatement(dml);

			pstmt.setString(1, tramite);
			pstmt.setInt(2, Integer.parseInt(anio));
			pstmt.setString(3, ciclo);
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			throw new PucpException(" Error al grabar en los estudios por alumno: "+ e.getMessage());
		}finally{
			try {if(rset!=null) rset.close();} catch(Exception er){}
			try {if(pstmt!=null) pstmt.close();} catch(Exception er){}
		}		
				
	}



	public void asignarCitas(String anio, String ciclo, String tramite) throws PucpException {
		
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		
		try{
			
			CallableStatement ocs = super.con.prepareCall("{(call servsoci.pq_sswcitas.p_AsignarCitas(?, ?, ?)}");
		    ocs.setInt(1, Integer.parseInt(anio));
		    ocs.setString(2, ciclo);
		    ocs.setString(3, tramite); 
		      
		    ocs.execute();      
		    ocs.close();
			
		}catch(Exception e){
			throw new PucpException(" Error al grabar en asignacion de citas: "+ e.getMessage());
		}finally{
			try {if(rset!=null) rset.close();} catch(Exception er){}
			try {if(pstmt!=null) pstmt.close();} catch(Exception er){}
		}				
		
	}

	
	public Vector consultarCitasAlumnos(String v_anio, String v_ciclo, String v_tramite)
	throws SQLException, Exception {
		

		Vector vAlumnos = new Vector();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query="";
		
		try {
			
			
			query =
		        " select a.alumno, b.apePaterno, b.apeMaterno, b.nombres, horacita, TO_CHAR(fechacita, 'dd/mm/yyyy'), lugarcita, asistenta , (g.apepaterno || ' ' ||  g.apematerno || ' ' || g.nombres) " + 
		        " from servsoci.alumnodjf a, general.personatural b, servsoci.declaracionjuradafamiliar c, ocr.alumnoxciclo_p d, general.facultad e, ocr.especialidad f, general.personatural g " +
		        " where b.codigo = a.alumno " + 
		        " and c.alumno = a.alumno and c.cicloano  = ? and c.ciclo = ? and c.tipociclo = '0' and c.tramite = ? " +
		        " and d.alumno = c.alumno and d.cicloano = c.cicloano and d.ciclo = '0'||c.ciclo and d.tipociclo = '00' " + 
		        " and e.facultad = d.facultad and f.rama = d.rama and f.especialidad = d.especialidad " +
		        "  and g.codigo (+)= a.asistenta " +
		        " order by B.APEPATERNO, B.APEMATERNO, B.NOMBRES ";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, Integer.parseInt(v_anio));
			pstmt.setString(2, v_ciclo);
			pstmt.setString(3, v_tramite);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()){
				
				ConsultaCitasBeanData citasBeanData = new ConsultaCitasBeanData();
				
				citasBeanData.setCodigoAlumno(rset.getString(1));
				citasBeanData.setApPaterno(rset.getString(2));
				citasBeanData.setApMaterno(rset.getString(3));
				citasBeanData.setNombres(rset.getString(4));
				citasBeanData.setHoraCita(rset.getString(5));
				citasBeanData.setFechaCita(rset.getString(6));
				citasBeanData.setLugarCita(rset.getString(7));
				citasBeanData.setCodigoAsistenta(rset.getString(8));
				citasBeanData.setNombreAsistenta(rset.getString(9));
				
				vAlumnos.add(citasBeanData);
				
			}
			
		} catch (Exception exc) {
			con.rollback();
			throw exc;
		} finally {
			if (rset!= null) rset.close();
			if (pstmt!= null) pstmt.close();				 	
		}
		return vAlumnos;
					
			
	}
	
public void limpiarCitas(String anio, String ciclo, String tramite) throws PucpException {
		
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		
		try{
			
			CallableStatement ocs = super.con.prepareCall("{(call servsoci.pq_sswcitas.p_LimpiarCitas(?, ?, ?)}");
		    ocs.setInt(1, Integer.parseInt(anio));
		    ocs.setString(2, ciclo);
		    ocs.setString(3, tramite); 
		      
		    ocs.execute();      
		    ocs.close();
			
		}catch(Exception e){
			throw new PucpException(" Error al limpiar el horario de citas: "+ e.getMessage());
		}finally{
			try {if(rset!=null) rset.close();} catch(Exception er){}
			try {if(pstmt!=null) pstmt.close();} catch(Exception er){}
		}				
		
	}
	


	
	
	
}