package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.controller;

import lombok.experimental.PackagePrivate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    String msg = "hello from springBoot server";
    @GetMapping(path = "/")
    public String getServer(){
        return msg;
    }
}
