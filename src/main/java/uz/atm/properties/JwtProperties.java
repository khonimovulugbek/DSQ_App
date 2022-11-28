package uz.atm.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 02/10/22
 * Time: 13:58
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "jwt.prop")
public class JwtProperties {

    private Long expire;

    private String secret;

}
