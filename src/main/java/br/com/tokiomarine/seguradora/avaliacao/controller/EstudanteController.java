package br.com.tokiomarine.seguradora.avaliacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;

@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {

	// TODO efetue a correção dos problemas que existem na classe Estudante Controller
	@Autowired
	EstudandeService estudanteService;

	@GetMapping("criar")
	public String iniciarCastrado(Estudante estudante) {
		return "cadastrar-estudante";
	}

	@GetMapping("listar")
	public String listarEstudantes(Model model) {
		model.addAttribute("estudantes", estudanteService.buscarEstudantes());
		return "index";
	}

	@PostMapping("add")
	public String adicionarEstudante(@Valid Estudante estudante, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Erro no formulario");
			return "cadastrar-estudante";
		}
		estudanteService.cadastrarEstudante(estudante);
		attributes.addFlashAttribute("mensagem", "Cadastro de Estudante bem sucedido");
		return "redirect:listar";
	}

	@GetMapping("editar/{id}")
	public String exibirEdicaoEstudante(@PathVariable("id") Long id, Model model) {
		Estudante estudante = estudanteService.buscarEstudante(id);
		model.addAttribute("estudante", estudante);
		return "atualizar-estudante";
	}
	
	@PostMapping("atualizar/{id}")
	public String atualizarEstudante(@PathVariable("id") Long id, @Valid Estudante estudante, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Erro no formulario");
			estudante.setId(id);
			return "atualizar-estudante";
		}
		estudanteService.atualizarEstudante(estudante);

		model.addAttribute("estudantes", estudanteService.buscarEstudantes());
		attributes.addFlashAttribute("mensagem", "Cadastro de Estudante bem sucedido");
        return "index";
	}
	
	@GetMapping("apagar/{id}")
	public String apagarEstudante(@PathVariable("id") Long id, Model model) {
		estudanteService.apagarEstudante(id);
		model.addAttribute("estudantes", estudanteService.buscarEstudantes());
		return "index";
	}
}
