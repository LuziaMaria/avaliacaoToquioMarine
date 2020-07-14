package br.com.tokiomarine.seguradora.avaliacao.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ESTUDANTE")
public class Estudante {
	// TODO Implementar a entidade Estudante conforme solicitado
	
	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 				//(chave com auto incremento)
	
	@NotBlank(message = "Nome é obrigatório")
	@Column(name = "NOME", length = 40, nullable = false)
	private String nome;  			// (com validação para não nulo e mensagem: Nome é obrigatório)
	
	@NotBlank(message = "Email é obrigatório")
	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email; 			// (com validação para não nulo e mensagem: Email é obrigatório)
	
	@Column(name = "TELEFONE", length = 15, nullable = false)
	private String telefone;
	
	@NotBlank(message = "Matrícula é obrigatório")
	@Column(name = "MATRICULA", length = 15, nullable = false)
	private String matricula;     // (com validação para não nulo e mensagem: Matricula é obrigatório)
	
	@Column(name = "CURSO", length = 30)
	private String curso;

	
	
}
