package br.com.conexa.config.token;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import br.com.conexa.dto.AgendamentoDTO;
import br.com.conexa.repository.AgendamentoRepository;
import br.com.conexa.security.UsuarioSistema;

public class CustomTokenEnhancer implements TokenEnhancer {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		UsuarioSistema usuarioSistema = (UsuarioSistema) authentication.getPrincipal();
		
		Map<String, Object> addInfo = new HashMap<>();
		Map<String, List<AgendamentoDTO>> agendamentos= new HashMap<>();
		if(usuarioSistema.getUsuario().isMedico())
		addInfo.put("medico", usuarioSistema.getUsuario().getNome());
		addInfo.put("especialidade", usuarioSistema.getUsuario().getNome());
		
		List<AgendamentoDTO> agendamentosLista = new ArrayList<>();
		agendamentosLista.addAll(agendamentoRepository.buscarAgendamentoDiaMedico(usuarioSistema.getUsuario().getCodigo(), LocalDate.now().atTime(00, 00, 00), LocalDate.now().atTime(23, 59, 59)));
		agendamentos.put("agendamentos_hoje", agendamentosLista);
		addInfo.putAll(agendamentos);
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
		return accessToken;
	}
}
