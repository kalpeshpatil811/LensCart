package com.lenscart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenscart.entity.Lenses;

/*********
 * Lenses Repository Class
 *
 * Created By: Sachin Phatak
 * Date: 09/08/2022
 *********/


@Repository
public interface LensesRepository extends JpaRepository<Lenses, Integer> {

}
