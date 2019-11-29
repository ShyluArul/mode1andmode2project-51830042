package com.bankapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.bankapp.model" })
@EnableTransactionManagement
@PropertySource(value="classpath:db.properties")
public class ModelConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dm=new DriverManagerDataSource();
		dm.setUrl(env.getProperty("jdbc.url"));
		dm.setDriverClassName(env.getProperty("jdbc.drivername"));
		dm.setPassword(env.getProperty("jdbc.username"));
		dm.setUsername(env.getProperty("jdbc.password"));
		return dm;
	}
	@Bean
	@Autowired
	LocalSessionFactoryBean getLocalSessionFactoryBean(DataSource dataSource) {
		LocalSessionFactoryBean localSessionFB = new LocalSessionFactoryBean();

		localSessionFB.setDataSource(dataSource);
		localSessionFB.setPackagesToScan("com.bankapp.model.dao");

		localSessionFB.setHibernateProperties(getHibernateProperties());
		return localSessionFB;
	}
	@Bean
	public Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager getHibernateTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory);
		return htm;
	}
}
