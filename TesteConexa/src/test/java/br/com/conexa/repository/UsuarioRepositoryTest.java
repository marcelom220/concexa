package br.com.conexa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.conexa.model.Usuario;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
    public void salvarUsuario() {
        Usuario usuario = new Usuario(1L, "Hans", "hans@email.com", "senha", true, "clínica");
        usuarioRepository.save(usuario);
        Integer countUser = usuarioRepository.findAll().size();
        assertEquals(1, countUser);
    }
 	
 	@Test
    public void editarBuscarExcluirUsuario() {
 		Usuario usuario = new Usuario(1L, "Hans", "hans@email.com", "senha", true, "clínica");
 		Usuario usuarioEditado = new Usuario(1L, "Hans", "hans@email.com", "senha", false, "");
        
 		usuarioRepository.save(usuario);
        BeanUtils.copyProperties(usuarioEditado, usuario);
        
        usuarioRepository.save(usuario);
        
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(1L);
        assertTrue(usuarioBuscado.isPresent());
        
        if(usuarioBuscado.isPresent()) {
        	 assertFalse(usuarioBuscado.get().isMedico());
        	 assertEquals(usuarioBuscado.get().getEspecialidade(), "");
        }
       
    }
}
