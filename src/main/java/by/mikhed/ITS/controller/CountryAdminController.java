package by.mikhed.ITS.controller;

import by.mikhed.ITS.dto.request.CreateCountryRequest;
import by.mikhed.ITS.dto.response.MessageResponse;
import by.mikhed.ITS.exception.CountryAlreadyExistException;
import by.mikhed.ITS.security.UserPrincipal;
import by.mikhed.ITS.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/country")
public class CountryAdminController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<MessageResponse> add(@RequestBody CreateCountryRequest createCountryRequest) {
        try {
            countryService.create(createCountryRequest);
            return new ResponseEntity<>(new MessageResponse("Created successfully"), HttpStatus.CREATED);
        } catch (CountryAlreadyExistException e) {
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@AuthenticationPrincipal UserPrincipal user,
                                                      @PathVariable String id) {
        try {
            countryService.deleteById(id);
            return new ResponseEntity<>(new MessageResponse("Deleted successfully"), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}