package uz.atm.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;
import uz.atm.properties.JwtProperties;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtils {

    private final JwtProperties jwtProperties;

    public JwtUtils(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public Date getExpireDate() {
        return new Date(jwtProperties.getExpire() + System.currentTimeMillis());
    }

    public Algorithm getAlgorithm() {
        return Algorithm.HMAC256(jwtProperties.getSecret().getBytes(StandardCharsets.UTF_8));
    }

    public JWTVerifier verifier() {
        return JWT.require(getAlgorithm()).build();
    }
}
