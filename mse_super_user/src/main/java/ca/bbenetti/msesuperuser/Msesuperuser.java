package ca.bbenetti.msesuperuser;

import ca.bbenetti.msesuperuser.repository.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class Msesuperuser
{

	public static void main(String[] args)
	{
		SpringApplication.run(Msesuperuser.class, args);
	}
}