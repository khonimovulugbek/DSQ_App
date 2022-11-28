package uz.atm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

@Component
public class ComponentConfig {
    @Bean
    public RestTemplate restTemplate() {
        TrustManager[] trustManagers = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {

                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) {

                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }
        };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustManagers, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HostnameVerifier hv = (urlHostName, session) -> {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new RestTemplate();
    }

}
