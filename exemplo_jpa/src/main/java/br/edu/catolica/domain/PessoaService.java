package br.edu.catolica.domain;

import br.edu.catolica.factory.ConnectionFactory;

public class PessoaService {

    private ConnectionFactory connectionFactory;

    public PessoaService(){
        connectionFactory = new ConnectionFactory();
    }

    public void save(PessoaFisica pf){
        connectionFactory.getEntityManager();
        connectionFactory.initTransaction();
        connectionFactory.getEntityManager().persist(pf);
        connectionFactory.commitTransaction();
        connectionFactory.closeTransaction();
    }

    public void save(PessoaJuridica pj){
        connectionFactory.getEntityManager();
        connectionFactory.initTransaction();
        connectionFactory.getEntityManager().persist(pj);
        connectionFactory.commitTransaction();
        connectionFactory.closeTransaction();
    }

    public PessoaJuridica findById(Long id){
        connectionFactory.getEntityManager();
        connectionFactory.initTransaction();
       return connectionFactory.getEntityManager().find(PessoaJuridica.class, id);
    }
}
