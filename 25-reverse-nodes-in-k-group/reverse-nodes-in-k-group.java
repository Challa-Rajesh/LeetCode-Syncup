/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;

        ListNode result = new ListNode(-1);
        ListNode temp = result;

        while(end != null && start != null){
            int count = 0;
            ListNode prev = null;
            while(end != null && count != k){
                prev = end;
                end = end.next;
                count++;
            }
            if(count != k ){
                System.out.println(3);
                break;
            }
            else{
                System.out.println(4);
                ListNode NextHead = end;
                reverseList(start, end);
                start.next = NextHead;
                temp.next = prev;
                temp = start;

                start = NextHead;
                end = NextHead;
            }

        }

        temp.next = start;
        return result.next;
    }

    public void reverseList(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode curr = start;
        ListNode Next = start;

        while(curr != end){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
    }
}