package io.doosti.hamid.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="io.doosti.hamid.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		 
		return viewResolver;
	}
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource sercurityDatasource = new ComboPooledDataSource();
		try {
			System.out.println("In db try block");
			sercurityDatasource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			System.out.println("In db try catch");
			throw new RuntimeException(exc);
		}
		
		logger.info(">>> jdbc.url = " + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user = " + env.getProperty("jdbc.user"));
		
		sercurityDatasource.setJdbcUrl(env.getProperty("jdbc.url"));
		sercurityDatasource.setJdbcUrl(env.getProperty("jdbc.user"));
		sercurityDatasource.setJdbcUrl(env.getProperty("jdbc.password"));
		
		sercurityDatasource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize")); 
		sercurityDatasource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		sercurityDatasource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		sercurityDatasource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return sercurityDatasource;
		
	}
	
	private int getIntProperty(String porpName) {
		String propval = env.getProperty(porpName);
		int intPropVal = Integer.parseInt(propval);
		return intPropVal;
	}
	
}

