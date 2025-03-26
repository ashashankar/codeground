import java.util.Arrays;

class CoundDaysLC3169 {
    public static void main(String[] args) {
        int days = 50;
        int[][] meetings = {{22,31},{7,42},{30,46},{9,33},{9,18},{23,39},{4,8},{18,19}};
        int answer = new CoundDaysLC3169().countDays(days, meetings);
        System.out.println(answer);
    }
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b)-> a[0] - b[0]);
        int result = 0;
        int start_time = meetings[0][0];
        int end_time =  meetings[0][1];
        for (int i=1; i<meetings.length; i++) {
            int[] times = meetings[i];
            if (times[0] >= end_time) {
                int diff = times[0] - end_time -1;
                if (diff > 0) result += diff;
            }
            start_time = Math.min(start_time, times[0]);
            end_time = Math.max(end_time, times[1]);
        }
        if (start_time > 1) {
            result += start_time - 1;
        }
        if (days> end_time) {
            result += days - end_time;
        }
        return result;
    }
}