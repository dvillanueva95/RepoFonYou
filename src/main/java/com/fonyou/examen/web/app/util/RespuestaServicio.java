package com.fonyou.examen.web.app.util;

import java.io.Serializable;

public class RespuestaServicio implements Serializable{
	
	// Atributos
	private int codigoRespuesta;
	private String respuesta;
	
	// Metodos de acceso
	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	// Default serial ID
		private static final long serialVersionUID = 1L;

}
