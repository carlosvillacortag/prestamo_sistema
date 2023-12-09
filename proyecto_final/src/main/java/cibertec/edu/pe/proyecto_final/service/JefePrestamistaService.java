package cibertec.edu.pe.proyecto_final.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cibertec.edu.pe.proyecto_final.model.JefePrestamista;

public interface JefePrestamistaService {

	List<JefePrestamista> obtenerTodosLosUsuarios();
	
	Page<JefePrestamista> buscarPaginacion(int pageNumber, int pageSize);

	void guardarUsuario(JefePrestamista usuario);

	JefePrestamista obtenerUsuarioPorId(int id);

	void eliminarUsuarioPorId(int id);

}
