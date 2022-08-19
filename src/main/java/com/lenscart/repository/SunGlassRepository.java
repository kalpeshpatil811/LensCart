package com.lenscart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenscart.entity.SunGlasses;

/***************************
 * Sun Glasses Repository Class
 *
 * Created By: Kalpesh Patil
 * Date: 09/08/2022
 ***************************/


@Repository
public interface SunGlassRepository extends JpaRepository<SunGlasses, Integer> {

}
