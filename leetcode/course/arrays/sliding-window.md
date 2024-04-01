# When should we use sliding window?

<br/>

1. the problem will either explicitly or implicitly define criteria that make a subarray "valid". There are 2 components
   regarding what makes a subarray valid:

    * A constraint metric. This is some attribute of a subarray. It could be the sum, the number of unique elements, the
      frequency of a specific element, or any other attribute
    * A numeric restriction on the constraint metric. This is what the constraint metric should be for a subarray to be
      considered valid

<br/>

2. the problem will ask you to find valid sub-arrays in some way

   * The most common task you will see is finding the best valid subarray. The problem will define what makes a subarray
     better than another. For example, a problem might ask you to find the longest valid subarray
   * Another common task is finding the number of valid sub-arrays

<br/>

Example problems:

* Find the longest subarray with a sum less than or equal to `k`
* Find the longest substring that has at most one `"0"`
* Find the number of sub-arrays that have a product less than `k`


# General usage

1. Initially, we have left = right = 0, which means that the first subarray we look at is just the first element of the
   array on its own
2. We want to expand the size of our "window", and we do that by incrementing right. When we increment right, this is
   like "adding" a new element to our window
3. To "remove" elements, we can increment left, which shrinks our window
4. As we add and remove elements, we are "sliding" our window along the input from left to right. it always slides along
   to the right, until we reach the end of the input

```
function fn(arr):
left = 0
for (int right = 0; right < arr.length; right++):
Do some logic to "add" element at arr[right] to window

        while WINDOW_IS_INVALID:
            Do some logic to "remove" element at arr[left] from window
            left++

        Do some logic to update the answer

```

# Usage for fixed window size

1. Start by building the first window (from index `0` to `k - 1`)
2. Once we have a window of size `k`, if we add an element at index `i`, we need to remove the element at index `i - k`

```
function fn(arr, k):
    curr = some data to track the window

    // build the first window
    for (int i = 0; i < k; i++)
        Do something with curr or other variables to build first window

    ans = answer variable, probably equal to curr here depending on the problem
    for (int i = k; i < arr.length; i++)
        Add arr[i] to window
        Remove arr[i - k] from window
        Update ans

    return ans
```

