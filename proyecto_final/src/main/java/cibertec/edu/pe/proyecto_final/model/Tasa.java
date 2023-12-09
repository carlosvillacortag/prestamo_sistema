package cibertec.edu.pe.proyecto_final.model;

import java.math.BigDecimal;
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
@Table(name = "tasas")
@NoArgsConstructor
public class Tasa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String tipoTasa;
	
	@Column(nullable = false)
	private int cuotas;
		
	@Column (nullable = false)
	private BigDecimal tasa;
	
	@OneToMany(mappedBy = "prestamos")
	private List<Prestamo> prestamos;
	
	public Tasa(int id, int cuotas,BigDecimal tasa, List<Prestamo> prestamos) {
		this.id = id;
		this.cuotas = cuotas;
		this.tasa = tasa;
		this.prestamos = prestamos;
	}
	
}
