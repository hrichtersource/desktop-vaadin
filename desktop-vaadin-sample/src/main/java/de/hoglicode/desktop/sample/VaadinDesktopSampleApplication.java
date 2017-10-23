package de.hoglicode.desktop.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class VaadinDesktopSampleApplication {

	public static void main(String[] args) {
	   new SpringApplicationBuilder(VaadinDesktopSampleApplication.class).headless(false).run(args);
//		SpringApplication.run(VaadinDesktopSampleApplication.class, args);
	}
}
