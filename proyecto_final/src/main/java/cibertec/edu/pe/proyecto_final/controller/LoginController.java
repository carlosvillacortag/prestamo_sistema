package cibertec.edu.pe.proyecto_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cibertec.edu.pe.proyecto_final.dto.UsuarioDto;
import cibertec.edu.pe.proyecto_final.model.Usuario;
import cibertec.edu.pe.proyecto_final.service.UsuarioService;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@GetMapping("/")
	public String verInicio() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String registerForm(Model model) {
		model.addAttribute("usuario", new UsuarioDto());
		return "registration";
	}

	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("usuario") UsuarioDto usuarioDto, BindingResult result, Model model) {

		Usuario foundUser = usuarioService.findByMail(usuarioDto.getMail());
		if (foundUser != null)
			result.rejectValue("mail", null, "Usuario ya esta registrado!");

		if (result.hasErrors()) {
			model.addAttribute("usuario", usuarioDto);
			return "/registration";
		}

		usuarioService.saveUsuario(usuarioDto);
		return "redirect:/registration?success";
	}

}