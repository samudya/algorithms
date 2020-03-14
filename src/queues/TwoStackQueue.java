package queues;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> inStack= new Stack<>();
    private Stack<Integer> outStack= new Stack<>();

    public void enqueue(int item){
        inStack.push(item);
    }
    public int dequeue(){
        if(outStack.empty()){
            while (!inStack.empty()){
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }
}
