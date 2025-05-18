package codeground.src.main.java.com.myplayground.playground;

import java.util.Arrays;

public class MinimumArrowsToBurstBalloonsLC452 {
    public static void main(String[] args) {
        int[][] ballons = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(new MinimumArrowsToBurstBalloonsLC452().findMinArrowShots(ballons));
    }

    public int findMinArrowShots(int[][] points) {
        int countMerge = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev = points[0];
        for (int i=1; i<points.length; i++) {
            if (points[i][0] <= prev[1]) {
                countMerge -= 1;
                prev[1] = Math.min(prev[1], points[i][1]);
            } else {

                prev = points[i];
            }
        }
        return countMerge;
    }
}
