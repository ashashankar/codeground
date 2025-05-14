package codeground.src.main.java.com.myplayground.playground;

import java.util.ArrayList;
import java.util.List;

public class SummaryRangesLC228 {
     public static void main(String[] args) {
         int[] nums =  {0,2,3,4,6,8,9};
        System.out.println(new SummaryRangesLC228().summaryRanges(nums));
     }

    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        List<String> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            start = nums[i];
            while (i+1 < nums.length && nums[i] + 1 == nums[i+1]) {
                i++;
            }

            if (nums[i] == start) {
                result.add(String.valueOf(nums[i]));
            } else {
                String s = start + "->" + nums[i];
                result.add(s);
                start = i;
            }
        }

        return result;
    }
}
