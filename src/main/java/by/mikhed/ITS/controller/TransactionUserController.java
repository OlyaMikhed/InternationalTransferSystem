package by.mikhed.ITS.controller;

import by.mikhed.ITS.dto.request.CreateTransactionRequest;
import by.mikhed.ITS.dto.response.MessageResponse;
import by.mikhed.ITS.dto.response.TransactionResponse;
import by.mikhed.ITS.security.UserPrincipal;
import by.mikhed.ITS.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
