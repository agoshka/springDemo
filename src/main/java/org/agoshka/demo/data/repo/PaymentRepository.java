package org.agoshka.demo.data.repo;

import org.agoshka.demo.data.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author go
 */
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    
}
