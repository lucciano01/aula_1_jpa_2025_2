package br.edu.catolica.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("PESSOA_JURIDICA")
@Getter
@Setter
@ToString(callSuper = true)
public class PessoaJuridica extends Pessoa {

    private String cnpj;


}
