package com.template.featureA.service;

import com.template.featureA.domain.TestEntity;
import com.template.featureA.domain.TestRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jylee on 2017-06-07.
 */
@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public void insertSomething(TestEntity testEntity) {
        testRepository.save(testEntity);
    }

    public TestEntity getById(int id) {
        return testRepository.findOne(id);
    }
}
