package cn.felixgu.module.seckill.cmd;

public class QuickSort {

    public static void sort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null|| arr.length <= 1  ){
            return;
        }
        int a = head;int z = tail;int midValue = arr[(head + tail)/2];
        while(a <= z) {
            while (arr[a] < midValue) {
                 ++a ;
            }
            while (arr[z] > midValue) {
                --z;
            }
            if (a < z) {
                int tmp = arr[a];
                arr[a] = arr[z];
                arr[z] = tmp;
                ++a;
                --z;
            } else if (a == z){
                ++a;
            }
        }
        sort(arr, head, z);
        sort(arr, a, tail);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,6,2,63,123,6125,253,23523,63,3235,23,3,23,5,6,7,34,23};
        sort(arr, 0, arr.length - 1);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
