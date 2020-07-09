public class test {
    public static void main(String[] args){
        LinkedList2 arr = new LinkedList2(4);
        arr.append(34);
        arr.append(23);
        arr.append(45);
        arr.appendLeft(32);
        arr.searchAndDelete(23);
        System.out.println(arr.showFirst());
        System.out.println(arr.showLast());
    }
}
