package sortalgorithm;

import java.util.Arrays;

/**
 * @author: ljyang
 * @date: 2019/9/12 14:30
 * @description
 */

public class HillSort {
    public static void main(String[] args) {
        int[] arr = {16,2,8,4,6,9,2,7,89,5,70};
        int len = arr.length;
        int h = 1, temp;
        while(len / 3 > h){
            h = h*3 + 1;
        }
        while(h>=1){
            for(int i=0; i<len-h; i++){
                for(int j = i+h; j>=h; j-=h){
                    if(arr[j] < arr[j-h]){
                        temp = arr[j];
                        arr[j] = arr[j-h];
                        arr[j-h] = temp;
                    }
                }
            }
            h = h/3;
        }
        System.out.println(Arrays.toString(arr));
    }
}
