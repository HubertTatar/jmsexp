package com.hutatar.jmsexp.user.repository;

import com.hutatar.jmsexp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger>{
    @Query("select u from User u left join fetch u.roles r where u.username=:username")
    public Optional<User> findByUsername(@Param("username") String username);
}
