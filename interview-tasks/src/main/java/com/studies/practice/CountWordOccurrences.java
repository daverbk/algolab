package com.studies.practice;

public class CountWordOccurrences {
    public static void main(String[] args) {
        System.out.println("Count of occurrences: " + count("apple banana apple orange banana apple", "apple")); // 3
        System.out.println("Count of occurrences: " + count("Hello, world! Hello, everyone. Hello, hello!", "hello")); // 4
        System.out.println("Count of occurrences: " + count("Dog dog DOG cat CAT cat", "dog")); // 3
        System.out.println("Count of occurrences: " + count("One, two, three! 1, 2, 3. One two three", "one")); // 2
        System.out.println("Count of occurrences: " + count("The quick brown fox jumps over the lazy dog. The quick brown fox is quick.", "quick")); // 3
    }

    // O(n) time, O(1) space
    private static int count(String text, String s) {
        int curr = 0, ans = 0;

        for (int i = 0; i < text.length(); i++) {
            if (Character.toLowerCase(text.charAt(i)) == Character.toLowerCase(s.charAt(curr))) curr++;
            if (curr == s.length()) {
                ans++;
                curr = 0;
            }
        }

        return ans;
    }
}
