package cibertec.edu.pe.proyecto_final.service;

import cibertec.edu.pe.proyecto_final.dto.UsuarioDto;
import cibertec.edu.pe.proyecto_final.model.Usuario;

public interface UsuarioService {
	
	//Registrar Nuevo Usuario
	void saveUsuario(UsuarioDto usuarioDto);
	
	//login
	Usuario findByMail(String mail);
	
}