package sortalgorithm;

import java.util.Arrays;

/**
 * @author: ljyang
 * @date: 2019/9/12 10:20
 * @description
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,5,3,8,2};
        int temp = 0;
        for (int i = 0; i < arr.length; i++){
            for(int j=0; j < arr.length-i-1; j++){
                if(arr[j] < arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
