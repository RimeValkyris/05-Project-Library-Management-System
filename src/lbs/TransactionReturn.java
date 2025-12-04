package lbs;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TransactionReturn extends Transaction {
    private LocalDate returnDate;
    private double lateFee;
    private String status;
    private String remarks;
    

    public TransactionReturn(String memberId, String itemId) {
        super(
            "return-" + System.currentTimeMillis(),
            memberId,
            itemId,
            LocalDate.now(), 
            null,
            "return"
        );
        this.returnDate = LocalDate.now();
        this.status = "PENDING";
        this.remarks = "";
        calculateLateFee();
    }
    
  
    public TransactionReturn(String transactionId, String memberId, String itemId, 
                           LocalDate transactionDate, LocalDate returnDate, 
                           double lateFee, String status, String remarks) {
        super(transactionId, memberId, itemId, transactionDate, null, "return");
        this.returnDate = returnDate;
        this.lateFee = lateFee;
        this.status = status;
        this.remarks = remarks;
    }
    
   
    public LocalDate getReturnDate() {
        return returnDate;
    }
    
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        calculateLateFee(); 
    }
    
    public double getLateFee() {
        return lateFee;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getRemarks() {
        return remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
 
    private void calculateLateFee() {
        if (returnDate == null) {
            this.lateFee = 0.0;
            return;
        }
        
      
        LocalDate originalDueDate = findOriginalDueDate();
        if (originalDueDate != null && returnDate.isAfter(originalDueDate)) {
            long daysLate = ChronoUnit.DAYS.between(originalDueDate, returnDate);
            this.lateFee = daysLate * 2.0; // $2 per day late fee
        } else {
            this.lateFee = 0.0;
        }
    }
   
    private LocalDate findOriginalDueDate() {

        return transactionDate.plusDays(14);
    }
    
    // Polymorphism: Override abstract method from parent class
    @Override
    public void processTransaction() {
        validateReturn();
        updateBookStatus();
        processLateFee();
        this.status = "COMPLETED";

    }
    

    private void validateReturn() {
        if (memberId == null || memberId.isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty");
        }
        if (itemId == null || itemId.isEmpty()) {
            throw new IllegalArgumentException("Item ID cannot be null or empty");
        }
    }
    
 
    private void updateBookStatus() {

    }
    
 
    private void processLateFee() {
        if (lateFee > 0) {
    
            this.remarks += "Late fee: $" + lateFee + ". ";
        }
    }
    
  
    public boolean isOverdue() {
        LocalDate originalDueDate = findOriginalDueDate();
        return originalDueDate != null && returnDate.isAfter(originalDueDate);
    }
    
   
    public String getFormattedStatus() {
        String statusText = status;
        if (isOverdue()) {
            statusText += " (OVERDUE)";
        }
        return statusText;
    }
    

    @Override
    public String toString() {
        return String.format("TransactionReturn{transactionId='%s', memberId='%s', itemId='%s', " +
                           "returnDate=%s, lateFee=%.2f, status='%s'}", 
                           transactionId, memberId, itemId, returnDate, lateFee, status);
    }
}