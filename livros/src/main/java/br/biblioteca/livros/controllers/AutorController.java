package br.biblioteca.livros.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Autor;
import br.biblioteca.livros.entidades.Livro;
import br.biblioteca.livros.service.AutorService;

@Controller
public class AutorController {
	
	@Autowired
	AutorService autorService;
	
	@RequestMapping("autor/list")
	public ModelAndView list()
	{
		Iterable<Autor> autores = autorService.listarAutores();
		return new ModelAndView( "autores/list" , "listaAutores" , autores);
	}
	
	@RequestMapping("autor/novo")
	public ModelAndView newBook()
	{
		ModelAndView modelAndView = new ModelAndView("auores/autor");
		return modelAndView;
	}
	
	@RequestMapping("/autor/alterar/{id}")
	public ModelAndView update(@PathVariable("id") Long id)
	{
		Autor autor = autorService.buscarAutor(id);
		ModelAndView modelAndView = new ModelAndView("autores/form");
		modelAndView.addObject("autores", autor);
		return modelAndView;
	}
	
	@RequestMapping("/autor/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id)
	{
		autorService.apagarAutor(id);
		return new ModelAndView("redirect:/autores/list");
	}
	
	@RequestMapping(value = "/autor/gravar")
	public ModelAndView create(@ModelAttribute("autor") @Valid Autor autor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("autores/autor");
		}
		autorService.salvaAutor(autor);
		return new ModelAndView("redirect:/autores/list");
	}
	
	
	/*@RequestMapping(value = "/autor/gravar")
	public ModelAndView create(Autor autor)
	{
		autorService.salvaAutor(autor);
		return new ModelAndView("redirect:/autores/list");
	}*/

}
