package pucp.servsoci.beans;

import java.io.InputStream;

import pucp.lib.PucpBeanData;

public class ConsultaCitasBeanData extends PucpBeanData {	
	
	
	/* Codigo Alumno */
	
	private String codigoAlumno = "";

	/**
	 * @param codigoAlumno el codigoAlumno a establecer
	 */
	public void setCodigoAlumno(String codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	/**
	 * @return el codigoAlumno
	 */
	public String getCodigoAlumno() {
		return codigoAlumno;
	}

	
	/* Apellido Paterno */
	
	private String apPaterno = "";
	
	/**
	 * @param apPaterno el apPaterno a establecer
	 */
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	/**
	 * @return el apPaterno
	 */
	public String getApPaterno() {
		return apPaterno;
	}

	/* Apellido Materno */
	
	private String apMaterno = "";
	
	/**
	 * @param apMaterno el apMaterno a establecer
	 */
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	/**
	 * @return el apMaterno
	 */
	public String getApMaterno() {
		return apMaterno;
	}

	/* Nombres */
	
	private String Nombres = "";
	
	/**
	 * @param nombres el nombres a establecer
	 */
	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	/**
	 * @return el nombres
	 */
	public String getNombres() {
		return Nombres;
	}
	
	/* Hora Cita */
	
	private String horaCita = "";
	
	/**
	 * @param horaCita el horaCita a establecer
	 */
	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	/**
	 * @return el horaCita
	 */
	public String getHoraCita() {
		return horaCita;
	}

	/* Fecha Cita */
	
	private String fechaCita = "";
	
	/**
	 * @param fechaCita el fechaCita a establecer
	 */
	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}

	/**
	 * @return el fechaCita
	 */
	public String getFechaCita() {
		return fechaCita;
	}

	/* Lugar Cita */
	
	private String lugarCita = "";
	
	/**
	 * @param lugarCita el lugarCita a establecer
	 */
	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	/**
	 * @return el lugarCita
	 */
	public String getLugarCita() {
		return lugarCita;
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
	
	
	
}	