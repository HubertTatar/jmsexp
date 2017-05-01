package com.hutatar.jmsexp.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "auth.security.jwt")
public class JwtSettings {
    private Integer tokenExpirationTime;
    private String tokenIssuer;
    private String tokenSigningKey;
    private Integer refreshTokenExpTime;
}
