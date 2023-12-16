package cibertec.edu.pe.proyecto_final.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Override
	public Usuario findByMail(String mail) {
		return usuarioRepository.findByMail(mail);
	}
	
	
	// Registro de nuevo usuario
	@Override
	public void saveUsuario(UsuarioDto usuarioDto) {
		Rol rol = rolRepository.findByNombre("PRESTATARIO");
		// TODO cuentas bancarias
		// Cuenta cuenta = null;

		if (rol == null)
			rol = rolRepository.save(new Rol("PRESTATARIO"));

		Usuario newUsuario = new Usuario(usuarioDto.getNombres(), usuarioDto.getApellidos(), usuarioDto.getDni(),
				passwordEncoder.encode(usuarioDto.getPassword()), usuarioDto.getRegistro(), usuarioDto.getDireccion(),
				usuarioDto.getMail(), usuarioDto.getGrupos(), Arrays.asList(rol));

		usuarioRepository.save(newUsuario);
	}

	 @Override
	    public List<Usuario> getAllUsuarios() {
	        return usuarioRepository.findAll();
	    }
	
	
	@Override
	// Metodo para paginar el listado
	public Page<Usuario> buscarPaginacion(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("id").ascending());
		return usuarioRepository.findAll(pageable);
	}

	// Método para guardar/actualizar
	@Override
    public Usuario saveUsuario(Usuario Usuario) {
        return usuarioRepository.save(Usuario);
    }


    @Override
    public Usuario updateUsuario(Usuario Usuario, int id) {
        Usuario usuarioFound = usuarioRepository.findById(id).get();

        usuarioFound.setNombres(Usuario.getNombres());
        usuarioFound.setApellidos(Usuario.getApellidos());
        usuarioFound.setDni(Usuario.getDni());
        usuarioFound.setPassword(Usuario.getPassword());
        usuarioFound.setRegistro(Usuario.getRegistro());
        usuarioFound.setDireccion(Usuario.getDireccion());
        usuarioFound.setMail(Usuario.getMail());
        usuarioFound.setGrupos(Usuario.getGrupos());

        return usuarioRepository.save(usuarioFound);
    }
	
    @Override
    public void deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> findUsuarioById(int id) {
        return usuarioRepository.findById(id);
    }





}