package com.hutatar.jmsexp.profile;

import com.hutatar.jmsexp.security.auth.JwtAuthenticationToken;
import com.hutatar.jmsexp.security.model.UserContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileEndpoint {
    @RequestMapping(value="/api/me", method= RequestMethod.GET)
    public @ResponseBody
    UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }
}