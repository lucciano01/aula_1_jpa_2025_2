package br.edu.catolica.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Entity
@DiscriminatorValue("PESSOA_FISICA")
@Getter
@Setter
public class PessoaFisica extends Pessoa {

    private String cpf;
}
