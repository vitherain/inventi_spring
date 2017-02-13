package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class DemoApplication {

	@Bean(initMethod = "init", destroyMethod = "customDestroy")
	public LifecycleBean lifecycleBean() {
		return new LifecycleBean();
	}

	public static void main(String[] args) {
		final ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		((AbstractApplicationContext)context).close();
	}
}
