package com.cg.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories(basePackages= {"com.cg.db"})
@EntityScan(basePackages= {"com.cg.*"})
@EnableAutoConfiguration
public class config {
	@Autowired
	private Environment env;
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
		@Bean
		@Primary
		public DataSource dataSource()
		{
			//return DataSourceBuilder.create().build();
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		    dataSource.setUrl(env.getProperty("spring.datasource.url"));
		    dataSource.setUsername(env.getProperty("spring.datasource.username"));
		    dataSource.setPassword(env.getProperty("spring.datasource.password"));

		    return dataSource;
		} 

}