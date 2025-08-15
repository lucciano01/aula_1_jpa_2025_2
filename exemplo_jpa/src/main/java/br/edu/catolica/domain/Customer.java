package br.edu.catolica.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQueries({
        @NamedQuery(name = "customer.ByCpf", query = "select c from Customer c where c.cpf = :cpf"),
        @NamedQuery(name = "customer.FetchByCpf", query = "select c from Customer c" +
                " join fetch c.vehicles v join fetch v.accessorieSet a where c.cpf =:cpf")
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Vehicle> vehicles;
}
