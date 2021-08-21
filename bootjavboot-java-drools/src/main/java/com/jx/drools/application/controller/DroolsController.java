package com.jx.drools.application.controller;

import com.jx.drools.application.entity.User;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class DroolsController {

    @Autowired
    private KieSession session;
    @Resource
    private KieFileSystem kieFileSystem;

    @RequestMapping("test")
    public void test() {
        User user = new User();
        user.setAddress("北京");
        user.setAge("20");
        user.setName("echo");
        user.setPhone("136123456");
        user.setSex("1");
        // 插入用户
        session.insert(user);
        // 执行规则
        session.fireAllRules();
    }

    @RequestMapping("test2")
    public void test2() throws IOException{
        for (org.springframework.core.io.Resource file : getRuleFiles()) {
            kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + file.getFilename(), "UTF-8"));
        }
    }
    private static final String RULES_PATH = "rules/";

    private org.springframework.core.io.Resource[] getRuleFiles() throws IOException {

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        final org.springframework.core.io.Resource[] resources = resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.*");
        return resources;

    }

}
