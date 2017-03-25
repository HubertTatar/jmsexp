package com.hutatar.jmsexp.util;

import java.util.UUID;

public abstract class BasicUtil {

    public static String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}
