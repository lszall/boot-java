package com.jx.platform.framework.config.validator;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @ClassName ValidatorConfig
 * @Description: 验证配置类
 * @Author: lsz
 * @Date: 2019/12/17 10:08
 * @version: v1.0
 **/
@Configuration
public class ValidatorConfig {

    /**
     * 是否快速验证
     */
    @Value("${hibernate.validator.fail_fast}")
    private String validateModel;


    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure() // true-快速失败返回模式    false-普通模式
                .messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("i18n/validation/messages")))  //  -国际化配置
                .addProperty("hibernate.validator.fail_fast", validateModel)
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        /**设置validator模式为快速失败返回*/
        postProcessor.setValidator(validator());
        return postProcessor;
    }
}
