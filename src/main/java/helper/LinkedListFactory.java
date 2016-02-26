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


    public static boolean isEqual(ListNode list1, ListNode list2){
        while(list1!=null && list2 !=null){
            if(list1.val != list2.val){
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        if(list1==null && list2 == null)
            return true;
        return false;
    }


}
