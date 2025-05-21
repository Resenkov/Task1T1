package resenkov.work.task1t1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import resenkov.work.task1t1.generate.TestGenerate;

@SpringBootApplication
public class Task1T1Application {

    public static void main(String[] args) {
        SpringApplication.run(Task1T1Application.class, args);
    }
    @Bean
    public CommandLineRunner dataLoader(TestGenerate generator) {
        return args -> generator.run();
    }
}
