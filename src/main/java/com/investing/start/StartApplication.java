package com.investing.start;

import com.investing.start.config.kpiConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {
	private kpiConfig kpis;

	public  StartApplication(kpiConfig kpis) {
		this.kpis = kpis;
	}
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}
	@Override
	public void run(String... args)  {
		System.out.printf("roi is %s and cash on cash is %s",
				kpis.getRoi(),
				kpis.getCashOnCash());
	}
}
