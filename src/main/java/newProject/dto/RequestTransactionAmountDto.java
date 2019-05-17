package newProject.dto;

import java.math.BigDecimal;

public class RequestTransactionAmountDto {

    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
