package lbs;

import java.time.LocalDate;


public abstract class Transaction {
    protected String transactionId;
    protected String memberId;
    protected String itemId;
    protected LocalDate transactionDate;
    protected LocalDate dueDate;
    protected String type;

    public Transaction(String transactionId, String memberId, String itemId, LocalDate transactionDate, LocalDate dueDate, String type) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.itemId = itemId;
        this.transactionDate = transactionDate;
        this.dueDate = dueDate;
        this.type = type;
    }

    public String getTransactionId() { 
    	return transactionId; 
    }
    
    public String getMemberId() { 
    	return memberId; 
    	}
    
    public String getItemId() { 
    	return itemId; 
    	}
    
    public LocalDate getTransactionDate() { 
    	return transactionDate; 
    	}
    
    public LocalDate getDueDate() { 
    	return dueDate; 
    	}
    
    public String getType() { 
    	return type; 
    	}

    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

   
    public abstract void processTransaction();
}
