package uz.atm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.atm.properties.*;

@SpringBootApplication
@OpenAPIDefinition
@EnableRabbit
@EnableConfigurationProperties(value = {
        OpenApiProperties.class,
        DSQApiProperties.class,
        ServerProperties.class,
        JwtProperties.class,
        RabbitMQProperties.class})
@RequiredArgsConstructor
public class DsqAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsqAppApplication.class, args);
    }

}
