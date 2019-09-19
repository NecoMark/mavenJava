package com.hillstone.Generics;

import java.util.Date;

/**
 * @author: ljyang
 * @date: 2019/9/5 20:54
 * @description
 */

public class Pair<T> {
    private T value;
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}


/**
 * 编译之后的Pair类
 * class Pair {
 * 	    private Object value;
 * 	    public Object getValue() {
 * 		    return value;
 *      }
 * 	    public void setValue(Object  value) {
 * 		    this.value = value;
 *      }
 * }
 *
 * 编译后子类的getValue()与setValue()方法与父类的参数不同，像是重载而不是重写，如果是重载，那么子类应该有两个setValue()方法
 * 实际子类只有一个setValue()方法，jvm会在子类中增加一个桥方法
 *     public void setValue(Object value){
 *         this.setValue((Date)value);
 *     }
 * 同样的在子类中有两个get方法
 *     public Object getValue(){
 *         return this.getValue();
 *     }
 * 两个get方法参数相同（无参），但是，在虚拟机中，用参数类型和返回类型确定一个方法。
 *
 */


class DateInter extends Pair<Date>{

    @Override
    public Date getValue() {
        return super.getValue();
    }




    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

}