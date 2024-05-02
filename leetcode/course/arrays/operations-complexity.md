| Operation                  | ArrayList | String |
|----------------------------|-----------|--------|
| Appending to end           | *O(1)     | O(n)   |
| Popping from end           | O(1)      | O(n)   |
| Insertion, not from end    | O(n)      | O(n)   |
| Deletion, not from end     | O(n)      | O(n)   |
| Modifying element          | O(1)      | O(n)   |
| Random access              | O(1)      | O(1)   |
| Checking if element exists | O(n)      | O(n)   |

`*O(1)` amortized time complexity for appending to the end of an ArrayList is caused by the need to resize the array
when it's full
