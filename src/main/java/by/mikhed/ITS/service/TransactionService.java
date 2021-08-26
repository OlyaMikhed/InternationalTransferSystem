package by.mikhed.ITS.service;

import by.mikhed.ITS.dto.request.CreateTransactionRequest;
import by.mikhed.ITS.dto.response.TransactionResponse;
import by.mikhed.ITS.security.UserPrincipal;

public interface TransactionService {

    TransactionResponse create(UserPrincipal userPrincipal, CreateTransactionRequest createTransactionRequest);

}
