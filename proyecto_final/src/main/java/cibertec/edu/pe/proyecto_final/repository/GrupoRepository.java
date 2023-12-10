package cibertec.edu.pe.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.proyecto_final.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

	Grupo findByNombre(String nombre);
}
