package newProject.dto;

import newProject.domain.TransactionState;

public class RequestTransactionStateDto {

    private TransactionState transactionState;

    public TransactionState getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(TransactionState transactionState) {
        this.transactionState = transactionState;
    }
}
