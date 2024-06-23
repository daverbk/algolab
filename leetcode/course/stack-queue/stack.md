# Stack

The characteristic that makes something a "stack" is that we can only add and remove elements from the same end. It
doesn't matter how we implement it, a "stack" is just an abstract interface.

For algorithm problems, a stack is a good option whenever we can recognize the LIFO pattern. Usually, there will be
some component of the problem that involves elements in the input interacting with each other

Example problem:

```java
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && stack.charAt(stack.length() - 1) == c) 
                stack.deleteCharAt(stack.length() - 1);
            else stack.append(c);
        }
        
        return stack.toString();
    }
}
```
