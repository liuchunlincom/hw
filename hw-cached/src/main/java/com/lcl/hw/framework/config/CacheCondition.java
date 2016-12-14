package com.lcl.hw.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.io.File;

/**
 * Created by Rain on 2016/12/13 20:01.
 */
public class CacheCondition implements Condition {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CacheCondition() {
    }

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }

    public String getAppRoot() {
        String appRoot = System.getProperty("webapp.root");
        if(appRoot == null) {
            appRoot = System.getProperty("app.root");
        }

        return appRoot;
    }

    public boolean isWebXmlExist() {
        String appRoot = this.getAppRoot();
        String appEnv = System.getProperty("app.env");
        File webxml;
        if(appRoot == null) {
            webxml = new File(".");
            if(appEnv == null) {
                appEnv = "dev";
            }

            if("dev".equals(appEnv)) {
                File webappFile = new File(webxml, "src/main/webapp");
                appRoot = webappFile.getAbsolutePath();
            }
        }

        webxml = new File(appRoot, "WEB-INF/web.xml");
        if(webxml.exists()) {
            this.logger.info("web.xml found: " + webxml.getAbsolutePath());
            return true;
        } else {
            this.logger.info("web.xml not found");
            return false;
        }
    }
}

