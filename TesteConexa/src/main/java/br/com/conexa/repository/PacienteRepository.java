package br.com.conexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.conexa.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
