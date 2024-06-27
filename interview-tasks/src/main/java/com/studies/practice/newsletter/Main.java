package com.studies.practice.newsletter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Is feed following the rule? " + isFeedCorrect(new Article[]{ // true
                new Article(1, "content1"),
                new Article(2, "content2"),
                new Article(3, "content3"),
                new Article(4, "content4"),
                new Article(5, "content5"),
                new Article(6, "content6"),
                new Article(7, "content7"),
                new Article(8, "content8"),
                new Article(9, "content9"),
                new Article(10, "content10"),
                new Article(11, "content11"),
                new Article(12, "content12"),
                new Article(13, "content13"),
                new Article(14, "content14"),
                new Article(1, "content15"),
                new Article(2, "content16"),
                new Article(3, "content17"),
                new Article(4, "content18"),
                new Article(5, "content19"),
                new Article(6, "content20")
        }));

        System.out.println("=".repeat(30));
        System.out.println("Is feed following the rule? " + isFeedCorrect(new Article[]{ // false
                new Article(1, "content1"),
                new Article(2, "content2"),
                new Article(3, "content3"),
                new Article(4, "content4"),
                new Article(5, "content5"),
                new Article(6, "content6"),
                new Article(9, "content7"),
                new Article(10, "content8"),
                new Article(1, "content9"),
                new Article(3, "content10"),
                new Article(5, "content11"),
                new Article(10, "content12"),
                new Article(2, "content13"),
                new Article(3, "content14"),
                new Article(11, "content15"),
                new Article(12, "content16"),
                new Article(13, "content17"),
                new Article(14, "content18"),
                new Article(15, "content19"),
                new Article(16, "content20")
        }));

        System.out.println("=".repeat(30));
        System.out.println("Is feed following the rule? " + isFeedCorrect(new Article[]{ // false
                new Article(1, "content1"),
                new Article(1, "content1"),
                new Article(3, "content3"),
                new Article(4, "content4"),
                new Article(5, "content5"),
                new Article(6, "content6"),
                new Article(9, "content7")
        }));

        System.out.println("=".repeat(30));
        System.out.println("Is feed following the rule? " + isFeedCorrect(new Article[]{ // true
                new Article(1, "content1"),
                new Article(2, "content1")
        }));

        System.out.println("=".repeat(30));
        System.out.println("Is feed following the rule? " + isFeedCorrect(new Article[]{ // true
                new Article(1, "content1")
        }));

        System.out.println("=".repeat(30));
        System.out.println("Is feed following the rule? " + isFeedCorrect(new Article[]{})); // true
    }

    // O(n) time, but in reality takes twice longer in case of more than 10 inputs, O(n) space because of the set
    private static boolean isFeedCorrect(Article[] feed) {
        Set<Integer> seen = new HashSet<>();
        int left = 0, curr = 0;

        for (Article article : feed) {
            int currSource = article.getSource();
            if (seen.contains(currSource)) return false;
            seen.add(currSource);
            if (curr == 10) {
                while (curr >= 0) {
                    seen.remove(feed[left].getSource());
                    left++;
                    curr--;
                }
            }
            curr++;
        }

        return true;
    }
}
