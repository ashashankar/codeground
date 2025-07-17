package com.myplayground.playground;

import com.myplayground.temp.ProcessAndDeduplicate1;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessAndDeduplicate {
    public List<Map<String, String>> processRows(List<Map<String, String>> rows, String lastSyncedAt) {
        Instant lastUpdatedtimestamp = Instant.parse(lastSyncedAt);
        Map<String, Map<String, String>> uniqueMap = new HashMap<>();
        for (Map<String, String> row : rows) {
            String id = row.get("id");
            Instant last_updated = Instant.parse(row.get("lastSyncedat"));
            if (last_updated.isBefore(lastUpdatedtimestamp))
                continue;
            Map<String, String> existingRow = uniqueMap.get(id);
            if (existingRow == null || Instant.parse(existingRow.get("lastSyncedat")).isBefore(last_updated)) {
                uniqueMap.put(id, row);
            }
        }
        return new ArrayList<>(uniqueMap.values());
    }

    public static void main(String[] args) {
        List<Map<String, String>> rows = List.of(
                Map.of("id", "101", "name" , "alicd", "lastSyncedat", "2025-07-02T10:00:00Z"),
                Map.of("id", "101", "name" , "alid", "lastSyncedat", "2025-07-02T11:00:00Z"),
                Map.of("id", "102", "name" , "alcd", "lastSyncedat", "2025-07-02T12:00:00Z"),
                Map.of("id", "104", "name" , "alcd", "lastSyncedat", "2025-06-16T12:00:00Z"),
                Map.of("id", "103", "name" , "aliceed", "lastSyncedat", "2024-07-02T10:00:00Z"),
                Map.of("id", "105", "name" , "alidddcd", "lastSyncedat", "2025-07-02T10:00:00Z"));
        String lastSyncedAt = "2025-06-30T12:00:00Z";
        List<Map<String, String>> result = new ProcessAndDeduplicate().processRows(rows, lastSyncedAt);
        System.out.println(result);

    }

}
