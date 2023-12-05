package Pracownia.Projekt.Spring;

import Pracownia.Projekt.Spring.Config.Generator.DataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class SpringApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

    @Component
    public class DataLoader implements CommandLineRunner {

        private final DataGenerator dataGenerator;

        @Autowired
        public DataLoader(DataGenerator dataGenerator) {
            this.dataGenerator = dataGenerator;
        }

        @Override
        public void run(String... args) {
            dataGenerator.generateData();
        }
    }

}


