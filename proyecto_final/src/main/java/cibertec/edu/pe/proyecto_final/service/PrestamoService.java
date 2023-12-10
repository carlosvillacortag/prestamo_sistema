package cibertec.edu.pe.proyecto_final.service;

import java.util.List;


import cibertec.edu.pe.proyecto_final.model.Prestamo;

public interface PrestamoService {

	List<Prestamo> obtenerTodosLosPrestamos();

	void guardarPrestamo(Prestamo usuario);

	Prestamo obtenerPrestamosPorId(int id);
	Prestamo obtenerPrestamosPorUsuario(int id);
	Prestamo obtenerPrestamosPorGrupo(int id);

	void eliminarPrestamoPorId(int id);

}
