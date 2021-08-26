package by.mikhed.ITS.mapper;

import by.mikhed.ITS.domain.Transaction;
import by.mikhed.ITS.dto.request.CreateTransactionRequest;
import by.mikhed.ITS.dto.response.TransactionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionDtoToEntityMapper {

    Transaction transactionDtoToEntity(CreateTransactionRequest createTransactionRequest);

    TransactionResponse transactionEntityToDto(Transaction transaction);
}
