package com.myplayground.temp;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RetryQueueManager {
    static final int MAX_RETRIES = 3;
    static final int THREAD_POOL_SIZE = 4;

    static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
    static Map<String, RetryRecord> retryState = new ConcurrentHashMap<>();
    static Map<String, RetryRecord> dlq = new ConcurrentHashMap<>();
    private static void scheduleRetry(RetryRecord retryRecord, int delaySeconds) {
        executorService.schedule(()-> process(retryRecord), delaySeconds, TimeUnit.SECONDS);
    }

    private static boolean simulateProcessing(RetryRecord record) {
        if (!record.isRetryable) return false;
        return Math.random() > 0.5;
    }

    private static void process(RetryRecord record) {
        record.lastAttempt = Instant.now();

        boolean success = simulateProcessing(record);

        if (success) {
            System.out.println("processsed");
            if (retryState.containsKey(record.id)) retryState.remove(record.id);
        }else {
            if (!record.isRetryable) {
                dlq.put(record.id, record);
                return;
            }
            record.retryCount++;
            if (record.retryCount> MAX_RETRIES) {
                System.out.println("max exceeded");
                dlq.put(record.id, record);
            } else {
                System.out.println("Retrying");
                retryState.put(record.id, record);
                int delay = (int)Math.pow(2, record.retryCount);
                scheduleRetry(record, delay);
            }
        }
    }



    public static void main(String[] args) {
        List<RetryRecord> records = List.of(new RetryRecord("r1", "data_1", true),
                new RetryRecord("r2", "data_2", true),
                new RetryRecord("r3", "data_3", false));

        for (RetryRecord r : records) {
            scheduleRetry(r, 0);
        }

        executorService.schedule(() -> {
                executorService.shutdown() ;
            }, 30, TimeUnit.SECONDS);
    }

    static class RetryRecord {
        int retryCount;
        String payload;
        String id;
        Instant lastAttempt;
        boolean isRetryable;
        RetryRecord(String id, String payload, boolean isRetryable) {
            this.id = id;
            this.payload = payload;
            this.isRetryable = isRetryable;
        }
    }
}
