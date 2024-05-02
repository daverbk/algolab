| Operation                  | Hash Map / Hash Set |
|----------------------------|---------------------|
| Adding an element          | *O(1)               |
| Deletion                   | O(1)                |
| Checking if element exists | O(1)                |
| Modifying element          | O(1)                |
| Retrieving an element      | O(n)                |

`*O(1)` amortized time complexity for adding to a HashMap / HashSet is caused by the need to resize the underlying 
array when the load factor is reached
