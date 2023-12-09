package cibertec.edu.pe.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.proyecto_final.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

	Prestamo findById(int Id);

}
