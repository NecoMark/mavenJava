package sortalgorithm;

import java.util.Arrays;

/**
 * @author: ljyang
 * @date: 2019/9/12 11:06
 * @description选一个基准值
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,6,3,8,0,8,4,32};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    static void sort(int[] arr, int beginIndex, int endIndex){
        if(beginIndex >= endIndex){
            return;
        }
        int left = beginIndex, right = endIndex;
        int value = arr[beginIndex];
        while(left < right){
            while(left < right){
                if(arr[right] > value){
                    right-- ;
                }else{
                    break;
                }
            }
            while (left < right){
                if (arr[left] <= value){
                    left++;
                }else{
                    break;
                }
            }
            if(left < right){
                int temp = 0;
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

        }
        //left == right
        arr[beginIndex] = arr[left];
        arr[left] = value;
        sort(arr, beginIndex, left-1);
        sort(arr, left+1, endIndex);
    }
}
