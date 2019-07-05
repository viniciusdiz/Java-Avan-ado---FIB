package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Autor;

@Controller
public class AutorController {
	
	@RequestMapping("autor/list")
	public ModelAndView list()
	{
		System.out.println("Listei os Autores");
		return new ModelAndView("/autores/list");
	}
	
	@RequestMapping("autor/novo")
	public ModelAndView newBook()
	{
		System.out.println("Criei um novo Autor");
		return new ModelAndView("/autores/autor");
	}
	
	@RequestMapping("/autor/alterar/{id}")
	public ModelAndView update(@PathVariable("id") Long id)
	{
		System.out.println("Autor alterado");
		return new ModelAndView("redirect:/autores/list");
	}
	
	@RequestMapping("/autor/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id)
	{
		System.out.println("Autor excluido");
		return new ModelAndView("redirect:/autores/list");
	}
	
	@RequestMapping(value = "/autor/gravar")
	public ModelAndView create(Autor autor)
	{
		System.out.println("Autor salvo");
		return new ModelAndView("redirect:/autores/list");
	}

}
