package by.mikhed.ITS.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionResponse {

    private BigDecimal sum;

    private String currency;

    private String nameRecipient;

    private String surnameRecipient;

    private Integer transferNumber;

    private String status;

    //private Integer senderId;
    //private Integer recipientId;
}
