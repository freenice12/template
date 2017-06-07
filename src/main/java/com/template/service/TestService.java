package com.template.service;

import com.template.batis.mapper.TestMapper;
import com.template.domain.TestEntity;
import com.template.domain.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jylee on 2017-06-07.
 */
@Service
public class TestService {
    private final TestMapper testMapper;
    private final TestRepository testRepository;

    @Autowired
    public TestService(TestMapper testMapper, TestRepository testRepository) {
        this.testMapper = testMapper;
        this.testRepository = testRepository;
    }

    public String getName() {
        return testMapper.getName();
    }

    public String updateName(String name) {
        testMapper.updateName(1, name);
        throw new RuntimeException();
    }

    public int getLastIndex() {
        return testMapper.getLastIndex();
    }

    public int getNewIndex() {
        return getLastIndex() + 1;
    }

    public String insert(String name, int age) {
        testRepository.save(new TestEntity(getNewIndex(), name, age));
        return name;
    }
}
