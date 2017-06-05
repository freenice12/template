package com.template.featureA;

import com.template.batis.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jylee on 2017-06-05.
 */
@Controller
public class FeatureAController {
    @Autowired
    private TestMapper testMapper;

    @GetMapping(value = "/test")
    @ResponseBody
    public String badExample() {
        System.out.println("start");
        String name = testMapper.getName();
        System.out.println("Name: " + name);
        return name;
    }

}
