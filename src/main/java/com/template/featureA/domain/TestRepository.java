package com.template.featureA.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jylee on 2017-06-07.
 */
@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
}
