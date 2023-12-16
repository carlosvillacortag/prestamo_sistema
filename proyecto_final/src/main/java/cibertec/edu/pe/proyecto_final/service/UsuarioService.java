package cibertec.edu.pe.proyecto_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import cibertec.edu.pe.proyecto_final.dto.UsuarioDto;
import cibertec.edu.pe.proyecto_final.model.Usuario;

public interface UsuarioService {
	
	//Registrar Nuevo Usuario
	void saveUsuario(UsuarioDto usuarioDto);
	
	//login
	Usuario findByMail(String mail);
	
	Page<Usuario> buscarPaginacion(int pageNumber, int pageSize);

	 //Guardar nuevo Usuario
    Usuario saveUsuario(Usuario usuario);

    //Obtener el listado de todos los Usuarios
    List<Usuario> getAllUsuarios();

    //Actualizar Usuario
    Usuario updateUsuario(Usuario usuario, int id);

    //Eliminar Usuario
    void deleteUsuario(int id);

    //Busqueda de Usuario por Id
    Optional<Usuario> findUsuarioById(int id);
	
}