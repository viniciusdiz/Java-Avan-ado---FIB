package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Livro;

@Controller
public class LivroController {
	
	@RequestMapping("livro/list")
	public ModelAndView list()
	{
		System.out.println("Listei os livros");
		return new ModelAndView("livros/list");
	}
	
	@RequestMapping("livro/novo")
	public ModelAndView newBook()
	{
		System.out.println("Criei um novo livro");
		return new ModelAndView("/livros/livro");
	}
	
	@RequestMapping("/livro/alterar/{id}")
	public ModelAndView update(@PathVariable("id") Long id)
	{
		System.out.println("Livro alterado");
		return new ModelAndView("redirect:/livros/list");
	}
	
	@RequestMapping("/livro/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id)
	{
		System.out.println("Livro excluido");
		return new ModelAndView("redirect:/livros/list");
	}
	
	@RequestMapping(value = "/livro/gravar")
	public ModelAndView create(Livro livro)
	{
		System.out.println("Livro salvo");
		return new ModelAndView("redirect:/livros/list");
	}

}
