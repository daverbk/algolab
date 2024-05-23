# Reverse a linked list

* Whenever we face a linked list problem, we should break the problem down. List all the things you need to accomplish and
what we need to do to achieve them. The order in which we think of the steps will not necessarily be the same as the
order in which the steps should happen

```java
ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextNode = curr.next; // first, make sure we don't lose the next node
        curr.next = prev;              // reverse the direction of the pointer
        prev = curr;                   // set the current node to prev for the next node
        curr = nextNode;               // move on
    }

    return prev;
}
```
