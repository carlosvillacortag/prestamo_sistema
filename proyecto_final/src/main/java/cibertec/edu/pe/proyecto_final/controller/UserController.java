package cibertec.edu.pe.proyecto_final.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cibertec.edu.pe.proyecto_final.service.UserService;

@Controller
@RequestMapping("/index")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String verInicio() {
		return "index";
	}
}