package com.hutatar.jmsexp.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "bugs", schema = "orders", indexes = {
        @Index(columnList = "id, version", unique = true, name="bugs_idx_1"),
        @Index(columnList = "title", name = "bugs_idx_2"),
        @Index(columnList = "createdBy", name = "bugs_idx_3")
})
@Getter
public class Bug extends AbstractEntity {
    private String title;
    private String createdBy;
    private String description;
    private Short severity;
    private Short status;
    private String updatedBy;

    public Bug(){}

    @Builder
    private Bug(BigInteger id, Integer version, LocalDateTime createdDate, LocalDateTime modificationDate, String title, String createdBy, String description, Short severity, Short status, String updatedBy) {
        super(id, version, createdDate, modificationDate);
        this.title = title;
        this.createdBy = createdBy;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.updatedBy = updatedBy;
    }
}
