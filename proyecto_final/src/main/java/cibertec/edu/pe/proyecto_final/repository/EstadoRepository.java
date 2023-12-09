package cibertec.edu.pe.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.proyecto_final.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	Estado findByNombre(String nombre);

}
