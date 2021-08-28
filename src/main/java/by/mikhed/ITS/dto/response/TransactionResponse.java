package by.mikhed.ITS.dto.response;

import lombok.Data;

import java.math.BigDecimal;

//@Data
public class TransactionResponse {

    private BigDecimal sum;

    private String currency;

    private String nameRecipient;

    private String surnameRecipient;

    private Integer transferNumber;

    private String status;

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNameRecipient() {
        return nameRecipient;
    }

    public void setNameRecipient(String nameRecipient) {
        this.nameRecipient = nameRecipient;
    }

    public String getSurnameRecipient() {
        return surnameRecipient;
    }

    public void setSurnameRecipient(String surnameRecipient) {
        this.surnameRecipient = surnameRecipient;
    }

    public Integer getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(Integer transferNumber) {
        this.transferNumber = transferNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
