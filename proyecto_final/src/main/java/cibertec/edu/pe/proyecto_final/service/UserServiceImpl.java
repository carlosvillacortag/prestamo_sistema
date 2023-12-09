package cibertec.edu.pe.proyecto_final.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.proyecto_final.model.Usuario;
import cibertec.edu.pe.proyecto_final.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	// Listado de Usuarios
		public List<Usuario> obtenerTodosLosUsuarios() {
			List<Usuario> listaUsuarios = new ArrayList<>();
			userRepository.findAll().forEach(usuario -> listaUsuarios.add(usuario));

			return listaUsuarios;
		}
		
		@Override
		// Metodo para paginar el listado
			public Page<Usuario> buscarPaginacion(int pageNumber, int pageSize) {
				Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("id").ascending());
				return userRepository.findAll(pageable);
			}

		@Override
			// Método para guardar/actualizar
			public void guardarUsuario(Usuario usuario) {
				userRepository.save(usuario);
			}

		@Override
			// Método para buscar usuario por Id
			public Usuario obtenerUsuarioPorId(int id) {
				return userRepository.findById(id).get();
			}

		@Override
			// Método para eliminar usuario por Id
			public void eliminarUsuarioPorId(int id) {
				userRepository.deleteById(id);
			}
		
	
	
}
