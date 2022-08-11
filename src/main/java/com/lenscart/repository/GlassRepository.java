package com.lenscart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenscart.entity.Glass;

@Repository
public interface GlassRepository extends JpaRepository<Glass, Integer> {

}
