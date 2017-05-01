package com.hutatar.jmsexp.security.auth.jwt.verifier;

import org.springframework.stereotype.Component;

@Component
public class MyTokenVerifier implements TokenVerifier {
        @Override
        public boolean verify(String jti) {
            return true;
        }
    }