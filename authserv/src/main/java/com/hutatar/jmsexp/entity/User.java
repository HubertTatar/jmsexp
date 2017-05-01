package com.hutatar.jmsexp.entity;

import lombok.Getter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Parameter;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name="SEC_APP_USER", schema = "auth", indexes = {
        @Index(columnList = "username", unique = true, name="sec_app_user_idx_2")
})
public class User {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String username;
    private String password;
    @OneToMany
    @JoinColumn(name="SEC_APP_USER_ID", referencedColumnName = "ID")
    private List<UserRole> roles;

    public User() {}


}
