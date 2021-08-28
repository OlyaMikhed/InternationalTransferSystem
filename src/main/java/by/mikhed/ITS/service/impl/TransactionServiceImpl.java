package by.mikhed.ITS.service.impl;

import by.mikhed.ITS.domain.Transaction;
import by.mikhed.ITS.dto.request.CreateTransactionRequest;
import by.mikhed.ITS.dto.request.UpdateTransactionRequest;
import by.mikhed.ITS.dto.response.TransactionResponse;
import by.mikhed.ITS.exception.IncorrectTransferStatusException;
import by.mikhed.ITS.exception.NotSenderOfTransferException;
import by.mikhed.ITS.mapper.TransactionDtoToEntityMapper;
import by.mikhed.ITS.repository.TransactionRepository;
import by.mikhed.ITS.security.UserPrincipal;
import by.mikhed.ITS.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final TransactionDtoToEntityMapper transactionDtoToEntityMapper;

    @Override
    public TransactionResponse create(UserPrincipal userPrincipal, CreateTransactionRequest createTransactionRequest) {
        Transaction newTransaction = transactionDtoToEntityMapper.transactionDtoToEntity(createTransactionRequest);
        Integer tNum;
        do {
            tNum = 1000000000 + (int) (Math.random() * 1000000000);
        } while (transactionRepository.findByTransferNumber(tNum).isPresent());
        newTransaction.setTransferNumber(tNum);
        newTransaction.setSenderId(userPrincipal.getId());
        newTransaction.setStatus("Ready to get");
        transactionRepository.save(newTransaction);
        return transactionDtoToEntityMapper.transactionEntityToDto(newTransaction);
    }

    @Override
    public TransactionResponse update(UserPrincipal userPrincipal, UpdateTransactionRequest
            updateTransactionRequest) {
        Transaction transaction = transactionRepository.findByTransferNumber(updateTransactionRequest
                .getTransferNumber()).orElseThrow(() -> new EntityNotFoundException("Transfer with number "
                + updateTransactionRequest.getTransferNumber() + " not found"));

        if (!userPrincipal.getId().equals(transaction.getSenderId())) {
            throw new NotSenderOfTransferException("You aren't the sender of this transfer");
        }
        if (transaction.getStatus().equals("Paid")) {
            throw new IncorrectTransferStatusException("This transfer has already been paid");
        }

        transaction.setNameRecipient(updateTransactionRequest.getNameRecipient());
        transaction.setSurnameRecipient(updateTransactionRequest.getSurnameRecipient());
        transactionRepository.save(transaction);
        return transactionDtoToEntityMapper.transactionEntityToDto(transaction);
    }
}
