package com.myplayground.playground;

public class LC2529_MaxCountOfPosandNegIntegers_BS {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2};
        //nums = {0, 0,0, 0,0, 0,0, 0}
        //nums = {5,20,66,1314}
        System.out.println(new LC2529_MaxCountOfPosandNegIntegers_BS().maximumCount(nums));
    }
    public int maximumCount(int[] nums) {
        int pos =nums.length - upper(nums);
        int neg =lower(nums);
        return Math.max(pos, neg);
    }

    public int upper(int[] nums) {
        int l = 0;
        int r = nums.length -1;
        int answer = nums.length;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] <=0) {
                l = mid + 1;
            } else {

                r = mid -1;
                answer = mid;
            }
        }
        return answer;
    }

    public int lower(int[] nums) {
        int l = 0;
        int r = nums.length -1;
        int answer = nums.length;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] >=0) {
                answer = mid;
                r = mid - 1;

            } else {

                l = mid + 1;
            }
        }
        return answer;
    }
}
