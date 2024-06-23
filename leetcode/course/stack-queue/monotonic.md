# Monotonic

Monotonic stacks and queues are useful in problems that, for each element, involves finding the "next" element based on
some criteria, for example, the next greater element. They're also good when you have a dynamic window of elements and
you want to maintain knowledge of the maximum or minimum element as the window changes. In more advanced problems,
sometimes a monotonic stack or queue is only one part of the algorithm.

Pseudocode:

```
stack = []
for num in nums:
    while stack.length > 0 AND stack.top >= num:
        stack.pop()
    // Some logic depending on the problem
    stack.push(num)
```
Example problem `739. Daily Temperatures`:

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}
```
