package com.lcl.hw.framework.config;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Rain on 2016/12/13 20:09.
 */
@Configuration
@Conditional({CacheCondition.class})
@ImportResource(
        value = {"classpath:applicationContext-${cache_provider}.xml"},
        reader = PlaceHolderXmlBeanDefinitionReader.class
)
public class CacheConfig {
    public CacheConfig() {
    }
}
