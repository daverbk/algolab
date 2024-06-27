package com.studies.practice;

import java.util.Arrays;

public class TwoSmallestElements {
    public static void main(String[] args) {
        System.out.println("Two smallest elements in the array are: " +
                Arrays.toString(getTwoSmallestElements(new int[]{100, 50, 300, 200, 400, 150, 250}))); // 50, 100

        System.out.println("Two smallest elements in the array are: " +
                Arrays.toString(getTwoSmallestElements(new int[]{10, 20}))); // 10, 20

        System.out.println("Two smallest elements in the array are: " +
                Arrays.toString(getTwoSmallestElements(new int[]{-10, -20, -30, -40, -50, -60, -70, -80, -90, -100}))); // -100, -90

        System.out.println("Two smallest elements in the array are: " +
                Arrays.toString(getTwoSmallestElements(new int[]{10, -10, 20, -20, 30, -30, 40, -40, 50, -50}))); // -50, -40

        System.out.println("Two smallest elements in the array are: " +
                Arrays.toString(getTwoSmallestElements(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))); // 1, 2

        System.out.println("Two smallest elements in the array are: " +
                Arrays.toString(getTwoSmallestElements(new int[]{10}))); // 10, 20
    }

    // O(n), one pass
    private static int[] getTwoSmallestElements(int[] nums) {
        int first, second, n = nums.length;
        if (n < 2) return new int[]{};

        first = second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < first) {
                second = first;
                first = num;
            } else if (num < second && num != first)
                second = num;
        }

        if (first == Integer.MAX_VALUE || second == Integer.MAX_VALUE)
            return new int[]{};

        return new int[]{first, second};
    }

    // O(n), but is actually double traversal
    //    private static int[] getTwoSmallestElements(int[] nums) {
    //        int smallest = Integer.MAX_VALUE;
    //        for (int num : nums) {
    //            if (num < smallest) smallest = num;
    //        }
    //
    //        int secondSmallest = Integer.MAX_VALUE;
    //        for (int num : nums) {
    //            if (num < secondSmallest && num > smallest) secondSmallest = num;
    //        }
    //
    //        if (smallest == Integer.MAX_VALUE || secondSmallest == Integer.MAX_VALUE)
    //            return new int[]{};
    //
    //        return new int[]{smallest, secondSmallest};
    //    }
}

