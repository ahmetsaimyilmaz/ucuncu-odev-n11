package n11.ucuncuodevn11.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseFromWeatherAPI {
        private int queryCost;
        private double latitude;
        private double longitude;
        private String resolvedAddress;
        private String address;
        private String timezone;
        private double tzoffset;
        private String description;
        private List<Day> days;
        private List<Object> alerts;


}
