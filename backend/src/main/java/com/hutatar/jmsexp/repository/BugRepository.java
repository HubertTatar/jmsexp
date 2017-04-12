package com.hutatar.jmsexp.repository;

import com.hutatar.jmsexp.domain.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface BugRepository extends JpaRepository<Bug, BigInteger>{
}
