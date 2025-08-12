package br.edu.catolica.factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Objects;

public class ConnectionFactory {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public ConnectionFactory(){
        entityManagerFactory =
                Persistence.createEntityManagerFactory("exemplo_jpa");
    }

    public EntityManager getEntityManager(){
        if(Objects.isNull(entityManager) || !entityManager.isOpen()){
            entityManager = entityManagerFactory.createEntityManager();
        }
        return  entityManager;
    }

    public void initTransaction(){
        entityManager.getTransaction().begin();
    }

    public void commitTransaction(){
        entityManager.getTransaction().commit();
    }

    public void closeTransaction(){
        entityManager.close();
    }
}
