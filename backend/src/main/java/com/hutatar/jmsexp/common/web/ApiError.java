package com.hutatar.jmsexp.common.web;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    private int status;
    private String message;
    private String devMessage;
}