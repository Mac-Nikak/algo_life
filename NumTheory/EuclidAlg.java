public class EuclidAlg {
    private int x,y;
    public EuclidAlg(int num1, int num2){
        if (num1 > num2)
        {
            this.x = num1;
            this.y = num2;
        } else{
            this.x = num2;
            this.y = num1;
        }
    }

    public int gcd()
    {
        while (y != 0)
        {
            int z = x % y;
            this.x = y;
            this.y = z;
        }
        return this.x;
    }

}
