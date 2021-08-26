package by.mikhed.ITS.service.impl;


import by.mikhed.ITS.domain.Country;
import by.mikhed.ITS.dto.request.CreateCountryRequest;
import by.mikhed.ITS.exception.CountryAlreadyExistException;
import by.mikhed.ITS.mapper.CountryDtoToEntityMapper;
import by.mikhed.ITS.repository.CountryRepository;
import by.mikhed.ITS.security.UserPrincipal;
import by.mikhed.ITS.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryDtoToEntityMapper countryDtoToEntityMapper;

    @Override
    public void deleteById(String id) throws EntityNotFoundException{
        if (countryRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Country with id " + id + " not found");
        }
        countryRepository.deleteById(id);
    }

    @Override
    public void create(CreateCountryRequest createCountryRequest) throws CountryAlreadyExistException {
        Country newCountry = countryDtoToEntityMapper.countryDtoToEntity(createCountryRequest);
        if (countryRepository.findById(createCountryRequest.getId()).isPresent()) {
            throw new CountryAlreadyExistException("This country was added earlier");
        }
        //newCountry.setId(createCountryRequest.getId());
        //newCountry.setCountryName(createCountryRequest.getCountryName());
        countryRepository.save(newCountry);
    }
}
