package com.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorSample implements BeanPostProcessor {

    private static final String LIFECYCLE_BEAN_NAME = "lifecycleBean";

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (LIFECYCLE_BEAN_NAME.equals(beanName)) {
            ((LifecycleBean)bean).beanPostProcessorsPostInitialization();
        }

        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        if (LIFECYCLE_BEAN_NAME.equals(beanName)) {
            ((LifecycleBean)bean).beanPostProcessorsPreInitialization();
        }

        return bean;
    }
}
