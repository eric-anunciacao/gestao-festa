package com.easys.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.easys.festa.model.Convidado;
import com.easys.festa.repository.ConvidadoRepository;

@Controller
@RequestMapping("/convidados")
public class ConvidadoController {

	@Autowired
	private ConvidadoRepository convidadoRepository;

	@GetMapping
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("lista-convidados");
		modelAndView.addObject("convidados", convidadoRepository.findAll());
		modelAndView.addObject(new Convidado());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Convidado convidado) {
		this.convidadoRepository.save(convidado);
		return "redirect:/convidados";
	}
}
