package cibertec.edu.pe.proyecto_final.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
@NoArgsConstructor
public class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nombres;

	@Column(nullable = false)
	private String apellidos;

	@Column(nullable = false, unique = true)
	private String dni;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime registro = LocalDateTime.now();

	@Column(nullable = false)
	private String direccion;

	@Column(nullable = false, unique = true)
	private String mail;
		
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "grupos", joinColumns = @JoinColumn(name = "grupos_id", referencedColumnName = "id"))
	@Column(nullable = false)
	private int grupo;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles", 
		joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
	private List<Rol> roles;	
		
	public Usuario(String nombres, String apellidos, String dni, String password,String direccion, LocalDateTime registro,
			 String mail, int grupo, List<Rol> roles) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.password = password;
		this.direccion = direccion;
		this.registro= registro;
		this.mail = mail;
		this.grupo = grupo;
		this.roles = roles;
			
	}
}
