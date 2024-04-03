# General usage

Building a prefix sum is a form of pre-processing. Pre-processing is a useful strategy in a variety of problems where we
store pre-computed data in a data structure before running the main logic of our algorithm. While it takes some time to
pre-process, it's an investment that will save us a huge amount of time during the main parts of the algorithm.

A prefix sum is a great tool whenever a problem involves sums of a subarray. It only costs `O(n)`to build but allows all
future subarray queries to be `O(1)`.

```
prefix = [nums[0]]
for (int i = 1; i < nums.length; i++)
    prefix.append(nums[i] + prefix[prefix.length - 1])
```
