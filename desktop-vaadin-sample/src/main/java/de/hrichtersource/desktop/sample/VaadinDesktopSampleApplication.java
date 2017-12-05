package de.hrichtersource.desktop.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("de.hrichtersource.desktop.sample,de.hrichtersource.desktop.vaadin")
public class VaadinDesktopSampleApplication {

	public static void main(String[] args) {
	   new SpringApplicationBuilder(VaadinDesktopSampleApplication.class).headless(false).run(args);
//		SpringApplication.run(VaadinDesktopSampleApplication.class, args);
	}
}
