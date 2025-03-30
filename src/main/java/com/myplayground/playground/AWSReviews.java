import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AWSReviews {
    public static void main(String[] args) {
        List<Integer> reviews = new ArrayList<>();
        reviews.add(1);
        reviews.add(3);
        reviews.add(1);
        reviews.add(7);

        List<Integer> count = new ArrayList<>();
        count.add(1);
        count.add(2);
        count.add(5);
        count.add(11);
        System.out.println(new AWSReviews().findTotalModifications(reviews, count));
    }

    public long findTotalModifications(List<Integer> reviews, List<Integer> count) {
        Collections.sort(reviews);

        int[] result = new int[count.size()];

        // Process each count
        for (int i = 0; i < count.size(); i++) {
            int modifications = 0;
            int target = count.get(i);

            // Binary search to find the number of elements <= count[i]
            int idx = binarySearch(reviews.stream().mapToInt(Integer::intValue).toArray(), target);

            // Additions: Count how many reviews are less than count[i]
            for (int j = 0; j < idx; j++) {
                modifications += Math.abs(count.get(j) - target);  // Add the difference
            }

            // Removals: Count how many reviews are greater than count[i]
            for (int j = idx; j < reviews.size(); j++) {
                modifications += reviews.get(j) - target;  // Remove the difference
            }

            result[i] = modifications;
        }
        //System.out.println(Arrays.toString(result));
        long total = Arrays.stream(result).sum();
        return total;
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
