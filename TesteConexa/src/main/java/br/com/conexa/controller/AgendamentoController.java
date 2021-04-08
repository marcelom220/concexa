package br.com.conexa.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.conexa.event.RecursoCriadoEvent;
import br.com.conexa.model.Agendamento;
import br.com.conexa.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
	@Autowired
	AgendamentoService agendamentoService;
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Agendamento> agendar( @RequestBody Agendamento agendamento, HttpServletResponse response) {
		Agendamento agendamentoSalvo = agendamentoService.agendar(agendamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, agendamentoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoSalvo);
	}
}
