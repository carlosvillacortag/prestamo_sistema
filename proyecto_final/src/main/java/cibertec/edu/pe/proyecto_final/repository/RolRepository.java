package cibertec.edu.pe.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.proyecto_final.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {

	Rol findByNombre(String nombre);

}
