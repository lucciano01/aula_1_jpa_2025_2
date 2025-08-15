package br.edu.catolica.service;

import br.edu.catolica.domain.Customer;
import br.edu.catolica.factory.ConnectionFactory;
import jakarta.persistence.TypedQuery;

public class CustomerService {
    private ConnectionFactory connectionFactory;

    public CustomerService(){
        connectionFactory = new ConnectionFactory();
    }

    public void saveOrUpdate(Customer customer){
      try{
          connectionFactory.getEntityManager();
          connectionFactory.initTransaction();
          connectionFactory.getEntityManager().merge(customer);
          connectionFactory.commitTransaction();
          connectionFactory.closeTransaction();

      } catch (Exception e) {
          System.out.println("Erro no saveAndMerge :" +e.getMessage());
      }

    }

    public Customer findById(Long id){
     try{
         connectionFactory.getEntityManager();
         connectionFactory.initTransaction();
         var customer = connectionFactory
                 .getEntityManager().find(Customer.class, id);
         connectionFactory.closeTransaction();
         return customer;
     } catch (Exception e) {
         throw new RuntimeException(e);
     }

    }

    public Customer findByCpf(String cpf){
        var query = connectionFactory.getEntityManager()
                .createNamedQuery("customer.ByCpf");
        query.setParameter("cpf", cpf);
        return (Customer) query.getSingleResult();
    }

    public Customer findByCpfTypedQuery(String  cpf){
        TypedQuery<Customer> query = connectionFactory
                .getEntityManager().createNamedQuery("customer.ByCpf", Customer.class);
       query.setParameter("cpf", cpf);
        return query.getSingleResult();
    }

    public Customer findByCpfFetch(String  cpf){
        TypedQuery<Customer> query = connectionFactory
                .getEntityManager().createNamedQuery("customer.FetchByCpf", Customer.class);
        query.setParameter("cpf", cpf);
        return query.getSingleResult();
    }
}
