package cibertec.edu.pe.proyecto_final.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cuotas")
@NoArgsConstructor
public class Cuota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime fechaPago = LocalDateTime.now();

	@Column(nullable=false)
	private BigDecimal montoPago;
	
	@Column(nullable=false)
	private int numero;
	
	@OneToMany(mappedBy = "prestamos")
	private List<Prestamo> prestamos;

	public Cuota(LocalDateTime fechaPago, BigDecimal montoPago, int numero,List<Prestamo> prestamos) {
		this.fechaPago = fechaPago;
		this.montoPago = montoPago;
		this.numero = numero;
		this.prestamos = prestamos;
				
	}
	
}
