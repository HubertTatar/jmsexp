package com.hutatar.jmsexp.security.auth.jwt.extractor;

public interface TokenExtractor {
    public String extract(String payload);
}