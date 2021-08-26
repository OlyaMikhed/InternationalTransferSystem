package by.mikhed.ITS.mapper;

import by.mikhed.ITS.domain.Country;
import by.mikhed.ITS.dto.request.CreateCountryRequest;
import by.mikhed.ITS.dto.response.CountryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryDtoToEntityMapper {

    Country countryDtoToEntity(CreateCountryRequest createCountryRequest);

    CountryResponse countryEntityToDto(Country country);

}
