package cibertec.edu.pe.proyecto_final.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@Column(nullable=true)
	private BigDecimal mora;
	
	@Column(nullable=false)
	private int numeroCuota;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "prestamo_id", referencedColumnName="id")
	private Prestamo prestamo;

	public Cuota(LocalDateTime fechaPago, BigDecimal montoPago, BigDecimal mora, int numeroCuota, Prestamo prestamo) {
		this.fechaPago = fechaPago;
		this.montoPago = montoPago;
		this.mora = mora;
		this.numeroCuota = numeroCuota;
		this.prestamo = prestamo;
				
	}
	
}
