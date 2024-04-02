package com.studies.motorola.screaning;

// Question: You are given an array A of N integers. You can multiply any of its elements by an arbitrary number.
// The task is to make the first element of A positive, the second element equal to 0, the third element negative,
// the fourth equal to 0, the fifth positive and so on. In other words, the signs of consecutive elements should be
// [+, 0, -, 0, +, 0, -, ..].
// What is the minimum number of multiplications needed to create such a sequence?
// Examples:
// 1. For A = [1, 0, 3, 4, 5, 0, 6], one of the optimal solutions is to multiply 3 by
//  -2, 4 by 0 and 6 by -1. After these changes, A will transform to [1, 0, -6, 0, 5, 0, -6].
//  The signs of the consecutive elements will be [+, 0, -, 0, +, 0, -], as required in the task statement.
//  The function should return 3.
// 2. For A = [7, 4, -3, 0, -5, 1, O], it is not possible to convert the last zero
//   into a negative number. The function should return -1
// 3. For A = [-5, 0, 3, 0], the function should return 2

public class MinimumNumberOfMultiplications {
    public static void main(String[] args) {
        System.out.println(minimumNumberOfMultiplications(new int[]{1, 0, 3, 4, 5, 0, 6}));
    }

    public static int minimumNumberOfMultiplications(int[] A) {
        return 0;
    }
}
