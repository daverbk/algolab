# What are hash maps

A hash map is an unordered data structure that stores key-value pairs. A hash map can add and remove
elements in O(1), as well as update values associated with a key and check if a key exists, also in O(1)

## Why not an array?

Hash maps are just easier/cleaner to work with. Even if your keys are integers, and you could get away with using an
array, if you don't know what the max size of your key is, then you don't know how large you should size your array.
With hash maps, you don't need to worry about that, since the key will be converted to a new integer within the size
limit anyway

## Why array instead of hash map?

* The biggest disadvantage of hash maps is that for smaller input sizes, they can be slower due to overhead. Because big O
ignores constants, the O(1) time complexity can sometimes be deceiving - it's usually something more like O(10) because
every key needs to go through the hash function, and there can also be collisions
* Hash tables can also take up more space

# Sets

It uses the same mechanism for hashing keys into integers. The difference between a set and hash table is that sets do
not map their keys to anything. An important thing to note about sets is that they don't track frequency. If you have a
set and add the same element 100 times, the first operation adds it and the next 99 do nothing
