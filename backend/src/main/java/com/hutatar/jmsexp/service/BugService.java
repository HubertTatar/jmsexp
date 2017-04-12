package com.hutatar.jmsexp.service;

import com.hutatar.jmsexp.dto.BugDto;

import java.math.BigInteger;
import java.util.List;

public interface BugService {

    List<BugDto> list();
    BugDto find(BigInteger id);
    void update(BugDto bugDto);
    void create(BugDto bugDto);

}
