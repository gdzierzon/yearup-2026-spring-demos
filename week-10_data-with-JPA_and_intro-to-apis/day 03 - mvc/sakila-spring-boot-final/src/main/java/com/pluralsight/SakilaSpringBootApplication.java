package com.pluralsight;

import com.pluralsight.services.ActorsDao;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
public class SakilaSpringBootApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SakilaSpringBootApplication.class, args);

		ApplicationContext context = SpringApplication.run(SakilaSpringBootApplication.class, args);

		var beans = context.getBeansOfType(ActorsDao.class);

		for(Map.Entry<String, ActorsDao> bean : beans.entrySet())
		{
			System.out.println(bean.getKey() + " : " + bean.getValue());
		}

//		Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);
	}

}
