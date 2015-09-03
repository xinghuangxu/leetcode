package leetcode;

import helper.ListNode;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xinghuang Leon Xu on 9/2/2015.
 */
public class PalindromeLinkedListTest extends TestCase {

    @Test
    public void test1() {
        ListNode head = createList(new int[]{1,2,3,2,1});
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        assertEquals(true, palindromeLinkedList.isPalindrome(head));
    }

    @Test
    public void test2() {
        ListNode head = createList(new int[]{1});
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        assertEquals(true, palindromeLinkedList.isPalindrome(head));
    }

    private ListNode createList(int[] nums) {
        ListNode[] listNodes = new ListNode[nums.length];
        for(int i=0;i<nums.length;i++){
            listNodes[i]=new ListNode(nums[i]);
        }
        for(int i=0;i<nums.length-1;i++){
            listNodes[i].next=listNodes[i+1];
        }
        return listNodes[0];
    }
}