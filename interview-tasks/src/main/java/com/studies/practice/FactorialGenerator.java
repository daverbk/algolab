package com.studies.practice;

public class FactorialGenerator {
    public static void main(String[] args) {
        System.out.println("Via loop:");
        System.out.println("Factorial of 3: " + generateViaLoop(3)); // 6
        System.out.println("Factorial of 5: " + generateViaLoop(5)); // 120
        System.out.println("Factorial of 10: " + generateViaLoop(10)); // 3628800
        System.out.println("=".repeat(30));

        System.out.println("Via recursion:");
        System.out.println("Factorial of 3: " + generateViaRecursion(3)); // 6
        System.out.println("Factorial of 5: " + generateViaRecursion(5)); // 120
        System.out.println("Factorial of 10: " + generateViaRecursion(10)); // 3628800
        System.out.println("=".repeat(30));
    }

    // O(n) :))
    private static int generateViaLoop(int num) {
        int ans = 1;

        while (num > 0) {
            ans *= num;
            num--;
        }

        return ans;
    }

    // O(n), probably :)))
    private static int generateViaRecursion(int num) {
        if (num <= 0) return 1;
        return num * generateViaRecursion(--num);
    }
}
