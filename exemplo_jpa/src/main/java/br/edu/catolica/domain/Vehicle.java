package br.edu.catolica.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@NamedQueries({
       @NamedQuery(name = "vehicle.getAll", query = "select v from Vehicle v")
})
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;

    private Double price;

    private String model;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "vehicle_accessorie",
     joinColumns = @JoinColumn(name = "vehicle_id"),
     inverseJoinColumns = @JoinColumn(name = "accessorie_id"))
    private Set<Accessorie> accessorieSet;
}
