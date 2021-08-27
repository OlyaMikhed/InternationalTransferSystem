package by.mikhed.ITS.service;

import by.mikhed.ITS.dto.request.CreateTransactionRequest;
import by.mikhed.ITS.dto.request.UpdateTransactionRequest;
import by.mikhed.ITS.dto.response.TransactionResponse;
import by.mikhed.ITS.exception.IncorrectTransferStatusException;
import by.mikhed.ITS.exception.NotSenderOfTransferException;
import by.mikhed.ITS.security.UserPrincipal;

public interface TransactionService {

    TransactionResponse create(UserPrincipal userPrincipal, CreateTransactionRequest createTransactionRequest);

    void update(UserPrincipal userPrincipal, UpdateTransactionRequest updateTransactionRequest)
            throws NotSenderOfTransferException, IncorrectTransferStatusException;

}
