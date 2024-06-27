package com.studies.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class GreatestByDigitSum {
    public static void main(String[] args) {
        System.out.println("Via loops:");
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSum(new int[]{123, 456, 789}))); // 24, 789
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSum(new int[]{111, 111, 111}))); // 3, 111
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSum(new int[]{1024, 2048, 4096, 8192}))); // 21, 8192
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSum(new int[]{}))); // 21, 8192
        System.out.println("=".repeat(30));

        System.out.println("Via recursion:");
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSumRecursion(new int[]{123, 456, 789}))); // 24, 789
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSumRecursion(new int[]{111, 111, 111}))); // 3, 111
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSumRecursion(new int[]{1024, 2048, 4096, 8192}))); // 21, 8192
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSumRecursion(new int[]{}))); // 21, 8192
        System.out.println("=".repeat(30));

        System.out.println("Via a stream:");
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSumStreams(new int[]{123, 456, 789}))); // 24, 789
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSumStreams(new int[]{111, 111, 111}))); // 3, 111
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSumStreams(new int[]{1024, 2048, 4096, 8192}))); // 21, 8192
        System.out.println("Greatest digit sum: " + Arrays.toString(findGreatestByDigitSumStreams(new int[]{}))); // 21, 8192
        System.out.println("=".repeat(30));
    }

    // O(n) time (if there is no explicit statement on similar count of places among nums), O(1) space
    private static int[] findGreatestByDigitSum(int[] nums) {
        if (nums.length < 1) return null;
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

    // no comments, just tried to do it via a stream
    private static int[] findGreatestByDigitSumRecursion(int[] nums) {
        if (nums.length < 1) return null;
        int ans = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = getDigitSum(nums[i]);
            if (ans < sum) {
                ans = sum;
                index = i;
            }
        }
        return new int[]{ans, nums[index]};
    }

    private static int getDigitSum(int num) {
        if (num == 0) return 0;
        return num % 10 + getDigitSum(num / 10);
    }

    private static int[] findGreatestByDigitSumStreams(int[] nums) {
        Map<Integer, Integer> ans = Arrays.stream(nums)
                .boxed().map(num -> {
                    int sum = 0;
                    int currNum = num;
                    while (currNum > 0) {
                        int lastDigit = currNum % 10;
                        sum += lastDigit;
                        currNum /= 10;
                    }
                    return Map.of(sum, num);
                }).max(Comparator.comparingInt(o -> o.values().iterator().next()))
                .orElse(null);

        if (ans != null) {
            for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
                return new int[]{entry.getKey(), entry.getValue()};
            }
        }

        return null;
    }
}
