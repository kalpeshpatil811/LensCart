package com.lenscart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenscart.entity.Lenses;

@Repository
public interface LensesRepository extends JpaRepository<Lenses, Integer> {

}
