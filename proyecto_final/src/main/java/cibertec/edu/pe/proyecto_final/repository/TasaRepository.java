package cibertec.edu.pe.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.proyecto_final.model.Tasa;

public interface TasaRepository extends JpaRepository<Tasa, Integer> {

	Tasa findByTipoTasa(String tipoTasa);

}
