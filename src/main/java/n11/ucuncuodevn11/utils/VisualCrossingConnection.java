package n11.ucuncuodevn11.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import n11.ucuncuodevn11.entity.ResponseFromWeatherAPI;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class VisualCrossingConnection {


        private final RestTemplate restTemplate;
        private String baseUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
        private String apiKey= "Z6RK8GR9AH26A7NKNPB7TMTUY";

        public ResponseFromWeatherAPI getWeatherApiForecast(String city, String countryCode, String startDate, String endDate) {
            String requestUrl = new StringBuilder()
                    .append(baseUrl)
                    .append(city)
                    .append(",")
                    .append(countryCode)
                    .append("/")
                    .append(startDate)
                    .append("/")
                    .append(endDate)
                    .append("?key=")
                    .append(apiKey)
                    .toString();

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<?> request = new HttpEntity<>(httpHeaders);

            try {
                ResponseEntity<ResponseFromWeatherAPI> response = restTemplate
                        .exchange(requestUrl, HttpMethod.GET, request, ResponseFromWeatherAPI.class);
                return response.getBody();
            } catch (Exception e) {
                log.error(e.getMessage());
                return null;
            }

        }


}
