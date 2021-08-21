package com.jx.platform.framework.config.formart;


import org.springframework.context.annotation.Configuration;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * LocaDateTime 全局格式化
 *
 * 全局的格式化方式无法满足我们需求时，使可以通过  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 注解指定更为精准的为日期字段格式化，注解方案比配置方案优先级高，二者可结合使用
 */
@Configuration
public class LocalDateTimeSerializerConfig {

    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
    private String pattern;

    // 方案一
    @Bean
    public LocalDateTimeSerializer localDateTimeDeserializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeDeserializer());
    }

}