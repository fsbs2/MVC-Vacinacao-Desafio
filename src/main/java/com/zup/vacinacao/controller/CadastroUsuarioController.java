package com.zup.vacinacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zup.vacinacao.model.Usuario;
import com.zup.vacinacao.repository.UsuariosRepository;

@Controller
@RequestMapping("/usuarios")
public class CadastroUsuarioController {
	
	private static final String VIEW_USUARIO = "CadastroDeUsuario";
	
	@Autowired
	UsuariosRepository usuarioRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(VIEW_USUARIO);
		mv.addObject(new Usuario());
		
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated Usuario usuario, Errors errors,RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			return VIEW_USUARIO;
		}
		
		try {
			usuarioRepository.save(usuario);
			attributes.addFlashAttribute("mensagem","Usuário salvo com sucesso");
			return "redirect:/usuarios";
			
		} catch (Exception e) {
			attributes.addFlashAttribute("mensagem","CPF ou E-mail já existentes no cadastro");
			return "redirect:/usuarios";
		}
		
	}
	
}
