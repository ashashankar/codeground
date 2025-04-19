package com.myplayground.playground;

public class CountNumberOfTeams {
    public static void main(String[] args) {
        int[] t = {2,5,3,4,1};
        System.out.println(countTeams(t));
    }

    public static int countTeams(int[] ratings) {
        int count = 0;
        for (int i=1; i<ratings.length; i++) {
            int mid = i;
            int leftSmaller = 0;
            int rightLarger = 0;
            for (int j=0; j<mid; j++) {
                if (ratings[j] < ratings[mid]) leftSmaller++;
            }

            for (int j=mid+1; j<ratings.length; j++) {
                if (ratings[j] > ratings[mid]) rightLarger++;
            }
            count += leftSmaller * rightLarger;

            //decend
            int leftLarger = mid - leftSmaller;
            int rightsmaller = ratings.length - mid - 1 - rightLarger;
            count += leftLarger * rightsmaller;
        }

        return count;
    }
}
