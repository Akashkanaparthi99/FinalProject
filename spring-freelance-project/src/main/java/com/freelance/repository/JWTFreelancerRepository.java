package com.freelance.repository;

import com.freelance.model.JWTAppSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JWTFreelancerRepository extends JpaRepository<JWTAppSecurity,Integer> {
    JWTAppSecurity findByUsername(String username);

}
