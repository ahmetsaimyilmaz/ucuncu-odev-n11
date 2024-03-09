package n11.ucuncuodevn11.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateWeather {

        @Bean("weatherRestTemplate")
        public RestTemplate createRestTemplate() {
            return new RestTemplate();
        }



}
