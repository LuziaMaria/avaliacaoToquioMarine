package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.exception.EntidadeEmUsoException;
import br.com.tokiomarine.seguradora.avaliacao.exception.EntidadeNaoEncontradaException;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

@Service
public class EstudanteServiceImpl implements EstudandeService {
	
	private static final String ESTUDANTE_NAO_PODE_SER_REMOVIDO_ESTA_EM_USO = "Pessoa de código %d nao pode ser removida, está em uso.";

	private static final String MSG_ESTUDANTE_NAO_ENCONTRADO = "Não existe um cadastro de pessoa com código %d";

	@Autowired
	private EstudanteRepository repository;

	@Override
	public Estudante cadastrarEstudante(@Valid Estudante estudante) {
		return repository.save(estudante);
	}

	@Override
	public List<Estudante> buscarEstudantes() {
		return repository.findAll();
	}

	@Override
	public Estudante buscarEstudante(Long id) {

	return repository.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("Identificador inválido:" + id) );
	}

	@Override
	public void apagarEstudante(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException  e) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_ESTUDANTE_NAO_ENCONTRADO, id));
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(ESTUDANTE_NAO_PODE_SER_REMOVIDO_ESTA_EM_USO, id));
		}
	}

	@Override
	public Estudante atualizarEstudante(@Valid Estudante estudante) {
		return cadastrarEstudante(estudante);
	}

//	@Override
//	public Estudante editarEstudante(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
