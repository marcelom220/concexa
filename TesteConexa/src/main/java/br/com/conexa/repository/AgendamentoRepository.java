package br.com.conexa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.conexa.dto.AgendamentoDTO;
import br.com.conexa.model.Agendamento;
@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	@Query("SELECT new br.com.conexa.dto.AgendamentoDTO(p.idPaciente, a.dataHoraAtendimento) FROM Agendamento a "
			+ "INNER JOIN a.medico m "
			+ "INNER JOIN a.paciente p"
			+ " WHERE date(a.dataHoraAtendimento) BETWEEN date(:dataInicio) and date(:dataFim) "
			+ " AND m.codigo = :idMedico")
	public List<AgendamentoDTO> buscarAgendamentoDiaMedico(@Param("idMedico") Long idMedico, @Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim);
}
