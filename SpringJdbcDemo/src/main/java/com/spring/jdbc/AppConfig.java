package com.spring.jdbc;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
//@EnableTransactionManagement
public class AppConfig {

	/**
	 * following method provides with functionalities to communicate
	 * with database and open connection to database
	 * @return
	 */
	@Bean
	public DataSource dataSource()
	{
		System.out.println("creating data source");
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:8889/gl2023");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.spring.jdbc.entity");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		System.out.println("session factory created");
		return sessionFactoryBean;
	}
//	@Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//		System.out.println("tx manager");
//        HibernateTransactionManager transactionManager
//          = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getSessionFactory().getObject());
//        System.out.println(transactionManager);
//        return transactionManager;
//    }
 
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        return hibernateProperties;
    }
	

	@Bean
	@Autowired
	public JdbcTemplate template(DataSource source)
	{
		System.out.println("template craeted");
		return new JdbcTemplate(source);
	}
}
