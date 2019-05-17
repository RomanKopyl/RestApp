package newProject.dto;

import newProject.domain.TransactionState;

import java.math.BigDecimal;
import java.util.Date;

public class ResponseTransactionDto {

    private Integer id;
    private Date date;
    private BigDecimal amount;
    private TransactionState transactionState;

    public ResponseTransactionDto(Integer id, Date date, BigDecimal amount, TransactionState transactionState) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.transactionState = transactionState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionState getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(TransactionState transactionState) {
        this.transactionState = transactionState;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
