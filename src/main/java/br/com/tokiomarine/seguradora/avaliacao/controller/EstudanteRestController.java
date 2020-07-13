package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;

// TODO não esquecer de usar as anotações para criação do restcontroller

@CrossOrigin("*")
@RestController
@RequestMapping("/estudantes/")
public class EstudanteRestController {

	// TODO efetue a correção dos problemas que existem na classe Estudante
	// Controller
	@Autowired
	EstudandeService estudanteService;

	// TODO caso você não conheça THEMELEAF faça a implementação dos métodos em
	// forma de RESTCONTROLLER (seguindo o padrão RESTFUL)

	// TODO IMPLEMENTAR CADASTRO DE ESTUDANTES (POST)

	// TODO IMPLEMENTAR ATUALIZACAO DE ESTUDANTES (PUT)

	// TODO IMPLEMENTAR A LISTAGEM DE ESTUDANTES (GET)

	// TODO IMPLEMENTAR A EXCLUSÃO DE ESTUDANTES (DELETE)

	/*
	@GetMapping("listar")
	public List<Estudante> listar() {
		return estudanteService.buscarEstudantes();
	}

	@PostMapping("add")
	public Estudante adicionar(@RequestBody @Valid Estudante estudante) {
		return estudanteService.cadastrarEstudante(estudante);
	}

	@PutMapping("atualizar/{id}")
	public Estudante atualizar(@PathVariable("id") long id, @RequestBody Estudante estudante) {
		Estudante estudanteAtual = estudanteService.buscarEstudante(id);
		BeanUtils.copyProperties(estudante, estudanteAtual, "id");
		return estudanteService.cadastrarEstudante(estudanteAtual);
	}

	@DeleteMapping("apagar/{id}")
	public void remover(@PathVariable("id") long id) {
		estudanteService.apagarEstudante(id);
	}
	*/
}
