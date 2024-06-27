package com.studies.practice;

import java.util.Arrays;

public class GreatestByDigitSum {
    public static void main(String[] args) {
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSum(new int[]{123, 456, 789}))); // 24, 789
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSum(new int[]{111, 111, 111}))); // 3, 111
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSum(new int[]{1024, 2048, 4096, 8192}))); // 21, 8192
    }

    // O(n) time (if there is no explicit statement on similar count of places among nums), O(1) space
    private static int[] findGreatestByDigitSum(int[] nums) {
        int ans = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i], currCount = 0;
            while (currNum > 0) {
                int lastDigit = currNum % 10;
                currCount += lastDigit;
                currNum /= 10;
            }
            ans = Math.max(ans, currCount);
            if (ans == currCount) index = i;
        }
        return new int[]{ans, nums[index]};
    }
}
