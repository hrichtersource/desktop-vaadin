package de.hoglicode.desktop.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("de.hoglicode.desktop.sample,de.hoglicode.desktop.vaadin")
public class VaadinDesktopSampleApplication {

	public static void main(String[] args) {
	   new SpringApplicationBuilder(VaadinDesktopSampleApplication.class).headless(false).run(args);
//		SpringApplication.run(VaadinDesktopSampleApplication.class, args);
	}
}
