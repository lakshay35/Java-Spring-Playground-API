package com.example.springbootexample;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import com.example.springbootexample.model.FileStorageProperties;

@ServletComponentScan
@EnableScheduling
@EnableConfigurationProperties({
	FileStorageProperties.class
})
@SpringBootApplication
public class SpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}
	
	@Bean
	 public Filter shallowEtagHeaderFilter() {
	  return new ShallowEtagHeaderFilter();
	 }

}

