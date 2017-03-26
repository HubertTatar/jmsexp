package com.hutatar.jmsexp.domain;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;


@MappedSuperclass
@Getter
public abstract class AbstractEntity {

    @Id
    @GenericGenerator(
            name = "idSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ids_sequence"),
                    @Parameter(name = "schema", value = "orders"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "idSequenceGenerator")
    private BigInteger id;
    @Version
    private Integer version;
    private LocalDateTime createdDate;
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
