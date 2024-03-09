package n11.ucuncuodevn11.controller;

import lombok.RequiredArgsConstructor;
import n11.ucuncuodevn11.entity.ResponseFromWeatherAPI;
import n11.ucuncuodevn11.utils.VisualCrossingConnection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/visualcrossing/")
@RequiredArgsConstructor
public class WeatherApiController {

    private final VisualCrossingConnection visualCrossingConnection;

    @GetMapping("{city}/{countryCode}/{startDate}/{endDate}")
    public ResponseEntity<ResponseFromWeatherAPI> getWeatherApi(@PathVariable String city,
                                                                @PathVariable String countryCode,
                                                                @PathVariable String startDate,
                                                                @PathVariable String endDate) {

        return ResponseEntity.ok(visualCrossingConnection.getWeatherApiForecast(city,countryCode,startDate,endDate));
    }
}
