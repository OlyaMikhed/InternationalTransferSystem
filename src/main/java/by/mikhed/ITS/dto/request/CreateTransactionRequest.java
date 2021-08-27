package by.mikhed.ITS.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CreateTransactionRequest {

    private BigDecimal sum;

    private String currency;

    protected String nameRecipient;

    protected String surnameRecipient;
}
