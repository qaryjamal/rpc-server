package com.rpc;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.rpc.server.RPCServer;
import com.rpc.utils.StaticRPC;

@SpringBootApplication(scanBasePackages = { "com.rpc" }, exclude = { WebMvcAutoConfiguration.class })
@EnableJpaRepositories("com.rpc.repo")
@EntityScan("com.rpc.entity")
@ComponentScan("com.rpc")
@PropertySource(value = { "classpath:application.properties" })
public class RpcProjectAsDataStoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(RpcProjectAsDataStoreApplication.class, args);
	}

	@Bean
	public void myBean() {
		try {
			new RPCServer(StaticRPC.PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

}
