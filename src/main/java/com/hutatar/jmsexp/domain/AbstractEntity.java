package com.hutatar.jmsexp.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@MappedSuperclass
@Getter
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "ids_sequence")
    @SequenceGenerator(name = "ids_sequence", schema = "orders")
    private BigInteger id;
    @Version
    private Integer version;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime createdDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime modificationDate;

    public AbstractEntity(){}

    public AbstractEntity(BigInteger id, Integer version, LocalDateTime createdDate, LocalDateTime modificationDate) {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.modificationDate = modificationDate;
    }

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        modificationDate = now;
    }

    @PreUpdate
    public void preUpdate() {
        modificationDate = LocalDateTime.now();
    }
}
