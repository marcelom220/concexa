package br.com.conexa.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.conexa.event.RecursoCriadoEvent;
import br.com.conexa.model.Paciente;
import br.com.conexa.repository.PacienteRepository;
import br.com.conexa.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> getPacientePorId(@PathVariable Long id) {
		
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		return paciente.isPresent() ? ResponseEntity.ok(paciente.get()) : ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		pacienteRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> atualizar(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
		return ResponseEntity.ok(pacienteService.atualizarPaciente(id, paciente));
	}
	
	@PostMapping
	public ResponseEntity<Paciente> criar(@Valid @RequestBody Paciente paciente, HttpServletResponse response) {
		Paciente pacienteSalvo = pacienteService.salvarPaciente(paciente);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pacienteSalvo.getIdPaciente()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
	}
}
