## Advantages and disadvantages compared to arrays

* The main advantage of a linked list is that you can add and remove elements at any position in O(1). The caveat is
  that you need to have a reference to a node at the position in which you want to perform the addition/removal,
  otherwise the operation is O(n), because you will need to iterate starting from the head until you get to the desired
  position. However, this is still much better than a normal (dynamic) array, which requires O(n) for adding and
  removing from an arbitrary position

* The main disadvantage of a linked list is that there is no random access. If you have a large linked list and want to
  access the 150,000th element, then there usually isn't a better way than to start at the head and iterate 150,000
  times. So while an array has O(1) indexing, a linked list could require O(n) to access an element at a given position

* While dynamic arrays can be resized, under the hood they still are allocated a fixed size - it's just that when this
  size is exceeded, the array is resized, which is expensive. Linked lists don't suffer from this. However, linked lists
  have more overhead than arrays - every element needs to have extra storage for the pointers. If you are only storing
  small items like booleans or characters, then you may be more than doubling the space needed

## Sentinel tail and head nodes in use

```java
class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode (int val) {
        this.val = val;
    }
}

void addToEnd(ListNode nodeToAdd) {
    nodeToAdd.next = tail;
    nodeToAdd.prev = tail.prev;
    tail.prev.next = nodeToAdd;
    tail.prev = nodeToAdd;
}

void removeFromEnd() {
    if (head.next == tail) {
        return;
    }

    ListNode nodeToRemove = tail.prev;
    nodeToRemove.prev.next = tail;
    tail.prev = nodeToRemove.prev;
}

void addToStart(ListNode nodeToAdd) {
    nodeToAdd.prev = head;
    nodeToAdd.next = head.next;
    head.next.prev = nodeToAdd;
    head.next = nodeToAdd;
}

void removeFromStart() {
    if (head.next == tail) {
        return;
    }

    ListNode nodeToRemove = head.next;
    nodeToRemove.next.prev = head;
    head.next = nodeToRemove.next;
}

ListNode head = new ListNode(-1);
ListNode tail = new ListNode(-1);
head.next = tail;
tail.prev = head;
```
