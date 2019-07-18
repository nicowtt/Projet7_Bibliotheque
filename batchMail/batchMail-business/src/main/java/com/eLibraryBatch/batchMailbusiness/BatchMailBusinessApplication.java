package com.eLibraryBatch.batchMailbusiness;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients("com.eLibraryBatch")
@ComponentScan(basePackages = {"com.eLibraryBatch"})
public class BatchMailBusinessApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BatchMailBusinessApplication.class, args);}
	}
