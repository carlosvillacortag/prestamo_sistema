package cibertec.edu.pe.proyecto_final.service;

import cibertec.edu.pe.proyecto_final.model.Cuenta;

public interface CuentaService {
	
	Cuenta findByNumeroCuenta(String numeroCuenta);

	void guardarCuenta(Cuenta cuenta);

	Cuenta obtenerCuentaPorId(int id);

	void eliminarCuentaPorId(int id);
	
}
