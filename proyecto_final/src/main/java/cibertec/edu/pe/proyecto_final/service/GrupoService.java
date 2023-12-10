package cibertec.edu.pe.proyecto_final.service;

import cibertec.edu.pe.proyecto_final.dto.UsuarioDto;
import cibertec.edu.pe.proyecto_final.model.Grupo;

public interface GrupoService {

	
	//Registrar Nuevo Usuario
	void saveGrupo(UsuarioDto usuarioDto);
	
	//login
	Grupo findByNombre(String nombre);
	
}
