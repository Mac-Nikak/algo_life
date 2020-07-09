public class Queue {
    private int head = 0, tail = 0, length, now = 0;
    private double[] data;
    public Queue(int length)
    {
        this.length = length;
        this.data = new double[length];
    }

    public void enqueue(double x){
        this.data[this.tail] = x;
        this.now ++;
        this.tail = (this.tail + 1) % this.length;
    }

    public double dequeue(){
        double z = this.data[this.head];
        this.head = (this.head + 1) % this.head;
        this.now --;
        return z;
    }

    private boolean full(){
        if(this.now == this.length){
            return true;
        }else{
            return false;
        }
    }

}
