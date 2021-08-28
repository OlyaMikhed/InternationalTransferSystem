package by.mikhed.ITS.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal sum;

    @Column(nullable = false)
    private String currency;

    @Column(name = "name_recipient", nullable = false)
    private String nameRecipient;

    @Column(name = "surname_recipient", nullable = false)
    private String surnameRecipient;

    @Column(name = "transfer_number", nullable = false, unique = true)
    private Integer transferNumber;

    @Column(nullable = false)
    private String status;

    @Column(name = "sender_id", nullable = false)
    private Integer senderId;

    @Column(name = "recipient_id")
    private Integer recipientId;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false, insertable = false,
            updatable = false)
    private User userSender;

    @ManyToOne
    @JoinColumn(name = "recipient_id", insertable = false, updatable = false)
    private User userRecipient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }
}
