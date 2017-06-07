package com.template.featureA.service;

import com.template.batis.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jylee on 2017-06-07.
 */
@Service
public class TestService {
    private final TestMapper testMapper;

    @Autowired
    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public String getName() {
        return testMapper.getName();
    }

    public String updateName(String name) {
        testMapper.updateName(1, name);
        return getName();
    }
}
