package net.javaci.thymleafExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcThymleafExampleApplication {

	public static void main(String[] args) {
		
		try {
			SpringApplication.run(SpringMvcThymleafExampleApplication.class, args);
		} catch (Throwable e) {
			if (e.getClass().getName().contains("SilentExitException")) {
				// skipping for spring known bug
				// https://github.com/spring-projects/spring-boot/issues/3100
				//log.debug("Spring is restarting the main thread - See spring-boot-devtools");
				//System.out.println("Spring is restarting the main thread - See spring-boot-devtools");
			} else {
				throw e;
			}
		}

	}

}
