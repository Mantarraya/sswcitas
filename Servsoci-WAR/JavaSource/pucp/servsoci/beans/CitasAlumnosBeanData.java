package pucp.servsoci.beans;

import java.io.InputStream;

import pucp.lib.PucpBeanData;


public class CitasAlumnosBeanData extends PucpBeanData {	
	
	/* Archivo */
	
	private InputStream archivo=null;
	
	public void setArchivo(InputStream archivo) {
		this.archivo = archivo;
	}

	public InputStream getArchivo() {
		return archivo;
	}
	
	
	/* Fecha */
	
	private String fecha = "";

	/**
	 * @param fecha la fecha a establecer
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return la fecha
	 */
	public String getFecha() {
		return fecha;
	}
	

	/* Hora */

	private String hora = "";
	
	/**
	 * @param hora el hora a establecer
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * @return el hora
	 */
	public String getHora() {
		return hora;
	}


	/* Ciclo Ano */
	
	private String cicloAno = "";
	
	/**
	 * @param cicloAno el cicloAno a establecer
	 */
	public void setCicloAno(String cicloAno) {
		this.cicloAno = cicloAno;
	}

	/**
	 * @return el cicloAno
	 */
	public String getCicloAno() {
		return cicloAno;
	}

	/* Ciclo */
	
	private String ciclo = "";

	/**
	 * @param ciclo el ciclo a establecer
	 */
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return el ciclo
	 */
	public String getCiclo() {
		return ciclo;
	}
	
	/* Tramite */

	private String tramite = "";
	
	/**
	 * @param tramite el tramite a establecer
	 */
	public void setTramite(String tramite) {
		this.tramite = tramite;
	}

	/**
	 * @return el tramite
	 */
	public String getTramite() {
		return tramite;
	}
	
	
	/* Descripcion */

	private String descripcion = "";
	
	/**
	 * @param tramite la descripcion del tramite a establecer
	 */
	public void setDescripcion(String descripcion) {
		this.tramite = descripcion;
	}

	/**
	 * @return la descripcion del tramite
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	
	/* Indica Asignacion */
	
	private String indicaAsignacion = "";
	
	/**
	 * @param indicaAsignacion el indicaAsignacion a establecer
	 */
	public void setIndicaAsignacion(String indicaAsignacion) {
		this.indicaAsignacion = indicaAsignacion;
	}

	/**
	 * @return el indicaAsignacion
	 */
	public String getIndicaAsignacion() {
		return indicaAsignacion;
	}


	/* Codigo Asistenta */
	
	private String codigoAsistenta = "";
	
	/**
	 * @param codigoAsistenta el codigoAsistenta a establecer
	 */
	public void setCodigoAsistenta(String codigoAsistenta) {
		this.codigoAsistenta = codigoAsistenta;
	}

	/**
	 * @return el codigoAsistenta
	 */
	public String getCodigoAsistenta() {
		return codigoAsistenta;
	}

	/* Nombre Asistenta */
	
	private String nombreAsistenta = "";
	
	/**
	 * @param nombreAsistenta el nombreAsistenta a establecer
	 */
	public void setNombreAsistenta(String nombreAsistenta) {
		this.nombreAsistenta = nombreAsistenta;
	}

	/**
	 * @return el nombreAsistenta
	 */
	public String getNombreAsistenta() {
		return nombreAsistenta;
	}

	/* Lugar */
	
	private String lugar = "";
	
	/**
	 * @param lugar el lugar a establecer
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	/**
	 * @return el lugar
	 */
	public String getLugar() {
		return lugar;
	}

	
}
