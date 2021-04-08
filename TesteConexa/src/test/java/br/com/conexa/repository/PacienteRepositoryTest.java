package br.com.conexa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.conexa.model.Paciente;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PacienteRepositoryTest {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	 	@Test
	    public void salvarPaciente() {
	        Paciente paciente = new Paciente(1L, "Vitória", "21510962034", 20, "21 98989-9898");
	        pacienteRepository.save(paciente);
	        Integer countUser = pacienteRepository.findAll().size();
	        assertEquals(1, countUser);
	    }
	 	
	 	@Test
	    public void editarBuscarExcluirPaciente() {
	        Paciente paciente = new Paciente(1L, "Vitória", "21510962034", 20, "21 98989-9898");
	        Paciente pacienteEditado = new Paciente(1L, "Fernanda", "21510962034", 20, "21 98989-9898");
	        
	        pacienteRepository.save(paciente);
	        BeanUtils.copyProperties(pacienteEditado, paciente);
	        
	        pacienteRepository.save(paciente);
	        
	        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(1L);
	        assertTrue(pacienteBuscado.isPresent());
	        
	        if(pacienteBuscado.isPresent()) {
	        	 assertEquals(pacienteBuscado.get().getNome(), "Fernanda");
	        }
	       
	    }
}
