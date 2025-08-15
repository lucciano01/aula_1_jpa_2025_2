package br.edu.catolica;

import br.edu.catolica.domain.Accessorie;
import br.edu.catolica.domain.Address;
import br.edu.catolica.domain.Customer;
import br.edu.catolica.domain.Vehicle;
import br.edu.catolica.service.CustomerService;
import br.edu.catolica.service.VehicleService;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

//        var joe = Customer.builder()
//                .name("Joe McFly")
//                .cpf("444444")
//                .email("joe123@gmail.com")
//                .build();

        var customerService = new CustomerService();
        System.out.println("Realizando operacao no BD");
       // customerService.saveOrUpdate(joe);
        var joe = customerService.findById(1L);
        var address = Address.builder()
                .zipCode("58900-00")
                .city("New Jersey")
                .number("250")
                .street("7th Avenue")
                .build();
        //joe.setAddress(address);
        var vehicles = List.of(Vehicle.builder()
                .model("Ferrari")
                .price(120000.0)
                .year(2022)
                .build(),
                Vehicle.builder()
                        .model("BMW")
                        .price(520000.0)
                        .year(2023)
                        .build()
                );
        //joe.setVehicles(vehicles);

        var accessoriesFerrari = Set.of(Accessorie.builder()
                .description("Multimedia")
                .price(1500.0)
                .build(),
        Accessorie.builder()
                .description("Automatic Pilot")
                .price(900.0)
                .build());

        var accessoriesBmw = Set.of(Accessorie.builder()
                        .description("DVD")
                        .price(2500.0)
                        .build(),
                Accessorie.builder()
                        .description("Air Bag")
                        .price(1400.0)
                        .build());

        //todo -> buscar os veiculos na base de dados e adicionar os acessorios
//        joe.getVehicles().get(0).setAccessorieSet(accessoriesFerrari);
//        joe.getVehicles().get(1).setAccessorieSet(accessoriesBmw);
        //customerService.saveOrUpdate(joe);
        //var vehicleService = new VehicleService();
        //System.out.println(vehicleService.getAllVehicles());

        //System.out.println(customerService.findByCpf("444444"));
       System.out.println(customerService.findByCpfFetch("444444"));

    }
}