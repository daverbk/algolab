# Checking for existence

One of the most common applications of a hash table or set is determining if an element exists in constant time

Anytime we find our algorithm running `if ... in ...`, then we should consider using a hash map or set to store elements
to have these operations run in O(1)

Simple problem example: 

> Given an array of integers nums and an integer `target`, return indices of two numbers such that they add up to
`target`. You cannot use the same index twice.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (dic.containsKey(complement)) { // This operation is O(1)!
                return new int[] { i, dic.get(complement) };
            }
            dic.put(num, i);
        }

        return new int[] { -1, -1};
    }
}
```
