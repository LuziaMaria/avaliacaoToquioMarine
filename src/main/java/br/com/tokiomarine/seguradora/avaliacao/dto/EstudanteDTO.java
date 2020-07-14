package br.com.tokiomarine.seguradora.avaliacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EstudanteDTO {
	
	private Long id; 				//(chave com auto incremento)
	
	//  @NotBlank(message = "Nome é obrigatório")
	private String nome;  			// (com validação para não nulo e mensagem: Nome é obrigatório)
	
	// @NotBlank(message = "Email é obrigatório")
	private String email; 			// (com validação para não nulo e mensagem: Email é obrigatório)
	
	private String telefone;
	
	// @NotBlank(message = "Matrícula é obrigatório")
	private String matricula;     // (com validação para não nulo e mensagem: Matricula é obrigatório)

	private String curso;
}
