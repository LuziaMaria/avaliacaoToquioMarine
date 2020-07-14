package br.com.tokiomarine.seguradora.avaliacao.mapper;


public interface Mapper<D, M> {

	M converterDtoToModelo(D dto);
	D converterModeloToDto(M modelo);

}
