package com.bb.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "com.bb.primary.repository", entityManagerFactoryRef = "primaryEntityManagerFactory", transactionManagerRef = "primaryTransactionManager")
public class PrimaryDataSourceConfig {

	@Value("${spring.datasource.url}")
	private String primaryDbUrl;

	@Value("${spring.datasource.username}")
	private String primaryDbUsername;

	@Value("${spring.datasource.password}")
	private String primaryDbPassword;

	@Primary
	@Bean(name = "primaryDataSource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().url(primaryDbUrl).username(primaryDbUsername).password(primaryDbPassword).build();
	}

	@Primary
	@Bean(name = "primaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory( @Qualifier("primaryDataSource") DataSource dataSource ) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("com.bb.primary.model");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaProperties(additionalProperties());
		return emf;
	}

	@Primary
	@Bean(name = "primaryTransactionManager")
	public PlatformTransactionManager primaryTransactionManager( @Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory ) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}
}
