package cibertec.edu.pe.proyecto_final.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cibertec.edu.pe.proyecto_final.model.Usuario;
import cibertec.edu.pe.proyecto_final.service.UserService;

@Controller
@RequestMapping("/index")
public class UserController {

	@Autowired
	UserService userService;
	
	//Mostrar pagina de inicio /
	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public String usuarioForm(Model modelo) {
			
		return buscarPaginacion(1, modelo);
	}
	
	//Accion para realizar el paginado de la lista de personas
	@RequestMapping(value = "/page/{pageNumber}")
	public String buscarPaginacion(@PathVariable(value = "pageNumber") int pageNumber,
			Model modelo) {
		int pageSize = 4 ; //Cantidad de elementos por pagina
		Page<Usuario> page = userService.buscarPaginacion(pageNumber, pageSize);
		List<Usuario> listaUsuarios = page.getContent();
		
		modelo.addAttribute("listaUsuarios", listaUsuarios);
		modelo.addAttribute("paginaActual", pageNumber);
		modelo.addAttribute("totalPaginas", page.getTotalPages());
		modelo.addAttribute("totalUsuarios", page.getTotalElements());
		
		return "/index";
	}
	
	//Mostrar vista para Formulario para el botón: Agregar Usuario
	@RequestMapping(value = "showNewUserForm", method = RequestMethod.GET)
	public String mostrarFormularioNuevoUsuario(Model modelo) {
		Usuario newUsuario = new Usuario();
		modelo.addAttribute("newUsuario", newUsuario);
		return "new_usuario";
	}
	
	//Guardar usuario enviado desde la vista new_person.html mediante /saveUsuario
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String guardarUsuario(@ModelAttribute("newUsuario") Usuario usuario) {
		userService.guardarUsuario(usuario);
		
		return "redirect:/";
	}
	
	//Mostrar vista para Formulario del boton: Update
	@RequestMapping(value = "/showUpdateUserForm/{id}", method = RequestMethod.GET)
	public String mostrarFormularioActualizarUsuario(Model modelo,
			@PathVariable(value = "id") int id) {
		Usuario usuarioFound = userService.obtenerUsuarioPorId(id);
		modelo.addAttribute("usuarioFound", usuarioFound);
		return "update_usuario";
	}
	
	//Eliminar usuario: Boton Delete
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String eliminarUsuario(@PathVariable(value = "id") int id) {
		userService.obtenerUsuarioPorId(id);
		
		return "redirect:/";
	}
}