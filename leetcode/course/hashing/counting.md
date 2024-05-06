# Counting

By "counting", we are referring to tracking the frequency of things. This means our hash map will be mapping keys to
integers. Anytime you need to count anything, think about using a hash map to do it

Simple problem example:

> You are given a string `s` and an integer `k`. Find the length of the longest substring that contains at most `k`
> distinct characters

```java
public int findLongestSubstring(String s, int k) {
    Map<Character, Integer> counts = new HashMap<>();
    int left = 0;
    int ans = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        counts.put(c, counts.getOrDefault(c, 0) + 1);
        while (counts.size() > k) {
            char remove = s.charAt(left);
            counts.put(remove, counts.getOrDefault(remove, 0) - 1);
            if (counts.get(remove) == 0) {
                counts.remove(remove);
            }

            left++;
        }

        ans = Math.max(ans, right - left + 1);
    }

    return ans;
}
```

## Count the number of sub-arrays with an "exact" constraint

* We use curr to track the prefix sum
* At any index `i`, the sum up to `i` is `curr`. If there is an index `j` whose prefix is `curr - k`, then the sum of
  the subarray with elements from `j + 1` to `i` is `curr - (curr - k) = k`
* Because the array can have negative numbers, the same prefix can occur multiple times. We use a hash map counts to
  track how many times a prefix has occurred
* At every index `i`, the frequency of `curr - k` is equal to the number of sub-arrays whose sum is equal to `k` that
  end at `i.` Add it to the answer

Problem example:

> Given an integer array `nums` and an integer `k`, find the number of sub-arrays whose sum is equal to `k`

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        
        int ans = 0;
        int curr = 0;
        
        for (int num: nums) {
            curr += num;
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }
        
        return ans;
    }
}
```

The `curr` can be used to track prefix sums differently based on a given problem. For example, if the problem required
to give the number of sub-arrays with exactly `k` odd numbers we could do the following   

```java
curr += num % 2;
```

Instead of just tracking the regular prefix sum

```java
curr += num;
```

## Counting with more difficult examples

> Given an array of strings `strs`, group the anagrams together
> For example, given `strs` = ["eat","tea","tan","ate","nat","bat"], return [["bat"],["nat","tan"],["ate","eat","tea"]]

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<String>());
            }
            
            groups.get(key).add(s);
        }
        
        return new ArrayList(groups.values());
    }
}
```

> Given an integer array `cards`, find the length of the shortest sub-array that contains at least one duplicate. If the
> array has no duplicates, return `-1`

```java
class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> dic = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int num = cards[i];
            if (dic.containsKey(num)) {
                ans = Math.min(ans, i - dic.get(num) + 1);
            }

            dic.put(num, i);
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }
}
```

> Given an array of integers `nums`, find the maximum value of `nums[i] + nums[j]`, where `nums[i]` and `nums[j]` have
> the same digit sum (the sum of their individual digits). Return `-1` if there is no pair of numbers with the same digit
> sum

```java
class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> dic = new HashMap<>();
        int ans = -1;
        for (int num: nums) {
            int digitSum = getDigitSum(num);
            if (dic.containsKey(digitSum)) {
                ans = Math.max(ans, num + dic.get(digitSum));
            }
            
            dic.put(digitSum, Math.max(dic.getOrDefault(digitSum, 0), num));
        }
        
        return ans;
    }
    
    public int getDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        
        return digitSum;
    }
}   
```

> Given an n x n matrix grid, return the number of pairs (R, C) where R is a row and C is a column, and R and C are
> equal if we consider them as 1D arrays

```java
class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> dic = new HashMap<>();
        for (int[] row : grid) {
            String key = convertToKey(row);
            dic.put(key, dic.getOrDefault(key, 0) + 1);
        }

        Map<String, Integer> dic2 = new HashMap<>();
        for (int col = 0; col < grid[0].length; col++) {
            int[] currentCol = new int[grid.length];
            for (int row = 0; row < grid.length; row++) {
                currentCol[row] = grid[row][col];
            }

            String key = convertToKey(currentCol);
            dic2.put(key, dic2.getOrDefault(key, 0) + 1);
        }

        int ans = 0;
        for (String key : dic.keySet()) {
            ans += dic.get(key) * dic2.getOrDefault(key, 0);
        }

        return ans;
    }

    public String convertToKey(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int j : arr) {
            sb.append(j);
            sb.append(",");
        }

        return sb.toString();
    }
}
```
