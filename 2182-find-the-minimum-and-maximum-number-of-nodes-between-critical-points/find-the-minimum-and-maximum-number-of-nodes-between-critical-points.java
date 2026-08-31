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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ArrayList<Integer> points = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = head.next;

        int pos = 1;

        while (curr.next != null) {

            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                points.add(pos);
            }

            prev = curr;
            curr = curr.next;
            pos++;
        }

        if (points.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i < points.size(); i++) {
            minDistance = Math.min(
                minDistance,
                points.get(i) - points.get(i - 1)
            );
        }

        int maxDistance = points.get(points.size() - 1)
                         - points.get(0);

        return new int[]{minDistance, maxDistance};
    }
}