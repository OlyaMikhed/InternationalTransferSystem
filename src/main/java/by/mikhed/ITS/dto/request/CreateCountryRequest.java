package by.mikhed.ITS.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCountryRequest {

    private String id;
    private String countryName;

}
