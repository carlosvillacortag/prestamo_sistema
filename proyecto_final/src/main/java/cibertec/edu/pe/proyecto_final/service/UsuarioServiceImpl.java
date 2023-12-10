package cibertec.edu.pe.proyecto_final.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.proyecto_final.dto.UsuarioDto;
import cibertec.edu.pe.proyecto_final.model.Rol;
import cibertec.edu.pe.proyecto_final.model.Usuario;
import cibertec.edu.pe.proyecto_final.repository.RolRepository;
import cibertec.edu.pe.proyecto_final.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	// Registro de nuevo usuario
	@Override
	public void saveUsuario(UsuarioDto usuarioDto) {
		Rol rol = rolRepository.findByNombre("PRESTATARIO");
		// TODO cuentas bancarias
		//Cuenta cuenta = null;
	
		if (rol == null)
			rol = rolRepository.save(new Rol("PRESTATARIO"));

		Usuario newUsuario = new Usuario(usuarioDto.getNombres(), usuarioDto.getApellidos(), usuarioDto.getDni(),
				passwordEncoder.encode(usuarioDto.getPassword()), usuarioDto.getRegistro(), usuarioDto.getDireccion(), 
				usuarioDto.getMail(), Arrays.asList(rol));

		usuarioRepository.save(newUsuario);
	}

	// Método para buscar usuario por correo
	@Override
	public Usuario findByMail(String mail) {
		return usuarioRepository.findByMail(mail);
	}
}