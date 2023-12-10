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
@Table(name = "prestamos")
@NoArgsConstructor
public class Prestamo {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		@Column(nullable = false)
		@Temporal(TemporalType.TIMESTAMP)
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
		private LocalDateTime fechaSolicitud = LocalDateTime.now();
		
		@Column(nullable = false)
		private BigDecimal montoPrestamo;
		
		@Column(nullable = false)
		private int nroCuotas;
		
		@Column(nullable = false)
		private BigDecimal tasa;
				
		@Column(nullable = true)
		@Temporal(TemporalType.TIMESTAMP)
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
		private LocalDateTime fechaAprobacion = LocalDateTime.now();
		
		@Column(nullable = false)
		private String estado;
		
		@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name = "usuarios_id", referencedColumnName="id")
		private Usuario usuario;
						
		public Prestamo(LocalDateTime fechaSolicitud, BigDecimal montoPrestamo, int nroCuotas, 
					BigDecimal tasa, LocalDateTime fechaAprobacion, String estado, Usuario usuario) {
			this.fechaSolicitud = fechaSolicitud;
			this.montoPrestamo = montoPrestamo;
			this.nroCuotas = nroCuotas;
			this.tasa = tasa;
			this.fechaAprobacion = fechaAprobacion;
			this.estado = estado;
			this.usuario = usuario;
		}
}		
