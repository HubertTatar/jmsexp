package com.hutatar.jmsexp.repository;

import com.hutatar.jmsexp.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface OrderRepository extends JpaRepository<Order, BigInteger> {
}
