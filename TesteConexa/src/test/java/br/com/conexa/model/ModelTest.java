package br.com.conexa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.com.conexa.dto.AgendamentoDTO;

public class ModelTest {

	@Test
    public void UserTest() {
        AgendamentoDTO agendamento = new AgendamentoDTO(1L, LocalDateTime.now());
        		new Usuario(1L, "Marcelo", "marcelo@email.com", "123", true, "medico");
        assertEquals(1L, Long.valueOf(agendamento.getId_paciente()));
        assertTrue(!agendamento.getData_hora_atendimento().isEmpty());
        
    }
}
