/*
public class LinkedList {
    private Integer[][] data;
    private Stack freePositions;
    private Integer[] nil = {null,null,null}; //fictive start and end
    public LinkedList(int length){
        data = new Integer[length][3];
        freePositions = new Stack(length);
        for(int i = 0; i < length; i++){
            freePositions.push(i);
        }
    }
    public void insert(int i)
    {
        if(nil[2] == null){
            data[0][1] = i;
            data[0][0] = nil[1];
            data[0][2] = nil[1];
            nil[2] = 0;
        }else {
            int k = freePositions.pop();
            data[head][0] = k;
            data[k][0] = nil[1];
            data[k][1] = i;
            data[k][2] = head;
            nil[2] = k;
        }
    }

    private Integer next(int i)
    {
        return data[i][2];
    }

    private Integer prev(int i)
    {
        return data[i][0];
    }

    public Integer search(int x)
    {
        int k = head;
        while (next(k) != null && data[k][1] != x){
            k = next(k);
        }
        if (data[k][1] == x){
            return k;
        } else{
            return null;
        }
    }

    public Integer searchAndDelete(Integer x)
    {
        int k = search(x);
        da
    }
}
 */