package com.hillstone.comparedemo;

/**
 * @author: ljyang
 * @date: 2019/9/22 16:04
 * @description
 * Compareable接口中的compareTo方法只有一个参数
 * 比较 一个实现Compareable接口的对象与其他对象
 * Comparator接口中的compare方法有两个参数，
 * 一个Comparator实例是一个比较器，compare方法可以比较任意的两个对象
 */

public class CompareMain {
    public static void main(String[] args) {
        Goods goods1 = new Goods(1,2);
        Goods goods2 = new Goods(1,3);
        if(goods1.compareTo(goods2) == -1){

        }
    }


}


class Goods implements Comparable<Goods>{
    private int price;
    private int quality;

    public Goods() {
    }


    public Goods(int price, int quality) {
        this.price = price;
        this.quality = quality;
    }

    @Override
    public int compareTo(Goods o) {
        if((this.quality/this.price) > (o.quality/o.price)){
            return 1;
        }
        if((this.quality/this.price) < (o.quality/o.price)){
            return -1;
        }
        return 0;
    }
    /**
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Goods){
            Goods goods = (Goods)obj;
            if(goods.price.equals(this.price) &&
                    goods.quality.equals(this.quality)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return price.hashCode() + quality.hashCode();
    }
    */
}