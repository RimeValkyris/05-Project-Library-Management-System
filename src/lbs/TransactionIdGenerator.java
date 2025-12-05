package lbs;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Simple in-memory transaction ID generator that returns IDs like TRN001, TRN002, ...
 * Not persisted across restarts; suitable for demo and in-memory runs.
 */
public class TransactionIdGenerator {
    private static final AtomicInteger counter = new AtomicInteger(0);

    // Generate next ID: TRN + zero-padded 3-digit number
    public static synchronized String nextId() {
        int next = counter.incrementAndGet();
        return String.format("TRN%03d", next);
    }

    // Reset (for tests/demos)
    public static synchronized void reset() {
        counter.set(0);
    }

    // Optionally set counter to a specific value (e.g., to continue after existing data)
    public static synchronized void setCounter(int value) {
        counter.set(value);
    }

    // Read current value
    public static int getCurrent() {
        return counter.get();
    }
}
