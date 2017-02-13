package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifecycleBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(LifecycleBean.class);

    public LifecycleBean() {
        LOGGER.info("Instantiate");
    }

    @Autowired
    public void setMessageService(final MessageService messageService) {
        LOGGER.info("Setting MessageService via setter (Populate Properties)");
    }

    @Override
    public void setBeanName(final String s) {
        LOGGER.info("BeanNameAware's setBeanName()");
    }

    @Override
    public void setBeanFactory(final BeanFactory beanFactory) throws BeansException {
        LOGGER.info("BeanFactoryAware's setBeanFactory()");
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        LOGGER.info("ApplicationContextAware's setApplicationContext()");
    }

    public void beanPostProcessorsPreInitialization() {
        LOGGER.info("beanPostProcessorsPreInitialization()");
    }

    /*@PostConstruct
    public void postConstruct() {
        LOGGER.info("postConstruct()");
    }*/

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("InitializingBean's afterPropertiesSet()");
    }

    public void init() {
        LOGGER.info("Call Custom init()");
    }

    public void beanPostProcessorsPostInitialization() {
        LOGGER.info("beanPostProcessorsPostInitialization()");
    }

    /*@PreDestroy
    public void preDestroy() {
        LOGGER.info("preDestroy()");
    }*/

    @Override
    public void destroy() throws Exception {
        LOGGER.info("DisposableBean's destroy()");
    }

    public void customDestroy() throws Exception {
        LOGGER.info("Call Custom customDestroy()");
    }
}
