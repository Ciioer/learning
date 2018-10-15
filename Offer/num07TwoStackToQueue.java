package Offer;

import java.util.Stack;

public class num07TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public  void push(int i){
        stack1.push(i);
    }
    public int pop() throws Exception {
        if (stack1.isEmpty()){
            throw new Exception("空了");
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }
}
