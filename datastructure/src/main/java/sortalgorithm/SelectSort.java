package sortalgorithm;

import java.util.Arrays;

/**
 * @author: ljyang
 * @date: 2019/9/12 10:27
 * @description每次遍历选一个最小的数
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1,5,3,8,2};
        int minIndex = 0;
        int temp = 0;
        for(int i=0; i<arr.length-1; i++){
            minIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
