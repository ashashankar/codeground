package com.myplayground.playground;
import java.sql.*;
import java.time.Instant;
import java.util.*;
public class SQLConnecctor {
    Connection connection;
    Map<String, String> state; //hold the latest timestamp
    SQLConnecctor(Connection connection, Map<String, String> state) {
        this.connection = connection;
        this.state = state;
    }

    public List<Map<String, Object>> extract() throws SQLException {
        String lastUpdated = state.getOrDefault("lastUpdated", Instant.now().toString());

        String sql = "select username, email, lastUpdated from users order by lastupdated asc" +
                "limit 1000";
        List<Map<String, Object>> results = new ArrayList<>();
        String latestTimeStamp = lastUpdated;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setTimestamp(1, Timestamp.from(Instant.parse(lastUpdated)));

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("username", rs.getString("username"));
                row.put("email", rs.getString("email"));
                Timestamp t = rs.getTimestamp("lastupdated");
                if (t != null) {
                    String time_stamp = t.toInstant().toString();
                    row.put("lastUpdated", time_stamp);
                    if (time_stamp.compareTo(latestTimeStamp) > 0) {
                        latestTimeStamp = time_stamp;
                    }
                }
                results.add(row);
            }
        }
        state.put("lastUpdated", latestTimeStamp);
        return results;
    }
}
