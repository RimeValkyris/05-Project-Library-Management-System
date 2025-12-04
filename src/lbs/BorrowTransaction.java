package lbs;

import java.time.LocalDate;


public class BorrowTransaction extends Transaction {
    private int borrowDays;

    public BorrowTransaction(String memberId, String itemId, int borrowDays) {
        super(
            "borrow-" + System.currentTimeMillis(),
            memberId,
            itemId,
            LocalDate.now(),
            LocalDate.now().plusDays(borrowDays),
            "borrow"
        );
        this.borrowDays = borrowDays;
    }

    public int getBorrowDays() {
        return borrowDays;
    }

    @Override
    public void processTransaction() {
        System.out.println("Borrow transaction processed for member: " + this.memberId);
    }
}
