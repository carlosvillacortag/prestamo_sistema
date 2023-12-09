package cibertec.edu.pe.proyecto_final.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cibertec.edu.pe.proyecto_final.model.Usuario;

public interface UserService {

	List<Usuario> obtenerTodosLosUsuarios();
	
	Page<Usuario> buscarPaginacion(int pageNumber, int pageSize);

	void guardarUsuario(Usuario usuario);

	Usuario obtenerUsuarioPorId(int id);

	void eliminarUsuarioPorId(int id);

}
