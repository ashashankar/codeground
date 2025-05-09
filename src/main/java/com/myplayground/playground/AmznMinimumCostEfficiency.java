import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AmznMinimumCostEfficiency {
    public static void main(String[] args) {
        List<Integer> efficiency = Arrays.asList(75, 104, 72, 72, 310, 125);
        List<Integer> costs = Arrays.asList(1, 2, 2, 1, 2, 1);
        long k = 376;
        Collections.sort(efficiency);
        System.out.println(efficiency);
        System.out.println(findMinimumCost(efficiency, costs, k));
    }

    public static int findMinimumCost(List<Integer> efficiency, List<Integer> costs, long k) {
        int i = 0;
        int j= 0;
        int len = efficiency.size();
        int totalCost = Integer.MAX_VALUE;
        int cost  = 0;
        int eff = 0;
        List<int[]> workers = new ArrayList<>();
        for (int idx = 0; idx < len; idx++) {
            workers.add(new int[]{efficiency.get(idx), costs.get(idx)});
        }

        // Sort workers by efficiency in descending order (higher efficiency first)
        workers.sort((a, b) -> Integer.compare(b[0], a[0]));

        while (j < len) {
            if (eff >= k) {
                totalCost = Math.min(cost, totalCost);
                cost -= workers.get(i)[1];
                eff -= workers.get(i)[0];
                i++;
            } else {
                eff += workers.get(j)[0];
                cost += workers.get(j)[1];
                j++;
            }
        }

        return totalCost == Integer.MAX_VALUE ? -1 : totalCost;
    }

}
