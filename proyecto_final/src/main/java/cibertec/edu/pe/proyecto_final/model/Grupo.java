package cibertec.edu.pe.proyecto_final.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "grupos")
@NoArgsConstructor
public class Grupo {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		@Column(nullable = false, unique = true)
		private String nombre;
		
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupos")
		private List<Usuario> usuarios;

		public Grupo(String nombre) {
			this.nombre = nombre;
		}

}
