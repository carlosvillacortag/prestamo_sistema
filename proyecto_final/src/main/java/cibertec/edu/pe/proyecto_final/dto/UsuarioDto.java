package cibertec.edu.pe.proyecto_final.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import cibertec.edu.pe.proyecto_final.model.Grupo;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UsuarioDto {

	@NotEmpty(message = "Ingrese sus nombres")
	private String nombres;

	@NotEmpty(message = "Ingrese sus apellidos")
	private String apellidos;

	@NotEmpty(message = "Ingrese un DNI valido")
	private String dni;

	@NotEmpty(message = "Ingrese una contraseña valida")
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime registro = LocalDateTime.now();

	@NotEmpty(message = "Ingrese su direccion actual")
	private String direccion;
	
	private Grupo grupos = null;

	@NotEmpty(message = "Ingrese un correo valido")
	@Email
	private String mail;

}
