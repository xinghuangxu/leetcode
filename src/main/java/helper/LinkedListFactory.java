package helper;

/**
 * Created by xinghuangxu on 2/24/16.
 */
public class LinkedListFactory {
    public static ListNode createListFromString(String listStr){
        String[] listItemValuesInStr = listStr.split("->");
        ListNode start = new ListNode(0);
        ListNode end = start;
        for(int i=0;i<listItemValuesInStr.length;i++){
            ListNode newNode = new ListNode(Integer.parseInt(listItemValuesInStr[i]));
            end.next=newNode;
            end = newNode;
        }
        return start.next;
    }
}
