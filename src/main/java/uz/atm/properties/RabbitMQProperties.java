package uz.atm.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author : Khonimov Ulugbek
 * Date : 21.11.2022
 * Time : 6:09 PM
 */
@ConfigurationProperties("rabbit")
@Getter
@Setter
public class RabbitMQProperties {

    private Exchanges exchanges;

    @Data
    public static class Exchanges {

        private String fanoutExchange;
    }

}




