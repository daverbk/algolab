# Queue

For algorithm problems, queues are less common than stacks, and the problems are general.

Example problem `933. Number of Recent Calls`:

```java
class RecentCounter {
    Queue<Integer> queue;
    
    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        
        queue.offer(t);
        return queue.size();
    }
}
```
