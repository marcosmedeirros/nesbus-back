package br.marcos.nesbusapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.marcos.nesbusapi.model")
@EntityScan("br.marcos.nesbusapi.model")
public class NesbusapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NesbusapiApplication.class, args);
	}

	@Bean
	public FlywayMigrationStrategy repairFlyway() {
		return flyway -> {
			flyway.repair();
			flyway.migrate();
		};
	}


}

