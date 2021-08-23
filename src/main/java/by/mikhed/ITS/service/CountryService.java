package by.mikhed.ITS.service;

import by.mikhed.ITS.dto.request.CreateCountryRequest;
import by.mikhed.ITS.security.UserPrincipal;

public interface CountryService {

    void deleteById(Integer id);

    void create(UserPrincipal userPrincipal, CreateCountryRequest createCountryRequest);
}
