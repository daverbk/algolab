# Big O

<!-- TOC -->
* [Big O](#big-o)
  * [Rules](#rules)
  * [Analyzing time complexity](#analyzing-time-complexity)
  * [Analyzing space complexity](#analyzing-space-complexity)
<!-- TOC -->

Roughly, your function calculates the number of operations or amount of memory your algorithm consumes relative to the
input size

We usually denote `n` as the number of elements in function input

Examples:

* O(n)
* O(n^2)
* O(log n)
* O(n * m)

`m` usually means the size of the second input

> [!NOTE]
> Time complexity is not meant to be an exact representation of the number of operations

## Rules

1. Ignore constants. The point of complexity is to analyze the algorithm as the input changes.
2. We consider the complexity as the variables tend to infinity

> [NOTE!]
> The best complexity possible is O(1), called "constant time" or "constant space".
> It means that the algorithm ALWAYS uses the same amount of resources, regardless of the input.

When talking about complexity, there are normally three cases:

* Best case scenario
* Average case
* Worst case scenario

In most algorithms, all three of these will be equal, but some algorithms will have them differ

If we have to choose only one to represent the algorithm's time or space complexity, we choose the worst case scenario

## Analyzing time complexity

*[Understanding Time Complexity with Simple Examples](https://www.geeksforgeeks.org/understanding-time-complexity-simple-examples/)*

When analyzing time complexity, we are looking at the number of operations the algorithm performs

## Analyzing space complexity

When you initialize variables like arrays or strings, your algorithm is allocating memory. We never count the space used
by the input

Space complexity is a parallel concept to time complexity. If we need to create an array of size n, this will require O(
n) space. If we create a two-dimensional array of size n*n, this will require O(n^2) space
