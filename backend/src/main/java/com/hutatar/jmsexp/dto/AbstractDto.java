package com.hutatar.jmsexp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public abstract class AbstractDto {
    //fields from abstract
    private BigInteger id;
    private Long createdDate;
    private Long modificationDate;

    public AbstractDto(BigInteger id, LocalDateTime createdDate, LocalDateTime modificationDate) {
        this.id = id;
        this.createdDate = createdDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        this.modificationDate = modificationDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
