package by.mikhed.ITS.service;

import by.mikhed.ITS.dto.request.CreateCountryRequest;
import by.mikhed.ITS.exception.CountryAlreadyExistException;
import by.mikhed.ITS.security.UserPrincipal;

public interface CountryService {

    void deleteById(String id);

    void create(CreateCountryRequest createCountryRequest) throws CountryAlreadyExistException;
}
