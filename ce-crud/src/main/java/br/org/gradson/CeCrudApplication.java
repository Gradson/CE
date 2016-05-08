package br.org.gradson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("br.org.gradson")
@EntityScan("br.org.gradson.ce.model")
@EnableJpaRepositories("br.org.gradson.ce.repository")
public class CeCrudApplication extends SpringBootServletInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(CeCrudApplication.class);
	}

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(CeCrudApplication.class);
	}
	
}
