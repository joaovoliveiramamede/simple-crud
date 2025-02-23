package com.simplecrud.backend.domain.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "provider")
@Table(name = "provider")
@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class ProviderModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "social_reason", unique = true, nullable = false)
    private String socialReason;
    @Column(name = "register_number", unique = true, nullable = false)
    private String registerNumber;
    @Column(name = "service", nullable = false)
    private String service;
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClientModel> clients;
}
