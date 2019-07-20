package br.biblioteca.livros.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Autor;
import br.biblioteca.livros.entidades.Livro;
import br.biblioteca.livros.service.AutorService;
import br.biblioteca.livros.service.LivroService;

@Controller
public class LivroController {
	
	
	@Autowired
	LivroService livroService;
	
	@Autowired
	AutorService autorService;
	
	@RequestMapping("/livros/list")
	public ModelAndView livros() {
		Iterable<Livro> livros = livroService.listarLivros();
		return new ModelAndView( "livros/list" , "listaLivros" , livros );
	}


	@RequestMapping("livros/novo")
	public ModelAndView newBook(@ModelAttribute Livro livro)
	{
		ModelAndView modelAndView = new ModelAndView("livros/livro");
		Iterable<Autor> autores = autorService.listarAutores();
		modelAndView.addObject("autores", autores);
		modelAndView.addObject("livro", livro);
		return modelAndView;
	}
	
	@RequestMapping("/livros/alterar/{id}")
	public ModelAndView update(@PathVariable("id") Long id)
	{
		return newBook(livroService.buscarLivro(id));
		
	}
	
	@RequestMapping("/livros/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id)
	{
		livroService.apagarLivro(id);
		return new ModelAndView("redirect:/livros/list");
	}
	
	@PostMapping(value = "/livros/gravar")
	public ModelAndView create(Livro livro)
	{
		livroService.salvaLivro(livro);
		return new ModelAndView("redirect:/livros/list");
	}

}
