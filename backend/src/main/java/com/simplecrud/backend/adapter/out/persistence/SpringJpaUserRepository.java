package com.simplecrud.backend.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplecrud.backend.domain.model.UserModel;

@Repository
public interface SpringJpaUserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    Page<UserModel> findAll(Pageable pageable);
}
