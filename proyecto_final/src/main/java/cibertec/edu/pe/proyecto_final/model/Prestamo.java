package cibertec.edu.pe.proyecto_final.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
		@Temporal(TemporalType.TIMESTAMP)
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
		private LocalDateTime fechaAprobacion = LocalDateTime.now();
		
		@Column(nullable = false)
		private BigDecimal montoPrestamo;

		@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(name = "usuarios", joinColumns = @JoinColumn(name = "usuarios_id", referencedColumnName = "id"))
		@Column(nullable = false)
		private int usuario;
		
		@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(name = "tasas", joinColumns = @JoinColumn(name = "tasas_id", referencedColumnName = "id"))
		@Column(nullable = false)
		private int tasa;
		
		@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(name = "tiposestado", joinColumns = @JoinColumn(name = "tiposestado_id", referencedColumnName = "id"))
		@Column(nullable = false)
		private int tipoEstado;
		
		@OneToMany(mappedBy = "cuotas")
		private List<Cuota> cuotas;
				
		public Prestamo(LocalDateTime fechaSolicitud, LocalDateTime fechaAprobacion, BigDecimal montoPrestamo, int usuario, int tasa, int tipoEstado, List<Cuota> cuotas) {
			this.fechaSolicitud = fechaSolicitud;
			this.fechaAprobacion = fechaAprobacion;
			this.montoPrestamo = montoPrestamo;
			this.usuario = usuario;
			this.tasa = tasa;
			this.tipoEstado = tipoEstado;
			this.cuotas = cuotas;
		}
		
}		
