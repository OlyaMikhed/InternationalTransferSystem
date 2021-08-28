package by.mikhed.ITS.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//@Data
@NoArgsConstructor
public class CreateTransactionRequest {

    private BigDecimal sum;

    private String currency;

    protected String nameRecipient;

    protected String surnameRecipient;

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
}
