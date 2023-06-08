package com.Haggle.cloud.common.database.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * /**/ FrozenWatermelon
 * @date 2020/6/24
 */
@Configuration
@MapperScan({ "com.Haggle.cloud.**.mapper" })
public class MybatisConfig {


}
