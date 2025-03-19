import java.util.Stack;

class Queue{
    Stack<Integer> st1;
    Stack<Integer> st2;

    Queue(){
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
    }

    void enqueue(int num){
        st1.push(num);
    }

    void dequeue(){
        if(st1.isEmpty()){
            System.out.println("Queue is empty !!");
            return ;
        }
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }

        System.out.println("The element removed " + st2.pop());

        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }

}

public class QueueUsingStacks {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.dequeue();
        q.enqueue(40);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }
}