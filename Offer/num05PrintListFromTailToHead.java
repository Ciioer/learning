package Offer;

import java.util.ArrayList;
import java.util.Stack;

public class num05PrintListFromTailToHead {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode==null){
            return list;
        }
        Stack<ListNode> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop().val);
        }
        return list;
    }


}
