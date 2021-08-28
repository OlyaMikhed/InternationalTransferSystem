package by.mikhed.ITS.controller;

import by.mikhed.ITS.dto.request.CreateTransactionRequest;
import by.mikhed.ITS.dto.request.FindTransactionRequest;
import by.mikhed.ITS.dto.request.UpdateTransactionRequest;
import by.mikhed.ITS.dto.response.MessageResponse;
import by.mikhed.ITS.dto.response.TransactionResponse;
import by.mikhed.ITS.exception.CountryAlreadyExistException;
import by.mikhed.ITS.exception.IncorrectTransferStatusException;
import by.mikhed.ITS.exception.NotSenderOfTransferException;
import by.mikhed.ITS.security.UserPrincipal;
import by.mikhed.ITS.service.TransactionService;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/transaction")
public class TransactionUserController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponse> add(@AuthenticationPrincipal UserPrincipal user,
                                                   @RequestBody CreateTransactionRequest createTransactionRequest) {
        TransactionResponse transactionResponse = transactionService.create(user, createTransactionRequest);
        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TransactionResponse> update(@AuthenticationPrincipal UserPrincipal user,
                                                      @RequestBody UpdateTransactionRequest updateTransactionRequest) {
        return new ResponseEntity<>(transactionService.update(user, updateTransactionRequest), HttpStatus.OK);
    }

    @PutMapping("/pay")
    public ResponseEntity<MessageResponse> receipt(@AuthenticationPrincipal UserPrincipal user,
                                                   @RequestBody FindTransactionRequest findTransactionRequest) {
        transactionService.receipt(user, findTransactionRequest);
        return new ResponseEntity<>(new MessageResponse("Paid successfully"), HttpStatus.OK);
    }
}