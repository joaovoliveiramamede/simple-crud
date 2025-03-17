package com.simplecrud.backend.domain.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
    @Column(length = 255, nullable = false)
    private String street;
    @Column(length = 255, nullable = false)
    private String neighborhood;
    @Column(length = 255, nullable = false)
    private String number;
    @Column(length = 255, nullable = false)
    private String city;
    @Column(length = 255, nullable = false)
    private String zipCode;
    @Column(length = 255, nullable = true)
    private String complement;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private ClientModel client;
}
