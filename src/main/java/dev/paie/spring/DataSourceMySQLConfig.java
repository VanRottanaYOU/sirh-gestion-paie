package dev.paie.spring;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan({"dev.paie.service", "dev.paie.util"})
@ImportResource("classpath:jdd-config.xml")
public class DataSourceMySQLConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sirh-paie");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
}
