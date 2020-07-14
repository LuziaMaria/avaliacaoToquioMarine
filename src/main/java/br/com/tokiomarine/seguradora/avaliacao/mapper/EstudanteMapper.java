package br.com.tokiomarine.seguradora.avaliacao.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.tokiomarine.seguradora.avaliacao.dto.EstudanteDTO;
import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

@Component
public class EstudanteMapper implements Mapper<EstudanteDTO, Estudante> {
	
	@Override
	public Estudante converterDtoToModelo(EstudanteDTO dto) {
		Estudante modelo = new Estudante();
		
		modelo.setId(dto.getId() == null ? null : dto.getId());
		modelo.setNome(dto.getNome() == null ? null : dto.getNome());
		modelo.setEmail(dto.getEmail() == null ? null : dto.getEmail());
		modelo.setTelefone(dto.getTelefone() == null ? null : dto.getTelefone());
		modelo.setMatricula(dto.getMatricula() == null ? null : dto.getMatricula());
		modelo.setCurso(dto.getCurso() == null ? null : dto.getCurso());
		
		return modelo;
	}

	@Override
	public EstudanteDTO converterModeloToDto(Estudante modelo) {
		
		EstudanteDTO dto  = new EstudanteDTO();
		  
		dto.setId(modelo.getId());
		dto.setNome(modelo.getNome() == null ? null : modelo.getNome());
		dto.setEmail(modelo.getEmail() == null ? null : modelo.getEmail());
		dto.setTelefone(modelo.getTelefone() == null ? null : modelo.getTelefone());
		dto.setMatricula(modelo.getMatricula() == null ? null : modelo.getMatricula());
		dto.setCurso(modelo.getCurso() == null ? null : modelo.getCurso());
			
		return dto;
	}
	
	public List<EstudanteDTO> toCollectionModel(List<Estudante> estudantes) {
		return estudantes.stream().map(pessoa -> converterModeloToDto(pessoa)).collect(Collectors.toList());
	}
}
