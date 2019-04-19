package steklopod;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
@EntityScan(basePackages = "steklopod.model")
@EnableJpaRepositories(basePackages = "steklopod.repositories")
public class Application {

    public static void main(String[] args) {
        log.info("Зайди на: http://192.168.99.100:8080 если запуск производиться из DOCKER");
        log.info("или   на: http://localhost:8080      если запускаешь локально");
        SpringApplication.run(Application.class, args);
    }

}
