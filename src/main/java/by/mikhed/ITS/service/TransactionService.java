package by.mikhed.ITS.service;

import by.mikhed.ITS.dto.request.CreateTransactionRequest;
import by.mikhed.ITS.dto.request.FindTransactionRequest;
import by.mikhed.ITS.dto.request.UpdateTransactionRequest;
import by.mikhed.ITS.dto.response.TransactionResponse;
import by.mikhed.ITS.exception.IncorrectTransferStatusException;
import by.mikhed.ITS.exception.NotSenderOfTransferException;
import by.mikhed.ITS.security.UserPrincipal;

public interface TransactionService {

    TransactionResponse create(UserPrincipal userPrincipal, CreateTransactionRequest createTransactionRequest);

    TransactionResponse update(UserPrincipal userPrincipal, UpdateTransactionRequest updateTransactionRequest);

    void receipt(UserPrincipal userPrincipal, FindTransactionRequest findTransactionRequest);

}
