package com.customer.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")
public class HibernateConfig {

	@Autowired
	Environment environment;

	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String userName;
	@Value("${jdbc.password}")
	private String password;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		System.out.println("HibernateConfig.sessionFactory()");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setDataSource(dataSourceByValue());
		sessionFactory.setPackagesToScan(new String[] { "com.student.model" });
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		System.out.println("HibernateConfig.hibernateProperties()");
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	@Bean
	public DataSource dataSourceByValue() {
		System.out.println("HibernateConfig.dataSourceByValue()");
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(driverClassName);
		datasource.setUrl(url);
		datasource.setUsername(userName);
		datasource.setPassword(password);
		return null;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager createTransaction(SessionFactory session) {
		System.out.println("HibernateConfig.createTransaction()");
		HibernateTransactionManager ht = new HibernateTransactionManager();
		ht.setSessionFactory(session);
		return ht;
	}
}
