package com.zup.vacinacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zup.vacinacao.model.Vacinacao;
import com.zup.vacinacao.repository.VacinacaoRepository;

@Controller
@RequestMapping("/vacinacao")
public class CadastroVacinaController {
	
	private static final String VACINA_VIEW =  "CadastroDeVacina";
	
	@Autowired
	VacinacaoRepository vacinacaoRepository;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(VACINA_VIEW);
		mv.addObject(new Vacinacao());
		return mv;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated Vacinacao vacina, Errors errors,RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			return VACINA_VIEW;
		}
		
		try {
			vacinacaoRepository.save(vacina);
			attributes.addFlashAttribute("mensagem","Vacinação salva com sucesso");
			return "redirect:/vacinacao";
		}catch (Exception e) {
			errors.rejectValue(e.getMessage(), null);
			return VACINA_VIEW;
		}
	}
	
}
