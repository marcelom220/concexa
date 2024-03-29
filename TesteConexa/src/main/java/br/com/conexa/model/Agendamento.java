package br.com.conexa.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agendamento")
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataHoraAtendimento;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_medico")
	private Usuario medico;
	
	public Agendamento() {}
	
	public Agendamento(Long id, LocalDateTime dataHoraAtendimento, Paciente paciente, Usuario medico) {
		this.id = id;
		this.dataHoraAtendimento = dataHoraAtendimento;
		this.paciente = paciente;
		this.medico = medico;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataHoraAtendimento() {
		return dataHoraAtendimento;
	}
	public void setDataHoraAtendimento(LocalDateTime dataHoraAtendimento) {
		this.dataHoraAtendimento = dataHoraAtendimento;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Usuario getMedico() {
		return medico;
	}
	public void setMedico(Usuario medico) {
		this.medico = medico;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
