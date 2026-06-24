class MyQueue {

    Stack<Integer> Instack = new Stack<>();
    Stack<Integer> Outstack = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        
         Instack.push(x);
    }
    
    public int pop() {
        shiftback();
       return  Outstack.pop();
        
    }
    
    public int peek() {
        shiftback();
      return  Outstack.peek();
        
    }
    
    public boolean empty() {

        return Instack.isEmpty() && Outstack.isEmpty();
        
    }

    public void shiftback(){

        if(Outstack.isEmpty()){

            while(!Instack.isEmpty()){

                Outstack.push(Instack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */