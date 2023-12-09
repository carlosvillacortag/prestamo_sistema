package cibertec.edu.pe.proyecto_final.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tiposestado")
@NoArgsConstructor
public class Estado {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		@Column(nullable = false, unique = true)
		private String tipoestado;

		@OneToMany(mappedBy = "prestamos")
		private List<Prestamo> prestamos;

		public Estado(String tipoestado, List<Prestamo> prestamos) {
			this.tipoestado = tipoestado;
			this.prestamos = prestamos;
			
		}
}