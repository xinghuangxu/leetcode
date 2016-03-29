package leetcode;

import helper.ListNode;

/**
 * Created by k586j642 on 3/29/2016.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode start = new ListNode(0);
        ListNode end = start;
        int min = findMin(lists);
        while (min != Integer.MAX_VALUE) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val == min) {
                    ListNode tmp = lists[i].next;
                    end.next = lists[i];
                    end = end.next;
                    end.next = null;
                    lists[i] = tmp;
                }
            }
            min = findMin(lists);
        }
        return start.next;
    }

    private int findMin(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
            }
        }
        return min;
    }
}
