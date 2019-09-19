package sortalgorithm;

import java.util.Arrays;

/**
 * @author: ljyang
 * @date: 2019/9/12 10:34
 * @description
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,10,5,3,8,2,9};
        for(int i=1; i<arr.length; i++){
            int value = arr[i];
            int j = i-1;
            for(j=i-1; j>=0; j--){
                if(arr[j] > value){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = value;

        }
        System.out.println(Arrays.toString(arr));
    }
}
