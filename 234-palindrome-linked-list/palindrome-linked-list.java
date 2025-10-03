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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newhead = reverseLinkedList(slow.next);
        ListNode first = head;
        ListNode second = newhead;
        while (second != null) {
            if (first.val != second.val) {
                reverseLinkedList(newhead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLinkedList(newhead);
        return true;
    }

    // \U0001f447 You forgot to include this earlier
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
