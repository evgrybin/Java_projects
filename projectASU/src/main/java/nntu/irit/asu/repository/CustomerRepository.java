package nntu.irit.asu.repository;

import nntu.irit.asu.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Даша on 16.03.2017.
 */

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
