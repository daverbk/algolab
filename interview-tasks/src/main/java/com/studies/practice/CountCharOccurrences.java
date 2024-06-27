package com.studies.practice;

public class CountCharOccurrences {
    public static void main(String[] args) {
        System.out.println("Count of occurrences: " + count("banana", 'a')); // 3
        System.out.println("Count of occurrences: " + count("Hello, world! Hello, everyone.", 'o')); // 4
        System.out.println("Count of occurrences: " + count("Dog dog DOG cat CAT cat", 'g')); // 3
        System.out.println("Count of occurrences: " + count("One, two, three! 1, 2, 3.", 'e')); // 3
        System.out.println("Count of occurrences: " + count("The quick brown fox jumps over the lazy dog. The quick brown fox is quick.", '!')); // 0
    }

    private static int count(String s, char c) {
        int ans = 0;
        for (char ch : s.toCharArray())
            if (Character.toLowerCase(ch) == Character.toLowerCase(c))
                ans++;

        return ans;
    }
}
