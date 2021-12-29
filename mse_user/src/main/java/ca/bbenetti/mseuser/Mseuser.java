package ca.bbenetti.mseuser;

import ca.bbenetti.mseuser.repository.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class Mseuser
{

	public static void main(String[] args)
	{
		SpringApplication.run(Mseuser.class, args);
	}
}