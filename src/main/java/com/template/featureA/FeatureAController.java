package com.template.featureA;

import com.template.batis.mapper.TestMapper;
import com.template.featureA.service.TestService;
import com.template.featureA.domain.TestEntity;
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

    @GetMapping(value = "/update")
    @ResponseBody
    public String update(@RequestParam(name = "name") String name) {
        System.out.println("update");
        System.out.println("Name: " + testService.updateName(name));
        return name;
    }

}

