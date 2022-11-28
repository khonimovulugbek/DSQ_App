package uz.atm.utils;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import uz.atm.exceptions.InvalidTokenException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 10/25/22 4:46 PM
 **/
@Slf4j
public class AppUtils {

    public static Integer randomInteger() {
        try {
            Random random = SecureRandom.getInstanceStrong();  // SecureRandom is preferred to Random
            return random.nextInt(99999);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("Exception occured at sleeping sleep : {}", e.getMessage());
        }
    }

    public static boolean isJWT(String jwt) {
        String[] jwtSplitted = jwt.split("\\.");
        if (jwtSplitted.length != 3) // The JWT is composed of three parts
            return false;
        try {
            byte[] decodedStr = Base64.getDecoder().decode(jwtSplitted[0]);
            String jsonFirstPart = new String(decodedStr);
            JSONObject firstPart = new JSONObject(jsonFirstPart); // The first part of the JWT is a JSON
            if (!firstPart.has("alg")) // The first part has the attribute "alg"
                return false;
        } catch (JSONException | IllegalArgumentException err) {
            throw new InvalidTokenException(err.getMessage());
        }
        return true;
    }
}
