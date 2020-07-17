import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

class PolynomialHash {
    private ArrayList<LinkedList<String>> buckets =
            new ArrayList<LinkedList<String>>();
    final int prime = 1000000007;
    final int x = 263;
    int m;

    public PolynomialHash(int m) throws FileNotFoundException {
        this.m = m;
        for (int i = 0; i < m; i++) {
            buckets.add(new LinkedList<String>());
        }
    }

    public void readNTimes(int n) {
        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            read(keyboard.nextLine().split(" "));
        }
    }

    public void read(String[] command) {
        switch (command[0]) {
            case ("add"):
                add(command[1]);
                break;
            case ("del"):
                del(command[1]);
                break;
            case ("find"):
                if (find(command[1])) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
                break;
            case ("check"):
                check(command[1]);
        }
    }

    private int hash(String l) {
        long hash = 0;
        for (int i = l.length() - 1; i >= 0; --i)
            hash = (hash * x + l.charAt(i)) % prime;
        return (int)hash % m;
    }

    private void add(String l) {
        if(!find(l)) {
            int hash = hash(l);
            buckets.get(hash).addFirst(l);
        }
    }

    private void del(String l) {
        int hash = hash(l);
        LinkedList<String> chain = buckets.get(hash);
        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).equals(l)) {
                chain.remove(i);
                break;
            }
        }
    }

    private boolean find(String l) {
        int hash = hash(l);
        LinkedList<String> chain = buckets.get(hash);
        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).equals(l)) {
                return true;
            }
        }
        return false;
    }

    private void check(String l) {
        int m = Integer.parseInt(l);
        LinkedList<String> chain = buckets.get(m);
        for (int i = 0; i < chain.size(); i++) {
            System.out.print(chain.get(i) + " ");
        }
        System.out.println();
    }

}


public  class Mmain
    {
        public static void main(String[] args) throws FileNotFoundException
        {
            Scanner keyboard = new Scanner(System.in);
            int m = keyboard.nextInt();
            int n = keyboard.nextInt();
            PolynomialHash solve = new PolynomialHash(m);
            for(int i = 0; i <= n; i++)
            {
                solve.read(keyboard.nextLine().split(" "));
            }
        }
    }

