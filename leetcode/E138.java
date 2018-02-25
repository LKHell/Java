import java.util.Random;

// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode head_0=head ;
    RandomListNode next;

    // First round: make copy of each node,
	  // and link them together side-by-side in a single list.
    while(head_0 != null) {
      next = head_0.next;

      RandomListNode copy = new RandomListNode(head_0.label);
      head_0.next = copy;
      copy.next = next;
      head_0 = next;
    }

    // Second round: assign random pointers for the copy nodes.
    head_0 = head; 

    while(head_0 != null) {
      if(head_0.random != null) {
        head_0.next.random = head_0.random.next;
      }
      head_0 = head_0.next.next;
    }

    // Third round: restore the original list, and extract the copy list.
    head_0 = head;

    RandomListNode pseudoHead =new RandomListNode(0);
    RandomListNode copy,copyIter = pseudoHead;
    
    while(head_0 != null) {
      next = head_0.next.next;

      copy = head_0.next;
      copyIter.next = copy;
      copyIter = copy;

      //restore
      head_0.next = next;
      head_0 =next;


    }
    
    return pseudoHead.next;
  }
}

//

public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
      if(head==null)
          return null;
      getNext(head);
      getRandom(head);
      return split(head);
  }
  public void getNext(RandomListNode head){
      while(head!=null){
          RandomListNode newhead=new RandomListNode(head.label);
          newhead.random=head.random;
          newhead.next=head.next;
          head.next=newhead;
          head=head.next.next;
      }
      return;
  }
  public void getRandom(RandomListNode head){
      while(head!=null){
          if(head.next.random!=null)
              head.next.random=head.random.next;
          head=head.next.next;
      }
      return;
  }
  public RandomListNode split(RandomListNode head){
      RandomListNode newhead=head.next;
      while(head!=null){
          RandomListNode temp=head.next;
          head.next=temp.next;
          head=head.next;
          if(temp.next!=null)
              temp.next=temp.next.next;
      }
      return newhead;
  }
}