package mz.gov.misau.mpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "mz.gov.misau.mpc.model")
@ComponentScan(basePackages = {"mz.*"})
@EnableJpaRepositories(basePackages ="mz.gov.misau.mpc.repository")
@EnableTransactionManagement
public class ModuloPlanoContratacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuloPlanoContratacaoApplication.class, args);
	}

}
