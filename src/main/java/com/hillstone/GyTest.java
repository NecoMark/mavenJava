package com.hillstone;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: ljyang
 * @date: 2019/7/26 16:01
 * @description
 */
public class GyTest {
    public static void main(String[] args) {
        /**
         * 编译期报错，Container<Child>与Container<Parent>没有关系，泛型是不变的
         */
//        Container<Parent> container = new Container<Child>();

        /**
         * 数组是协变的Child[]是Parent[]的子类
         */
        Parent[] parents = new Child[10];

        World world = new World();
        world.play3();

        List<Child> cList = new ArrayList<Child>();
        List<? extends Parent> pList = cList;
        /**
         * pList中不能添加除null以外的任何对象，
         * cList向上转型为pList，因为? extends 导致pList引用没有指定具体的类型，编译器并不知道pList引用指向的list中的数据的具体类型,
         * 编译器无法验证“任何事物”的类型安全
         * add(E(? extends Parent) e)方法的参数为泛型，所以拒绝添加未知类型的对象
         * 但是可以get一个类型为Parent的对象,
         */

//        pList.add(new Child());
//        pList.get(0);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ListIterator li = list.listIterator(1);
//        li.set(2);
        System.out.println(list);
//        ConcurrentHashMap
//        System.out.println(Integer.lowestOneBit());

        int a = Integer.MAX_VALUE;

        System.out.println(a);

        TreeMap<Container, Integer> treeMap = new TreeMap<>();


    }
}

class Container<T>{
    public void add(T t){

    }
}

class Parent{}
class Child extends Parent{}

class World<T>{
    public void play(Container<? extends Parent> container){
        /**
         * 显然往里面放Parent、Child、Object都是非法的。
         * 编译器不知道Container<? extends Parent>所持有的具体类型是什么，
         * 所以一旦执行这种类型的向上转型，你就将丢失掉向其中传递任何对象的能力。
         * 泛型把类型检查移到了编译期，协变过程丢掉了类型信息，编译器拒绝所有不安全的操作。
         * 泛型类型参数将擦除到它的第一个边界 Parent
         */
//        container.add(new Child());
    }

    public void play2(Container<? super Child> container){
        container.add(new Child());
    }
    @SuppressWarnings("unchecked")
    public void play3(){
        /**
         * 创建泛型数组的唯一方式就是创建一个被擦除类型的新数组，然后对其转型，不能使用T[] array = new T[size];
         *
         */
        T[] t = (T[])new Object[10];
        ArrayMaker<Integer>[] array = (ArrayMaker<Integer>[])new ArrayMaker[10];
        array[0] = new ArrayMaker<>();
        System.out.println(Arrays.toString(array));
        //


    }

}

class ArrayMaker<T>{
    public ArrayMaker() {
    }

    /**
     * 引入类型标签Class对擦除进行补偿
     */

    private Class<T> kind;
    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    T[] create(int size){
        /**
         * 擦除丢失了在泛型代码中执行某些操作的能力。
         * 任何运行时都需要知道确切的类型信息的操作都无法工作。
         */
        /*
        String a = "1";
        if (a instanceof T){

        }
        T t = new T();
        T[] array = new T[size];
        */
        return (T[]) Array.newInstance(kind, size);
    }

}

