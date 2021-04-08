package br.com.conexa.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.conexa.model.Paciente;
import br.com.conexa.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Paciente buscarPacientePorId(Long id) {
		
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		if(!paciente.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return paciente.get();
	}
	
	public Paciente salvarPaciente(Paciente p) {
		
		return pacienteRepository.save(p);
	}
	
	public void removerPaciente(Long id) {
		Paciente paciente = buscarPacientePorId(id);
		
		pacienteRepository.delete(paciente);
	}
	
	public Paciente atualizarPaciente(Long id, Paciente paciente) {
		Paciente pacienteSalvo = buscarPacientePorId(id);
		
		BeanUtils.copyProperties(paciente, pacienteSalvo);
		return pacienteRepository.save(pacienteSalvo);
	}


}
