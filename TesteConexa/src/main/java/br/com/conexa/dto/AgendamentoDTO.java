package br.com.conexa.dto;

import java.time.LocalDateTime;

public class AgendamentoDTO {

	private String id_paciente;
	private String data_hora_atendimento;
	
	public AgendamentoDTO(Long id_paciente, LocalDateTime data_hora_atendimento) {
		this.id_paciente = String.valueOf(id_paciente);
		this.data_hora_atendimento = String.valueOf(data_hora_atendimento);
	}
	
	public String getId_paciente() {
		return id_paciente;
	}
	public AgendamentoDTO setId_paciente(String id_paciente) {
		this.id_paciente = id_paciente;
		return this;
	}
	public String getData_hora_atendimento() {
		return data_hora_atendimento;
	}
	public AgendamentoDTO setData_hora_atendimento(String data_hora_atendimento) {
		this.data_hora_atendimento = data_hora_atendimento;
		return this;
	}
	
	
}
