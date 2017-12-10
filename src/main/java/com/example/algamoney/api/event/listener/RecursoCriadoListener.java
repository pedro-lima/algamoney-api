package com.example.algamoney.api.event.listener;

import java.net.URI;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney.api.event.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

	//@Resource
	//private WebServiceContext context;

	@Override
	public void onApplicationEvent(RecursoCriadoEvent event) {

		HttpServletResponse response = event.getResponse();
		long codigo = event.getCodigo();

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(codigo).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

//	public void getHttpServletResponse() {		
//		MessageContext msgCtxt = context.getMessageContext();
//		HttpServletResponse req = (HttpServletResponse) msgCtxt.get(MessageContext.SERVLET_RESPONSE);
//		
//	}

}
