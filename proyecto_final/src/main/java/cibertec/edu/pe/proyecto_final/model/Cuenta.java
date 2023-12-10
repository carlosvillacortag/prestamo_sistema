package cibertec.edu.pe.proyecto_final.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cuentas")
@NoArgsConstructor
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String numeroCuenta;

	@Column(nullable = false, unique = true)
	private String banco;

	@Column(nullable = false, unique = true)
	private String codigoBanco;
	
	@ManyToMany(mappedBy = "cuentas")
	private List<Usuario> usuarios;

	public Cuenta(String numeroCuenta, String banco, String codigoBanco) {
		this.numeroCuenta = numeroCuenta;
		this.banco = banco;
		this.codigoBanco = codigoBanco;
	}
}
