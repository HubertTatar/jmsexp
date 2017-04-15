package com.hutatar.jmsexp.controller;

import com.hutatar.jmsexp.dto.BugDto;
import com.hutatar.jmsexp.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("bugs")
public class BugsController {

    @Autowired
    private BugService bugService;

    @GetMapping("/{id}")
    public BugDto get(@PathVariable BigInteger id) {
        return bugService.find(id);
    }

    @GetMapping("/list")
    public List<BugDto> list() {
        return bugService.list();
    }

    @PostMapping
    public void post(@RequestBody BugDto bugDto) {
        bugService.create(bugDto);
    }

    @PutMapping
    public void put(@RequestBody BugDto bugDto) {
        bugService.update(bugDto);
    }
}
/*
  {
    "id": 1,
    "createdDate": "15/04/2017 02:30",
    "modificationDate": "15/04/2017 02:30",
    "title": "test",
    "createdBy": "test",
    "description": "test",
    "severity": 1,
    "status": 1,
    "updatedBy": null
  }
 */