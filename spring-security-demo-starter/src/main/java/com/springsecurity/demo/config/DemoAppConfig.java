package com.springsecurity.demo.config;

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
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig  implements WebMvcConfigurer {
	
	// Setup a variable to hold the data read from properties file
	@Autowired
	private Environment env;
	
	// Setup a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// Define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver lViewResolver = new InternalResourceViewResolver();
		lViewResolver.setPrefix("/WEB-INF/view/");
		lViewResolver.setSuffix(".jsp");
		return lViewResolver;
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }
    
    // Define a bean for our security data source
    @Bean
    public DataSource securityDataSource() {
    	
    	// Create a connection pool
    	ComboPooledDataSource lComboPooledDataSource = new ComboPooledDataSource();
    	
    	// Set the JDBC driver class
    	try {
			lComboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
    	
    	// log the connection props for sanity's sake
    	logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
    	logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
    	
    	// Set database connection props
    	lComboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
    	lComboPooledDataSource.setUser(env.getProperty("jdbc.user"));
    	lComboPooledDataSource.setPassword(env.getProperty("jdbc.password"));
    	
    	// Set connection pool props
    	lComboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
    	lComboPooledDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
    	lComboPooledDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
    	lComboPooledDataSource.setMaxIdleTimeExcessConnections(getIntProperty("connection.pool.maxIdleTime"));
    	
    	return lComboPooledDataSource;
    }
    
    // Read Environment property and convert it to int
    private int getIntProperty(String iPropName) {
    	String lPropValue = env.getProperty(iPropName);
    	return Integer.parseInt(lPropValue);
    }

}
