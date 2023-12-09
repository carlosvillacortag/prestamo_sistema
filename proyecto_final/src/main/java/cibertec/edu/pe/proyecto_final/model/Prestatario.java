package cibertec.edu.pe.proyecto_final.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
public class Prestatario extends Usuario{

	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_cuentas", 
		joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "cuenta_id", referencedColumnName = "id"))
	private List<Cuenta> cuentas;	
	
	@OneToMany(mappedBy = "prestamos")
	private List<Prestamo> prestamos;
	
	public Prestatario(List<Cuenta> cuentas, List<Prestamo> prestamos) {
		this.cuentas = cuentas;
		this.prestamos = prestamos;
			
	}
	
}
