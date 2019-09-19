package dpalgorithm;

/**
 * @author: ljyang
 * @date: 2019/9/16 9:12
 * @description 物品重量为2 2 6 5 4,价值为6 3 5 4 6,背包重量为10，物品不可重复
 * m{i,j} = Max{m{[i-1][j-w[i]} + v[i], m{i-1,j}}
 */

public class Package01 {
    public static void main(String[] args) {
        int[] weight = {0,2,2,6,5,4};
        int[] value = {0,6,3,5,4,6};
        int[][] m= new int[6][11];

        for(int i=0; i<6; i++){
            m[i][0] = 0;
        }
        for(int j=0; j<11; j++){
            m[0][j] = 0;
        }
        for(int i=1; i<6; i++){
            for(int j=1; j<=10;j++){
                if(j >= weight[i]){
                    m[i][j] = Math.max(m[i-1][j-weight[i]]+value[i],m[i-1][j]);
                }else{
                    m[i][j] = m[i-1][j];
                }
            }
        }

        int max = 0;
        int index = 0;
        //查找value最大
        for(int j=0; j<=10; j++){
            if (m[5][j] >= max){
                max = m[5][j];
                index = j;
            }
        }

        System.out.println(max);

        int k=5;
        int l=index;
        while(k >=1 && l>=1){
            if(m[k][l] != m[k-1][l]){
                System.out.println(k);
                k=k-1;
                l = l-weight[k];
            }else{
                k=k-1;
            }
        }

    }

}
