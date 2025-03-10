package com.simplecrud.backend.domain.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "client")
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class ClientModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "first_name", length = 150)
    private String firstName;
    @Column(nullable = false, name = "last_name", length = 150)
    private String lastName;
    @Column(unique = true, nullable = false, length = 150)
    private String email;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private UserModel user;
    @OneToOne
    @JoinColumn(name = "address_id", unique = true)
    private AddressModel address;
    
}