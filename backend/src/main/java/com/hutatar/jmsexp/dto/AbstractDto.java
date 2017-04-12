package com.hutatar.jmsexp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
public abstract class AbstractDto {
    //fields from abstract
    private BigInteger id;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private LocalDateTime createdDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private LocalDateTime modificationDate;

    public AbstractDto(BigInteger id, LocalDateTime createdDate, LocalDateTime modificationDate) {
        this.id = id;
        this.createdDate = createdDate;
        this.modificationDate = modificationDate;
    }
}
