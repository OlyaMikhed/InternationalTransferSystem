package by.mikhed.ITS.service.impl;

import by.mikhed.ITS.domain.Transaction;
import by.mikhed.ITS.domain.User;
import by.mikhed.ITS.dto.request.CreateTransactionRequest;
import by.mikhed.ITS.dto.request.FindTransactionRequest;
import by.mikhed.ITS.dto.request.UpdateTransactionRequest;
import by.mikhed.ITS.dto.response.TransactionResponse;
import by.mikhed.ITS.exception.IncorrectTransferStatusException;
import by.mikhed.ITS.exception.NotSenderOfTransferException;
import by.mikhed.ITS.exception.WrongNameException;
import by.mikhed.ITS.mapper.TransactionDtoToEntityMapper;
import by.mikhed.ITS.repository.TransactionRepository;
import by.mikhed.ITS.repository.UserRepository;
import by.mikhed.ITS.security.UserPrincipal;
import by.mikhed.ITS.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final UserRepository userRepository;

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

    @Override
    public void receipt(UserPrincipal userPrincipal, FindTransactionRequest findTransactionRequest) {
        Transaction transaction = transactionRepository.findByTransferNumber(findTransactionRequest
                .getTransferNumber()).orElseThrow(() -> new EntityNotFoundException("Transfer with number "
                + findTransactionRequest.getTransferNumber() + " not found"));

        Optional<User> user = userRepository.findById(userPrincipal.getId());

        if ((!transaction.getNameRecipient().equals(user.get().getNameUser())) ||
                !transaction.getSurnameRecipient().equals(user.get().getSurnameUser())) {
            throw new WrongNameException("You aren't the recipient of this transfer");
        }
        if (transaction.getStatus().equals("Paid")) {
            throw new IncorrectTransferStatusException("This transfer has already been paid");
        }
        transaction.setRecipientId(userPrincipal.getId());
        transaction.setStatus("Paid");
        transactionRepository.save(transaction);
    }
}
