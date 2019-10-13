package src.linkedList.easy;

public class DeleteNodeInASingularLinkedList {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public void deleteNode(ListNode node) {
        ListNode prev = new ListNode(1);
        while(node.next != null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        
        prev.next = null;
    }
}

/**
 * Since we only have the reference to a node which is not the head, we don't have access to the rest of the list.
 * We can do this by copying the value of the next node to the current node. Which gives an impression that we have deleted it.
 * We are simply copying all values from the right of the node. We then delete the last redundant element. 
 */
