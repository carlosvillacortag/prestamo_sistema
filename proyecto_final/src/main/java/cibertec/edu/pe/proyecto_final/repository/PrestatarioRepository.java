package cibertec.edu.pe.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.proyecto_final.model.Usuario;

public interface PrestatarioRepository extends JpaRepository<Usuario, Integer>{

}