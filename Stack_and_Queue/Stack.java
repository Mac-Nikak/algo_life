public class Stack {
    private int n, top = -1;
    private int[] data;
    public Stack(int length)
    {
        this.n = length ;
        this.data = new int[this.n];
    }
    private boolean isEmpty(){
        if (this.top == 0)
        {
            return true;
        } else {
            return false;
        }
    }

    public void push(int x)
    {
        this.top +=1;
        this.data[this.top] = x;
    }

    public int pop()
    {
        int z = this.data[this.top];
        this.top -= 1;
        return z;
    }
    //no checks if our stack is overloaded, should be added (but won't I'm lazy)
}
