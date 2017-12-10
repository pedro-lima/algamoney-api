package com.example.algamoney.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	
	private long codigo;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public long getCodigo() {
		return codigo;
	}
	
	

}
