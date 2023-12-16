package cibertec.edu.pe.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cibertec.edu.pe.proyecto_final.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, PagingAndSortingRepository<Usuario, Integer> {

	Usuario findByMail(String mail);
}
