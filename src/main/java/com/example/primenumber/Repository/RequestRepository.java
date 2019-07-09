package com.example.primenumber.Repository;

import com.example.primenumber.Entity.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Requests, Long> {

   Requests findById(long id);
}
