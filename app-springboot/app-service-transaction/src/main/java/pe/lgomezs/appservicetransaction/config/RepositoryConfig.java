package pe.lgomezs.appservicetransaction.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = "pe.lgomezs.appservicetransaction")
@EntityScan(basePackages = {"pe.lgomezs.appservicetransaction.domain"})
public class RepositoryConfig {
}
