package sortalgorithm;

import java.util.Arrays;

/**
 * @author: ljyang
 * @date: 2019/9/12 17:15
 * @description
 */

public class MergeSort {
    static int[] temp = new int[20];
    public static void main(String[] args) {
        int[] arr = {4,1,9};
        int len = arr.length;
        mergeSort(arr, 0, len-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr, int begin, int end){
        if (begin < end){
            int mid = (begin + end) / 2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, begin, mid, end);
        }
    }
    static void merge(int[] arr, int begin, int mid, int end){
        int i = begin;
        int j = mid + 1;
        int k = begin;
        while (i <= mid && j <= end){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }
        for(int t=begin; t<=end; t++){
            arr[t] = temp[t];
        }
    }
}
