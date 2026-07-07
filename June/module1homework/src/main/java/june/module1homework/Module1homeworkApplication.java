package june.module1homework;

import june.module1homework.classes.CakeBaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Module1homeworkApplication {

	public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Module1homeworkApplication.class, args);
        CakeBaker cakeBaker = context.getBean(CakeBaker.class);
        cakeBaker.bakeCake();
	}

}
