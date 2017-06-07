package com.template.controller;

import com.template.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jylee on 2017-06-05.
 */
@Controller
public class FeatureAController {

    private final TestService testService;

    @Autowired
    public FeatureAController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public String badExample() {
        System.out.println("badExample");
        String name = testService.getName();
        System.out.println("Name: " + name);
        return name;
    }

    @GetMapping(value = "/insert")
    @ResponseBody
    public String insert(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
        System.out.println("insert");
        System.out.println("inserted: " + testService.insert(name, age));
        return name;
    }

    @GetMapping(value = "/update")
    @ResponseBody
    public String update(@RequestParam(name = "name") String name) {
        System.out.println("update");
        System.out.println("Name: " + testService.updateName(name));
        return name;
    }

}

