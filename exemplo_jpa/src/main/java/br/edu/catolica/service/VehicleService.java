package br.edu.catolica.service;

import br.edu.catolica.domain.Vehicle;
import br.edu.catolica.factory.ConnectionFactory;

import java.util.List;

public class VehicleService {

    private ConnectionFactory connectionFactory;

    public VehicleService(){
        connectionFactory = new ConnectionFactory();
    }

    public List<Vehicle> getAllVehicles(){
        var query = connectionFactory.getEntityManager()
                .createNamedQuery("vehicle.getAll");
        return query.getResultList();
    }
}
