package com.novemberecho.payment.Repository;

import com.novemberecho.payment.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface paymentrepo extends JpaRepository<Payment,Integer> {
}
