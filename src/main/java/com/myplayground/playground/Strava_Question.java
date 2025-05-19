package codeground.src.main.java.com.myplayground.playground;

import java.util.List;

/**
 * At Strava, a large part of what we do is taking raw athlete data and transforming it into useful insights. This problem is a small example of the type of problem you might see working here. Athletes upload GPS data files in various formats. These files are parsed and transformed into various data streams, representing specific quantities sampled at regular time intervals. This question deals with one such data stream, elevation.
 *
 *
 *
 * Problem Statement
 * Given an array of integers representing regularly sampled elevations (e.g. every second), detect the first climb in the elevation data. A climb is a portion of an activity that starts at one elevation, ends at a higher elevation, and doesn't descend in between.  A climb starts as soon as the elevation starts increasing, and ends at the highest elevation seen during the climb.
 *
 *
 *
 * Input format:
 * An array of integers of any length. Example:
 *
 * [3, 2, 1, 0, 0, 1, 2, 2, 3, 5, 10, 10, 7, 15]
 *
 *
 *
 * Output format:
 * An array containing the indices of the start and end locations of the first climb. For the example above, this is:
 *
 * [4, 10]
 *
 *
 *
 * If no climb is detected, return an empty array:
 *
 * []
 */
public class Strava_Question {
    public static void main(String[] args) {
        List<Integer> elevations = List.of(3, 2, 1, 0, 0, 1, 2, 2, 3, 5, 10, 10, 7, 15);
        System.out.println(find_first_climb(elevations));
    }

    public static List<Integer> find_first_climb(List<Integer> elevations) {
        int n = elevations.size();
        for (int i = 0; i < n - 1; i++) {
            // Look for start of a climb
            if (elevations.get(i) < elevations.get(i + 1)) {
                int start = i;
                int end = i + 1;

                // Continue climbing or staying at the same height
                while (end + 1 < n && elevations.get(end) <= elevations.get(end + 1)) {
                    end++;
                }

                return List.of(start, end);
            }
        }
        return List.of(); // No climb found
    }
}
