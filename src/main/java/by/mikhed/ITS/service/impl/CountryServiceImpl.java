package by.mikhed.ITS.service.impl;


import by.mikhed.ITS.domain.Country;
import by.mikhed.ITS.dto.request.CreateCountryRequest;
import by.mikhed.ITS.mapper.CountryDtoToEntityMapper;
import by.mikhed.ITS.repository.CountryRepository;
import by.mikhed.ITS.security.UserPrincipal;
import by.mikhed.ITS.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryDtoToEntityMapper countryDtoToEntityMapper;

    @Override
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }

    @Override
    public void create(UserPrincipal userPrincipal, CreateCountryRequest createCountryRequest) {
        Country newCountry = countryDtoToEntityMapper.countryDtoToEntity(createCountryRequest);
        countryRepository.save(newCountry);
    }
}
