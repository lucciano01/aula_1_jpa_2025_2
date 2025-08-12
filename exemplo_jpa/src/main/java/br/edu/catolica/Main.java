package br.edu.catolica;

import br.edu.catolica.domain.Accessorie;
import br.edu.catolica.domain.Address;
import br.edu.catolica.domain.Customer;
import br.edu.catolica.domain.Vehicle;
import br.edu.catolica.service.CustomerService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        var joe = Customer.builder()
//                .id(1L)
//                .name("Joe McFly")
//                .cpf("444444")
//                .email("joe123@gmail.com")
//                .build();

        var customerService = new CustomerService();
        System.out.println("Realizando operacao no BD");
        var joe = customerService.findById(1L);
//        var address = Address.builder()
//                .zipCode("58900-00")
//                .city("New Jersey")
//                .number("250")
//                .street("7th Avenue")
//                .build();
//        joe.setAddress(address);
//        var vehicles = List.of(Vehicle.builder()
//                .model("Ferrari")
//                .price(120000.0)
//                .year(2022)
//                .build(),
//                Vehicle.builder()
//                        .model("BMW")
//                        .price(520000.0)
//                        .year(2023)
//                        .build()
//                );
//        joe.setVehicles(vehicles);

        var accessories = List.of(Accessorie.builder()
                .description("Multimedia")
                .price(1500.0)
                .build(),
        Accessorie.builder()
                .description("Automatic Pilot")
                .price(900.0)
                .build());

        customerService.saveOrUpdate(joe);

    }
}