# Sub-arrays, subsequences, and subsets

## Sub-arrays

Sub-array or sub-string is a contiguous section of an array or string.

The size of a sub-array between `i` and `j` (inclusive) is `j - i + 1`. This is also the number of sub-arrays that end
at `j`, starting from `i` or later.

### Advice

1) If a problem has explicit constraints such as:

* Sum greater than or less than `k`
* Limits on what is contained, such as the maximum of `k` unique elements or no duplicates allowed
* And/or asks for:
    * Minimum or maximum length
    * Number of sub-arrays/sub-strings
    * Max or minimum sum

Think about a sliding window.

2) If a problem's input is an integer array and you find yourself needing to calculate multiple sub-array sums, consider
   building a prefix sum.

## Subsequences

Subsequence is a set of elements of an array/string that keeps the same relative order but doesn't need to be
contiguous.

For example, subsequences of `[1, 2, 3, 4]` include: `[1, 3]`, `[4]`, `[]`, `[2, 3]`, but not `[3, 2]`, `[5]`, `[4, 1]`.

### Advice

Dynamic programming is used to solve a lot of subsequence problems.

One more associated with subsequences is two pointers when two input arrays/strings are given. Because prefix sums and
sliding windows represent sub-arrays/sub-strings, they are not applicable here.

## Subsets

A subset is any set of elements from the original array or string. The order doesn't matter and neither do the elements
being beside each other. For example, given `[1, 2, 3, 4]`, all of these are subsets: `[3, 2]`, `[4, 1, 2]`, `[1]`.
Subsets that contain the same elements are considered the same, so `[1, 2, 4]` is the same subset as `[4, 1, 2]`.

### Advice

Subsets are being used with backtracking.

One thing to note is that if a problem involves subsequences, but the order of the subsequence doesn't actually matter,
then we can treat it the same as a subset.
