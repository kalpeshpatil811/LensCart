package com.lenscart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenscart.entity.Customer;

/*********
 * Customer Repository Interface
 *
 * Created By: Akshata Gurupwar
 * Date: 09/08/2022
 *********/


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByCustomerName(String customerName);

}
