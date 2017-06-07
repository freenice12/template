package com.template.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jylee on 2017-06-07.
 */
@Configuration
@MapperScan(basePackages = "com.template.batis.mapper")
public class BatisConfig {
}
