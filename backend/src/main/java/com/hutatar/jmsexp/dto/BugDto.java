package com.hutatar.jmsexp.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class BugDto extends AbstractDto {

    private String title;
    private String createdBy;
    private String description;
    private Short severity;
    private Short status;
    private String updatedBy;

    public BugDto(){
        super();
    }

    @Builder
    public BugDto(BigInteger id, LocalDateTime createdDate, LocalDateTime modificationDate, String title, String createdBy, String description, Short severity, Short status, String updatedBy) {
        super(id, createdDate, modificationDate);
        this.title = title;
        this.createdBy = createdBy;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.updatedBy = updatedBy;
    }
}
