package com.lenscart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenscart.entity.Glass;

/***************************
 * Glass Repository Class
 *
 * Created By: Disha Kale
 * Date: 09/08/2022
 ***************************/

@Repository
public interface GlassRepository extends JpaRepository<Glass, Integer> {

}
