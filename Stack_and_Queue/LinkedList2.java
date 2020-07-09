public class LinkedList2 {
    private int[][] data;
    private Stack freePositions;
    public LinkedList2(int length){
        data = new int[length+1][3];/*the first position is nil,
        the data[0][0] shows on tail and data[0][2] shows on head */
        data[0][0] = 0;
        data[0][1] = 0;
        data[0][2] = 0;
        freePositions = new Stack(length);
        for(int i = 1; i <= length; i++){
            freePositions.push(i);
        }
    }

    private int prev(int k)
    {
        return data[k][0];
    }

    private int next(int k)
    {
        return data[k][2];
    }

    private int value(int k)
    {
        return data[k][1];
    }

    public void appendLeft(int i){
        if (data[0][2] == 0){
            int k = freePositions.pop();
            data[k][0] = 0;
            data[k][1] = i;
            data[k][2] = 0;
            data[0][0] = k;
            data[0][2] = k;
        } else{
            int k = freePositions.pop();
            data[k][0] = 0;
            data[k][1] = i;
            data[next(0)][0] = k;
            data[k][2] = data[0][2];
            data[0][2] = k;
        }
    }

    public int search(int x)
    {
        int k = data[0][2];
        while (next(k) != 0 && value(k) != x)
        {
            k = next(k);
        }
        if (value(k) == x){
            return k;
        }
        else{
            return 0;
        }
    }

    public void delete(int k){
        data[prev(k)][2] = next(k);
        data[next(k)][0] = prev(k);
        freePositions.push(k);
    }

    public void searchAndDelete(int x)
    {
        int k = search(x);
        if(k != 0){
            delete(k);
        }
    }

    public void append(int i){
        if(data[0][0] == 0){
            appendLeft(i);
        } else{
            int k = freePositions.pop();
            data[k][0] = data[0][0];
            data[k][1] = i;
            data[k][2] = 0;
            data[prev(0)][2] = k;
            data[0][0] = k;
        }
    }

    public int showFirst()
    {
        return value(next(0));
    }

    public int showLast()
    {
        return value(prev(0));
    }
}

/*
O(n)-search, O(1) append left and right, O(1) delete, if we now the position(if we don't know we have to search).
 */
