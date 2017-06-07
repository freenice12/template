package com.template.featureA.domain;

import javax.persistence.*;

/**
 * Created by jylee on 2017-06-07.
 */
@Entity
@Table(name = "TEST")
public class TestEntity {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private int age;

    public TestEntity() {
    }

    public TestEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestEntity(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
