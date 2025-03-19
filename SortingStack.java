class Stack{
    int ptr;
    int[] arr;
    int size;

    Stack(int size){
        this.arr = new int[size];
        int ptr = 0;
        this.size = size;
    }

    void doubleArray(){
        this.size = this.size * 2;
        int[] newArr = new int[this.size];
        int pointer = 0;
        for(int i:arr){
            newArr[pointer++] = i;
        }
        arr = newArr;
    }

    void push(int num){
        if(ptr==size){
            doubleArray();
        }
        arr[ptr++] = num;
    }

    int peek(){
        if(isEmpty()){
            System.out.println("The stack is empty");
        }
        return arr[ptr-1];
    }

    int pop(){
        if(isEmpty()){
            System.out.println("The array is empty");
            return -1;
        }

        return arr[--ptr];
    }

    boolean isEmpty(){
        if(ptr == 0) return true;
        return false;
    }

    void addElementInSortedStack(int element){
        if(this.isEmpty() || this.peek() <= element){
            this.push(element);
            return ;
        }
        int top = this.pop();
        addElementInSortedStack(element);
        this.push(top);
    }

    void sort(){
        if(this.isEmpty()){
            return ;
        }
        int top = this.pop();
        sort();
        addElementInSortedStack(top);
    }

    void displayStack(Stack st){
        if(st.isEmpty()){
            return ;
        }
        int top = st.pop();
        System.out.println(top);
        displayStack(st);
        st.push(top);
    }
}


public class SortingStack {
    public static void main(String[] args) {
        Stack st = new Stack(2);
        st.push(101);
        st.push(22);
//        st.pop();
        st.push(43);
//        System.out.println(st.peek());
        st.push(4);
        st.push(3);
        st.push(7);
        st.sort();
        st.displayStack(st);

    }
}