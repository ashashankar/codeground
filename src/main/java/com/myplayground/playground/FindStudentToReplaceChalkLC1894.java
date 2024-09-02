package com.myplayground.playground;

public class FindStudentToReplaceChalkLC1894 {
    public static void main(String[] args) {
        int[] chalk = {3,4,1,2};
        int k = 25;
        System.out.println(new FindStudentToReplaceChalkLC1894().chalkReplacer(chalk, k));
    }

    public int chalkReplacer(int[] chalk, int k) {
        int result = 0;
        int len = chalk.length;
        int sum = 0;
        for (int c : chalk) {
            sum += c;
        }
        int remain = k % sum;

        return find(chalk, remain);
    }

    public int find(int[] chalk, int remain) {
        for (int i=0; i<chalk.length; i++) {
            if (chalk[i] > remain){
                return i;
            }
            remain -= chalk[i];
        }
        return 0;
    }
}
