package br.com.conexa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conexa.dto.AgendamentoDTO;
import br.com.conexa.model.Agendamento;
import br.com.conexa.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public AgendamentoService(AgendamentoRepository agendamentoRepository) {
		this.agendamentoRepository = agendamentoRepository;
	}
	
	public List<AgendamentoDTO> getAgendamentosDiaMedico(Long id) {
		
		return agendamentoRepository.buscarAgendamentoDiaMedico(id, LocalDate.now().atTime(00, 00, 00) , LocalDate.now().atTime(23, 59, 59));
	}
	public Agendamento agendar(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}

}
