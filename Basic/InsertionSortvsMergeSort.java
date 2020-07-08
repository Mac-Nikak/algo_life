import java.util.Scanner;

public class InsertionSortvsMergeSort {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        double[] nums = new double[n];
        for(int i = 0; i< n; i++){
            nums[i] = Math.random() * 1000;
        }
        double[] nums1 = nums.clone();
        System.out.println("Insertion sort started.");
        insertionSort(nums);
        System.out.println("Insertion sort ended.");
        System.out.println("Merge sort started.");
        mergeSort(nums1, 0, n);
        System.out.println("Merge sort ended.");
    }

    public static void insertionSort(double[] arr){
        for(int j = 1; j < arr.length; j++){
            double key = arr[j];
            int i = j-1;
            while(i>=0 && arr[i] > key ){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }

    public static double[] mergeSort(double[] arr, int l, int r){
        if (l > r){
            return new double[0];
        } else if (r-l == 1){
            double[] k = new double[1];
            k[0] = arr[l];
            return k;
        }
        int m = (l+r)/2;
        double[] leftArr = mergeSort(arr,l, m);
        double[] rightArr = mergeSort(arr,m,r);
        return merge(leftArr, rightArr);

    }

    public static double[] merge(double[] leftArr, double[] rightArr){
        double[] finArr = new double[leftArr.length + rightArr.length];
        int i = 0, j = 0;
        while(i < leftArr.length && j < rightArr.length){
            if (leftArr[i] < rightArr[j]){
                finArr[i+j] = leftArr[i];
                i++;
            }else{
                finArr[i+j] = rightArr[j];
                j++;
            }
        }
        while(i < leftArr.length){
            finArr[i+j] = leftArr[i];
            i++;
        }
        while(j < rightArr.length){
            finArr[i+j] = rightArr[j];
            j++;
        }
        return finArr;


    }
}
