package lbs;

import java.util.concurrent.atomic.AtomicInteger;

public class TransactionIdGenerator {
    private static final AtomicInteger counter = new AtomicInteger(0);

    
    public static synchronized String nextId() {
        int next = counter.incrementAndGet();
        return String.format("TRN%03d", next);
    }

 
    public static synchronized void reset() {
        counter.set(0);
    }

    
    public static synchronized void setCounter(int value) {
        counter.set(value);
    }

  
    public static int getCurrent() {
        return counter.get();
    }
}
