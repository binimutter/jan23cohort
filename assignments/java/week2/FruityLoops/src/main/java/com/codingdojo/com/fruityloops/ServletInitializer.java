package assignments.java.week2.FruityLoops.src.main.java.com.codingdojo.com.fruityloops;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FruityLoopsApplication.class);
	}

}
