package com.epam.course.store.repository;

import com.epam.course.store.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findCustomersByIdGreaterThan(Integer id);

    @Query("SELECT c FROM Customer c JOIN c.info ci WHERE ci.firstName= :firstName")
    List<Customer> findCustomersByFirstName(@Param("firstName") String firstName);
}
