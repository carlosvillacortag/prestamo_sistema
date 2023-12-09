package cibertec.edu.pe.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.proyecto_final.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByMail(String mail);
}