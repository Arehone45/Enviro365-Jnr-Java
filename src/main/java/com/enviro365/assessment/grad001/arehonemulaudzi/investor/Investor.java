package com.enviro365.assessment.grad001.arehonemulaudzi.investor;

import com.enviro365.assessment.grad001.arehonemulaudzi.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String idNumber;
    private String address;
    private String contactNo;
    @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products;
}
