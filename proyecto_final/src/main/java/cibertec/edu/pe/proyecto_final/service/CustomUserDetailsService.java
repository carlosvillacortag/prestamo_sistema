package cibertec.edu.pe.proyecto_final.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.proyecto_final.model.Usuario;
import cibertec.edu.pe.proyecto_final.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByMail(username);

		if (usuario != null) {
			return new User(
					usuario.getMail(),
					usuario.getPassword(),
					usuario.getRoles().stream()
					.map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList()));
		} else {
			throw new UsernameNotFoundException("Usuario Invalido");
		}
	}

}
