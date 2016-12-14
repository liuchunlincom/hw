package com.lcl.hw.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;

/**
 * Created by Rain on 2016/12/13 20:12.
 */
public class PlaceHolderXmlBeanDefinitionReader extends XmlBeanDefinitionReader {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public PlaceHolderXmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        if(resource.exists()) {
            return super.loadBeanDefinitions(resource);
        } else {
            this.logger.warn(resource.toString() + " not found");
            return 0;
        }
    }
}
