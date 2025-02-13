package com.simplecrud.backend.domain.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "address")
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Data @Builder
public class AddressModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String neighborhood;
    private String number;
    private String city;
    private String zipCode;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private ClientModel client;
}
